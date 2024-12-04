package com.expediagroup.sdk.core.http

 object CommonMediaTypes {
     // Text Types
     val TEXT_PLAIN = MediaType.of("text", "plain")
     val TEXT_HTML = MediaType.of("text", "html")
     val TEXT_CSS = MediaType.of("text", "css")
     val TEXT_JAVASCRIPT = MediaType.of("text", "javascript")
     val TEXT_CSV = MediaType.of("text", "csv")

     // Application Types
     val APPLICATION_JSON = MediaType.of("application", "json")
     val APPLICATION_XML = MediaType.of("application", "xml")
     val APPLICATION_FORM_URLENCODED = MediaType.of("application", "x-www-form-urlencoded")
     val APPLICATION_OCTET_STREAM = MediaType.of("application", "octet-stream")
     val APPLICATION_PDF = MediaType.of("application", "pdf")
     val APPLICATION_VND_API_JSON = MediaType.of("application", "vnd.api+json")
     val APPLICATION_JSON_GRAPHQL = MediaType.of("application", "json+graphql")
     val APPLICATION_HAL_JSON = MediaType.of("application", "hal+json")
     val APPLICATION_PROBLEM_JSON = MediaType.of("application", "problem+json")
     val APPLICATION_ZIP = MediaType.of("application", "zip")

     // Image Types
     val IMAGE_JPEG = MediaType.of("image", "jpeg")
     val IMAGE_PNG = MediaType.of("image", "png")
     val IMAGE_GIF = MediaType.of("image", "gif")
     val IMAGE_SVG_XML = MediaType.of("image", "svg+xml")

     // Audio/Video Types
     val AUDIO_MPEG = MediaType.of("audio", "mpeg")
     val AUDIO_WAV = MediaType.of("audio", "wav")
     val VIDEO_MP4 = MediaType.of("video", "mp4")
     val VIDEO_MPEG = MediaType.of("video", "mpeg")

     // Multipart Types
     val MULTIPART_FORM_DATA = MediaType.of("multipart", "form-data")
     val MULTIPART_BYTERANGES = MediaType.of("multipart", "byteranges")

     // Other Types
     val APPLICATION_JAVASCRIPT = MediaType.of("application", "javascript")
 }
