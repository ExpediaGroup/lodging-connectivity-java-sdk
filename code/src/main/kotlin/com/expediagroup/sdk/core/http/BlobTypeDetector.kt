package com.expediagroup.sdk.core.http

import org.apache.tika.Tika

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