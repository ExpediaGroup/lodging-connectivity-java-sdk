package com.expediagroup.sdk.v2.core.trait.common

import com.expediagroup.sdk.v2.core.trait.Trait

/**
 * Defines a trait for building instances of a specific type.
 *
 * @param BuiltType The type of object that this builder will create.
 */
interface BuilderTrait<BuiltType>: Trait {
    fun build(): BuiltType
}
