package com.expediagroup.sdk.logging.common

import org.slf4j.Logger

class LoggerDecorator(private val logger: Logger) : Logger by logger {
    override fun info(msg: String) = logger.info(decorate(msg))

    override fun warn(msg: String) = logger.warn(decorate(msg))

    override fun debug(msg: String) = logger.debug(decorate(msg))

    override fun error(msg: String) = logger.error(decorate(msg))

    override fun trace(msg: String) = logger.trace(decorate(msg))

    fun info(msg: String, vararg tags: String) = logger.info(decorate(msg, tags.toSet()))

    fun warn(msg: String, vararg tags: String) = logger.warn(decorate(msg, tags.toSet()))

    fun debug(msg: String, vararg tags: String) = logger.debug(decorate(msg, tags.toSet()))

    fun error(msg: String, vararg tags: String) = logger.error(decorate(msg, tags.toSet()))

    fun trace(msg: String, vararg tags: String) = logger.trace(decorate(msg, tags.toSet()))

    private fun decorate(msg: String, tags: Set<String>? = null): String = buildString {
        append("[${Constant.EXPEDIA_GROUP_SDK}] - ")
        tags?.let {
            append("[")
            append(it.joinToString(", "))
            append("] - ")
        }
        append(msg.trim())
    }
}
