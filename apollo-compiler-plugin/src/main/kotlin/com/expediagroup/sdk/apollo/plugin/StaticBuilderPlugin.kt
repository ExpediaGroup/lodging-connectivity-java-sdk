package com.expediagroup.sdk.apollo.plugin

import com.apollographql.apollo.compiler.ApolloCompilerPlugin
import com.apollographql.apollo.compiler.Transform
import com.apollographql.apollo.compiler.codegen.kotlin.KotlinOutput
import com.squareup.kotlinpoet.AnnotationSpec
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeSpec

class StaticBuilderPlugin: ApolloCompilerPlugin {
    override fun kotlinOutputTransform(): Transform<KotlinOutput>? {
        return object : Transform<KotlinOutput> {
            override fun transform(input: KotlinOutput): KotlinOutput {
                return KotlinOutput(
                    fileSpecs = input.fileSpecs.map { kotlinFile ->
                        FileSpec.builder(kotlinFile.packageName, kotlinFile.name)
                            .apply {
                                // Process members of the file
                                kotlinFile.members.forEach { member ->
                                    when (member) {
                                        is TypeSpec -> {
                                            // Process TypeSpec (classes, interfaces, etc.)
                                            val newTypeSpec = processTypeSpec(member)
                                            addType(newTypeSpec)
                                        }
                                        is FunSpec -> {
                                            // Add functions directly
                                            addFunction(member)
                                        }
                                        is PropertySpec -> {
                                            // Add properties directly
                                            addProperty(member)
                                        }
                                        else -> {
                                            // Handle other possible member types if necessary
                                        }
                                    }
                                }
                            }
                            .build()
                    },
                    codegenMetadata = input.codegenMetadata
                )
            }
        }
    }


    // Helper function to process TypeSpec
    private fun processTypeSpec(typeSpec: TypeSpec): TypeSpec {
        // Only process normal classes
        if (typeSpec.kind != TypeSpec.Kind.CLASS) {
            return typeSpec
        }

        // Check if the class has a nested "Builder" class
        val hasBuilderClass = typeSpec.typeSpecs.any { it.name == "Builder" }

        // If there's no Builder class, return the typeSpec unchanged
        if (!hasBuilderClass) {
            return typeSpec
        }

        // Create a new TypeSpec.Builder for the class
        val newTypeSpecBuilder = typeSpec.toBuilder()

        // Process nested types to find the companion object
        var hasCompanionObject = false
        val newNestedTypes = mutableListOf<TypeSpec>()
        for (nestedTypeSpec in typeSpec.typeSpecs) {
            if (nestedTypeSpec.kind == TypeSpec.Kind.OBJECT && (nestedTypeSpec.name == null || nestedTypeSpec.name == "Companion")) {
                hasCompanionObject = true
                // Process the companion object to add the builder method
                val processedCompanion = processCompanionObject(nestedTypeSpec, typeSpec.name ?: "")
                newNestedTypes.add(processedCompanion)
            } else {
                // Add other nested types as is
                newNestedTypes.add(nestedTypeSpec)
            }
        }

        // If there is no companion object, create one with the builder method
        if (!hasCompanionObject) {
            val companionObject = createCompanionObjectWithBuilder(typeSpec.name ?: "")
            newNestedTypes.add(companionObject)
        }

        // Clear existing nested types and add the new ones
        newTypeSpecBuilder.typeSpecs.clear()
        newTypeSpecBuilder.addTypes(newNestedTypes)

        // Build and return the new TypeSpec
        return newTypeSpecBuilder.build()
    }

    // Helper function to process the companion object
    private fun processCompanionObject(companionObject: TypeSpec, enclosingClassName: String): TypeSpec {
        // Check if the companion object already has a builder method
        val hasBuilderMethod = companionObject.funSpecs.any { it.name == "builder" }

        if (hasBuilderMethod) {
            // Companion object already has a builder method, return it as is
            return companionObject
        }

        // Create a builder from the existing companion object
        val companionBuilder = companionObject.toBuilder()

        // Create the builder function
        val jvmStaticAnnotation = AnnotationSpec.builder(JvmStatic::class).build()
        val builderFunction = FunSpec.builder("builder")
            .returns(ClassName("", enclosingClassName).nestedClass("Builder"))
            .addAnnotation(jvmStaticAnnotation)
            .addStatement("return %T()", ClassName("", enclosingClassName).nestedClass("Builder"))
            .build()

        // Add the builder function to the companion object
        companionBuilder.addFunction(builderFunction)

        // Build and return the modified companion object
        return companionBuilder.build()
    }

    // Helper function to create a companion object with the builder method
    private fun createCompanionObjectWithBuilder(enclosingClassName: String): TypeSpec {
        val jvmStaticAnnotation = AnnotationSpec.builder(JvmStatic::class).build()
        val builderFunction = FunSpec.builder("builder")
            .returns(ClassName("", enclosingClassName).nestedClass("Builder"))
            .addAnnotation(jvmStaticAnnotation)
            .addStatement("return %T()", ClassName("", enclosingClassName).nestedClass("Builder"))
            .build()

        val companionObject = TypeSpec.companionObjectBuilder()
            .addFunction(builderFunction)
            .build()

        return companionObject
    }
}
