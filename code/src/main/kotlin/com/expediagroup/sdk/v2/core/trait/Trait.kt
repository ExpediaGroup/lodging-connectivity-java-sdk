package com.expediagroup.sdk.v2.core.trait

/**
 * Marker interface for defining traits in a class. Traits serve as a means to define common
 * behaviors or attributes that can be shared across different implementations.
 */
interface Trait {
    companion object {
        fun implementsTraits(obj: Any?, traits: List<Class<*>>): Boolean =
            traits.all {
                Trait::class.java.isAssignableFrom(it)
                        && it.isInstance(obj)
            }
    }
}