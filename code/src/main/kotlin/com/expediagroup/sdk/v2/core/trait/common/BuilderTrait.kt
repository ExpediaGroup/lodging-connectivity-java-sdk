package com.expediagroup.sdk.v2.core.trait.common

import com.expediagroup.sdk.v2.core.trait.Trait

interface BuilderTrait<BuiltType>: Trait {
    fun build(): BuiltType
}
