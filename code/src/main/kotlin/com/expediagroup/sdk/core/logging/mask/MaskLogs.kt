package com.expediagroup.sdk.core.logging.mask

import com.ebay.ejmask.core.BaseFilter
import com.ebay.ejmask.core.EJMask
import com.ebay.ejmask.core.EJMaskInitializer
import com.ebay.ejmask.core.util.LoggerUtil

fun maskLogs(logs: String): String {
    return MaskLogs.execute(logs)
}

fun configureLogMasking(fields: Set<String>) {
    MaskLogs.addFields(fields)
}

fun isMaskedField(field: String): Boolean {
    return MaskLogs.maskedFields.contains(field)
}

private class MaskLogs: (String) -> String {
    companion object {
        @JvmStatic
        val filters: MutableList<BaseFilter> = mutableListOf()

        val maskedFields: MutableSet<String> = mutableSetOf()

        @JvmStatic
        val INSTANCE = MaskLogs()

        @JvmStatic
        fun execute(logs: String) = INSTANCE(logs)

        @JvmStatic
        fun addFields(fields: Set<String>) {
            maskedFields.addAll(fields)
            filters.add(ExpediaGroupJsonFieldFilter(fields.toTypedArray()))
            filters.forEach{ EJMaskInitializer.addFilter(it) }
        }
    }

    init {
        LoggerUtil.register { _, _, _ -> /* disable logging */ }
    }

    override fun invoke(text: String): String {
        return EJMask.mask(text)
    }
}