package com.expediagroup.sdk.core.trait.common

import com.expediagroup.sdk.core.trait.Trait
import java.util.UUID

/**
 * Interface representing a trait for unique identifier management in a class.
 *
 * Classes implementing this trait inherit the behavior of generating and handling
 * a universally unique identifier (UUID). The `id` property provides a generated UUID
 * that uniquely identifies an instance.
 */
interface IdTrait: Trait {
    val id: UUID
        get() = UUID.randomUUID()
}
