package mocks

import com.expediagroup.sdk.core.http.HttpStatus
import com.google.api.client.auth.oauth2.TokenResponse
import com.google.api.client.http.HttpStatusCodes
import com.google.api.client.http.LowLevelHttpResponse
import com.google.api.client.json.GenericJson
import com.google.api.client.testing.http.MockLowLevelHttpResponse


class AuthenticationResponseFactory {
    companion object {
        @JvmStatic
        fun createSuccessful(
            tokenResponse: TokenResponse
        ): MockLowLevelHttpResponse =
            MockLowLevelHttpResponse().apply {
                setContentType("application/json")
                setContent(tokenResponse.factory.toPrettyString(tokenResponse))

                setStatusCode(200)
                setReasonPhrase("Ok")
            }

        fun createUnsuccessful() =
            MockLowLevelHttpResponse().apply {
                setContentType("application/json")
                setContent("Unsuccessful")
                setStatusCode(401)
            }
    }
}

class ApiResponseFactory {
    companion object {
        @JvmStatic
        fun createSuccessful(
            headers: Map<String, Any> = emptyMap(),
            body: GenericJson = GenericJson(),
        ): LowLevelHttpResponse =
            MockLowLevelHttpResponse().apply {
                setContentType("application/json")

                headers.forEach { (key, value) -> addHeader(key, value.toString()) }

                setStatusCode(HttpStatusCodes.STATUS_CODE_OK)
                setReasonPhrase("OK")
                setContent(body.toPrettyString())
            }

        fun createUnsuccessful(errorStatus: HttpStatus) =
            MockLowLevelHttpResponse().apply {
                setContentType("application/json")
                setStatusCode(HttpStatusCodes.STATUS_CODE_SERVER_ERROR)
                setReasonPhrase("Internal Server Error")
                setContent("Unsuccessful")
            }
    }
}
