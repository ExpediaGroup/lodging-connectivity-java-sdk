package com.expediagroup.sdk.apollo

import com.apollographql.apollo.annotations.ApolloExperimental
import com.apollographql.apollo.compiler.ApolloCompilerPlugin
import com.apollographql.apollo.compiler.ApolloCompilerPluginEnvironment
import com.apollographql.apollo.compiler.ApolloCompilerPluginProvider
import com.expediagroup.sdk.apollo.plugin.StaticBuilderPlugin

@OptIn(ApolloExperimental::class)
class PluginProvider : ApolloCompilerPluginProvider {
    override fun create(environment: ApolloCompilerPluginEnvironment): ApolloCompilerPlugin {
        return StaticBuilderPlugin()
    }
}
