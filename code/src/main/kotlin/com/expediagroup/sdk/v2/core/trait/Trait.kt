package com.expediagroup.sdk.v2.core.trait

interface Trait {
    companion object {
        fun implementsTraits(obj: Any?, traits: List<Class<*>>): Boolean =
            traits.all {
                Trait::class.java.isAssignableFrom(it)
                        && it.isInstance(obj)
            }
    }
}