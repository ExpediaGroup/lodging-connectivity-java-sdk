package com.expediagroup.sdk.core.trait.common

import com.expediagroup.sdk.core.trait.Trait


/**
 * Interface for defining configuration traits.
 *
 * Classes implementing this interface signify that they possess configurable attributes
 * or behaviors which can be shared or reused across various implementations.
 *
 * This interface extends the `Trait` interface, indicating that it can be used as a marker
 * to define common functionalities or properties in a polymorphic way.
 */
interface ConfigurationTrait: Trait
