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

/**
 * Custom Apollo Compiler Plugin to enhance generated Kotlin code by adding a static builder method when applicable.
 */
class StaticBuilderPlugin : ApolloCompilerPlugin {
    override fun kotlinOutputTransform(): Transform<KotlinOutput> {
        return object : Transform<KotlinOutput> {
            override fun transform(input: KotlinOutput): KotlinOutput {
                return KotlinOutput(
                    fileSpecs = input.fileSpecs.map { kotlinFile ->
                        FileSpec.builder(kotlinFile.packageName, kotlinFile.name)
                            .apply {
                                kotlinFile.members.forEach { member ->
                                    when (member) {
                                        is TypeSpec -> {
                                            addType(processTypeSpec(member))
                                        }

                                        is FunSpec -> {
                                            addFunction(member)
                                        }

                                        is PropertySpec -> {
                                            addProperty(member)
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

    /**
     * Process the given TypeSpec to handle the presence of a nested "Builder" class.
     *
     * @param typeSpec the TypeSpec to process
     * @return the processed TypeSpec with necessary modifications for a "Builder" class if applicable
     */
    private fun processTypeSpec(typeSpec: TypeSpec): TypeSpec {
        if (typeSpec.kind != TypeSpec.Kind.CLASS) {
            return typeSpec
        }

        val hasBuilderClass = typeSpec.typeSpecs.any { it.name == "Builder" }

        if (!hasBuilderClass) {
            return typeSpec
        }

        val newTypeSpecBuilder = typeSpec.toBuilder()

        var hasCompanionObject = false
        val newNestedTypes = mutableListOf<TypeSpec>()

        typeSpec.typeSpecs.forEach {
            if (it.kind == TypeSpec.Kind.OBJECT && (it.name == null || it.name == "Companion")) {
                hasCompanionObject = true
                newNestedTypes.add(processCompanionObject(it, typeSpec.name ?: ""))
            } else {
                newNestedTypes.add(it)
            }
        }

        if (!hasCompanionObject) {
            newNestedTypes.add(createCompanionObjectWithBuilder(typeSpec.name ?: ""))
        }

        // Clear existing nested types and add the new ones
        newTypeSpecBuilder.typeSpecs.clear()
        newTypeSpecBuilder.addTypes(newNestedTypes)

        return newTypeSpecBuilder.build()
    }

    /**
     * Process the companion object to check for the presence of a builder method and add one if it doesn't exist.
     *
     * @param companionObject the companion object of type TypeSpec
     * @param enclosingClassName the name of the enclosing class as a String
     * @return the modified TypeSpec with the builder method added to the companion object if needed
     */
    private fun processCompanionObject(companionObject: TypeSpec, enclosingClassName: String): TypeSpec {
        val hasBuilderMethod = companionObject.funSpecs.any { it.name == "builder" }

        if (hasBuilderMethod) {
            return companionObject
        }

        return companionObject
            .toBuilder()
            .addFunction(constructBuilderStaticMethod(enclosingClassName))
            .build()
    }

    /**
     * Helper function to create a companion object with a builder method.
     *
     * @param enclosingClassName the name of the enclosing class as a String
     * @return the TypeSpec representing the companion object with the builder method
     */
    private fun createCompanionObjectWithBuilder(enclosingClassName: String) = TypeSpec
        .companionObjectBuilder()
        .addFunction(constructBuilderStaticMethod(enclosingClassName))
        .build()

    /**
     * Constructs a JvmStatic annotated function spec for a builder method within the specified enclosing class name.
     *
     * @param enclosingClassName the name of the enclosing class as a String
     */
    private fun constructBuilderStaticMethod(enclosingClassName: String) = FunSpec
        .builder("builder")
        .returns(ClassName("", enclosingClassName).nestedClass("Builder"))
        .addAnnotation(AnnotationSpec.builder(JvmStatic::class).build())
        .addStatement("return %T()", ClassName("", enclosingClassName).nestedClass("Builder"))
        .build()
}
