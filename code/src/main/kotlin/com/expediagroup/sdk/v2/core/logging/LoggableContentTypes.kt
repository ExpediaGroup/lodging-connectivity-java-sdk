package com.expediagroup.sdk.v2.core.logging

import org.apache.http.entity.ContentType

/**
 * A list of MIME types representing content types that are deemed loggable.
 * This collection is used to determine whether the content of HTTP requests or responses
 * can be logged based on their MIME types.
 */
val LOGGABLE_CONTENT_TYPES = buildList<String> {
    add(ContentType.APPLICATION_ATOM_XML.mimeType)
    add(ContentType.APPLICATION_JSON.mimeType)
    add(ContentType.APPLICATION_XML.mimeType)
    add(ContentType.APPLICATION_FORM_URLENCODED.mimeType)
    add(ContentType.APPLICATION_SOAP_XML.mimeType)
    add(ContentType.APPLICATION_XHTML_XML.mimeType)
    add(ContentType.TEXT_PLAIN.mimeType)
    add(ContentType.TEXT_HTML.mimeType)
    add(ContentType.TEXT_XML.mimeType)
    add(ContentType.DEFAULT_TEXT.mimeType)
}