package com.expediagroup.sdk.core.authentication.bearer

import com.expediagroup.sdk.core.http.CommonMediaTypes
import com.expediagroup.sdk.core.http.Method
import com.expediagroup.sdk.core.http.Protocol
import com.expediagroup.sdk.core.http.Request
import com.expediagroup.sdk.core.http.Response
import com.expediagroup.sdk.core.http.ResponseBody
import com.expediagroup.sdk.core.http.Status
import com.expediagroup.sdk.core.model.exception.client.ExpediaGroupResponseParsingException
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class TokenResponseTest {
    @Test
    fun `parsed instances accessToken value should map to api response`() {
        val accessToken: String = "token"
        var available: Int? = null
        val tokenResponse = TokenResponse.parse(
            Response.builder()
                .body(
                    ResponseBody.create(
                        """{ "access_token": "$accessToken", "expires_in": 3600 }""".toByteArray().inputStream().also {
                            available = it.available()
                        },
                        CommonMediaTypes.APPLICATION_FORM_URLENCODED,
                        available!!.toLong()
                    )
                )
                .status(Status.ACCEPTED)
                .protocol(Protocol.HTTP_1_1)
                .message("Accepted")
                .request(Request.builder().url("http://localhost").method(Method.POST).build())
                .build()
        )

        assertEquals(tokenResponse.accessToken, accessToken)
    }

    @Test
    fun `parse results instances expiresIn value should map to api response`() {
        val expiresIn: Long = 3600L
        var available: Int? = null
        val tokenResponse = TokenResponse.parse(
            Response.builder()
                .body(
                    ResponseBody.create(
                        """{ "access_token": "accessToken", "expires_in": $expiresIn }""".toByteArray().inputStream().also {
                            available = it.available()
                        },
                        CommonMediaTypes.APPLICATION_FORM_URLENCODED,
                        available!!.toLong()
                    )
                )
                .status(Status.ACCEPTED)
                .protocol(Protocol.HTTP_1_1)
                .message("Accepted")
                .request(Request.builder().url("http://localhost").method(Method.POST).build())
                .build()
        )

        assertEquals(tokenResponse.expiresIn, expiresIn)
    }

    @Test
    fun `parse should throw ExpediaGroupResponseParsingException in case of unsuccessful response`() {
        assertThrows<ExpediaGroupResponseParsingException> {
            TokenResponse.parse(
                Response.builder()
                    .status(Status.INTERNAL_SERVER_ERROR)
                    .protocol(Protocol.HTTP_1_1)
                    .message(Status.INTERNAL_SERVER_ERROR.name)
                    .request(Request.builder().url("http://localhost").method(Method.POST).build())
                    .build()
            )
        }
    }

    @Test
    fun `parse should throw ExpediaGroupResponseParsingException if access_token or expiresIn are missing`() {
        var available: Int? = null
        assertThrows<ExpediaGroupResponseParsingException> {
            TokenResponse.parse(
                Response.builder()
                    .body(
                        ResponseBody.create(
                            """{ "expires_in": 3600 }""".toByteArray().inputStream().also { available = it.available() },
                            CommonMediaTypes.APPLICATION_FORM_URLENCODED,
                            available!!.toLong()
                        )
                    )
                    .status(Status.ACCEPTED)
                    .protocol(Protocol.HTTP_1_1)
                    .message("Accepted")
                    .request(Request.builder().url("http://localhost").method(Method.POST).build())
                    .build()
            )
        }
    }

    @Test
    fun `parse should ignore extra fields as long as access_token and expires_in are present`() {
        val accessToken: String = "token"
        val expiresIn: Long = 3600L
        var available: Int? = null
        val tokenResponse = TokenResponse.parse(
            Response.builder()
                .body(
                    ResponseBody.create(
                        """{ "access_token": "$accessToken", "expires_in": $expiresIn, "extra": "random" }""".toByteArray().inputStream().also {
                            available = it.available()
                        },
                        CommonMediaTypes.APPLICATION_FORM_URLENCODED,
                        available!!.toLong()
                    )
                )
                .status(Status.ACCEPTED)
                .protocol(Protocol.HTTP_1_1)
                .message("Accepted")
                .request(Request.builder().url("http://localhost").method(Method.POST).build())
                .build()
        )

        assertEquals(tokenResponse.accessToken, accessToken)
        assertEquals(tokenResponse.expiresIn, expiresIn)
    }
}
