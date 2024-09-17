package com.expediagroup.sdk.v2.core.trait.common

import com.expediagroup.sdk.v2.core.trait.Trait
import java.util.UUID

interface IdTrait: Trait {
    val id: UUID
        get() = UUID.randomUUID()
}