package com.expediagroup.sdk.core.logging.mask

import com.ebay.ejmask.core.BaseFilter
import com.ebay.ejmask.core.EJMask
import com.ebay.ejmask.core.EJMaskInitializer
import com.ebay.ejmask.core.util.LoggerUtil

/**
 * Masks sensitive information within the provided log string.
 *
 * @param logs The log string that may contain sensitive information requiring masking.
 * @return A new log string with sensitive information masked.
 */
fun maskLogs(logs: String): String {
    return MaskLogs.execute(logs)
}

/**
 * Configures log masking by adding specified fields to the mask list.
 *
 * This function integrates with the log masking system to include additional fields
 * that should be masked in the logs. The fields provided in the parameter are added
 * to the set of fields that will have their values masked when logs are generated.
 *
 * @param fields The set of field names that need to be masked in the logs.
 */
fun configureLogMasking(fields: Set<String>) {
    MaskLogs.addFields(fields)
}

/**
 * Checks if a specified field is among the fields that should be masked.
 *
 * @param field The name of the field to check.
 * @return `true` if the field should be masked, `false` otherwise.
 */
fun isMaskedField(field: String): Boolean {
    return MaskLogs.maskedFields.contains(field)
}

/**
 * A utility class for masking sensitive information in log strings.
 *
 * The `MaskLogs` class is designed to replace sensitive information within logs with masked values.
 * The class implements the `Function1` interface, enabling it to be invoked with a log string
 * to produce a masked version of the string.
 *
 * The masking process relies on predefined filters that determine which fields within the log
 * should be masked. Filters can be added and configured using the companion object's methods.
 */
private class MaskLogs : (String) -> String {
    companion object {
        @JvmStatic
        val filters: MutableList<BaseFilter> = mutableListOf()

        val maskedFields: MutableSet<String> = mutableSetOf()

        @JvmStatic
        val INSTANCE = MaskLogs()

        /**
         * Executes the masking process on the provided log string.
         *
         * @param logs The log string that may contain sensitive information requiring masking.
         */
        @JvmStatic
        fun execute(logs: String) = INSTANCE(logs)

        /**
         * Adds specified fields to the list of fields to be masked in logs.
         *
         * The fields provided in the parameter are added to the internal set of fields
         * and corresponding filters are created and added to the filter list. These filters
         * are then integrated into the masking system to ensure the specified fields are
         * masked in any logs they appear in.
         *
         * @param fields The set of field names that need to be masked in the logs.
         */
        @JvmStatic
        fun addFields(fields: Set<String>) {
            maskedFields.addAll(fields)
            filters.add(ExpediaGroupJsonFieldFilter(fields.toTypedArray()))
            filters.forEach { EJMaskInitializer.addFilter(it) }
        }
    }

    init {
        LoggerUtil.register { _, _, _ -> /* disable logging */ }
    }

    /**
     * Masks the given text using the EJMask utility.
     *
     * @param text The input text that needs to be masked.
     * @return The masked version of the input text.
     */
    override fun invoke(text: String): String {
        return EJMask.mask(text)
    }
}
