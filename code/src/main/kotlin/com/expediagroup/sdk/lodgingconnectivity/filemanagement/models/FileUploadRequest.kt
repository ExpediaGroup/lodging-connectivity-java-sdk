package com.expediagroup.sdk.lodgingconnectivity.filemanagement.models

import java.io.File
import java.io.InputStream

class FileUploadRequest private constructor(
    val content: Any?
) {

    constructor(file: File) : this(content = file)
    constructor(inputStream: InputStream) : this(content = inputStream)
}
