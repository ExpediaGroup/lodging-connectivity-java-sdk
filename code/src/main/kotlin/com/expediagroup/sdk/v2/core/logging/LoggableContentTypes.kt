package com.expediagroup.sdk.v2.core.logging

import org.apache.http.entity.ContentType

val LOGGABLE_CONTENT_TYPES = buildList<ContentType> {
    add(ContentType.APPLICATION_ATOM_XML)
    add(ContentType.APPLICATION_JSON)
    add(ContentType.APPLICATION_XML)
    add(ContentType.APPLICATION_FORM_URLENCODED)
    add(ContentType.APPLICATION_SOAP_XML)
    add(ContentType.APPLICATION_XHTML_XML)
    add(ContentType.TEXT_PLAIN)
    add(ContentType.TEXT_HTML)
    add(ContentType.TEXT_XML)
    add(ContentType.DEFAULT_TEXT)
}.map { it.mimeType }
