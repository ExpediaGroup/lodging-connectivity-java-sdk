package com.expediagroup.sdk.v2.core.trait.configuration

import com.expediagroup.sdk.v2.core.trait.common.ConfigurationTrait
import com.expediagroup.sdk.v2.core.trait.common.IdTrait

/**
 * Interface that combines configuration traits with an identifier.
 *
 * This interface extends from `ConfigurationTrait` and `IdTrait`, thereby inheriting the
 * behavior of configuration management and uniquely identifying the configured client-instances
 * with a universally unique identifier (UUID).
 *
 * Implementing classes are expected to manage lower-level client configurations and may
 * utilize the inherited `id` property to differentiate between instances.
 */
interface ClientConfiguration: ConfigurationTrait, IdTrait
