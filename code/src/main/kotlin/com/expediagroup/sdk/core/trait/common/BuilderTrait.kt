package com.expediagroup.sdk.core.trait.common

import com.expediagroup.sdk.core.trait.Trait

/**
 * Defines a trait for building instances of a specific type.
 *
 * @param BuiltType The type of object that this builder will create.
 */
interface BuilderTrait<BuiltType>: Trait {
    fun build(): BuiltType
}
