/*
 * Copyright (C) 2024 Expedia, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.expediagroup.sdk.core2.http

import com.expediagroup.sdk.core2.http.ContentType.entries


/**
 * Enum representing various content types, with their associated MIME type strings.
 *
 * This enum provides a predefined set of commonly used MIME types for applications,
 * making it easy to manage and reference content types in a consistent manner.
 *
 * @param mimeType The MIME type string associated with the content type.
 */
enum class ContentType(val mimeType: String) {
    /**
     * MIME type for Atom feeds.
     */
    APPLICATION_ATOM_XML("application/atom+xml"),

    /**
     * MIME type for JSON data.
     */
    APPLICATION_JSON("application/json"),

    /**
     * MIME type for generic XML data.
     */
    APPLICATION_XML("application/xml"),

    /**
     * MIME type for form data submitted as URL-encoded values.
     */
    APPLICATION_FORM_URLENCODED("application/x-www-form-urlencoded"),

    /**
     * MIME type for SOAP XML messages.
     */
    APPLICATION_SOAP_XML("application/soap+xml"),

    /**
     * MIME type for XHTML documents.
     */
    APPLICATION_XHTML_XML("application/xhtml+xml"),

    /**
     * MIME type for plain text.
     */
    TEXT_PLAIN("text/plain"),

    /**
     * MIME type for HTML documents.
     */
    TEXT_HTML("text/html"),

    /**
     * MIME type for XML text.
     */
    TEXT_XML("text/xml"),

    /**
     * Wildcard MIME type for any text-based content.
     */
    DEFAULT_TEXT("text/*");

    companion object {
        /**
         * Finds a [ContentType] by its MIME type string.
         *
         * @param mimeType The MIME type string to search for.
         * @return The matching [ContentType], or `null` if no match is found.
         */
        fun fromMimeType(mimeType: String): ContentType? {
            return entries.find { it.mimeType.equals(mimeType, ignoreCase = true) }
        }
    }
}

