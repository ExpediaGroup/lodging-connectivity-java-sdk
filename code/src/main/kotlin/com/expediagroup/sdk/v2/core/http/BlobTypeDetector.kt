package com.expediagroup.sdk.v2.core.http

import org.apache.tika.Tika

/**
 * A utility class for detecting the type of binary large objects (BLOBs) using Apache Tika.
 *
 * This class is a singleton, which means it restricts the instantiation to one object.
 * It inherits from the Tika class provided by Apache Tika library.
 */
class BlobTypeDetector private constructor(): Tika() {
    companion object {
        @JvmStatic
        private val tika = Tika()

        @JvmStatic
        fun getInstance(): BlobTypeDetector {
            return BlobTypeDetector()
        }
    }
}