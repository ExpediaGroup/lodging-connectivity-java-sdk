package com.expediagroup.sdk.core.http

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class StatusTest {

    @Test
    fun `should return correct Status for valid codes`() {
        assertEquals(Status.CONTINUE, Status.fromCode(100))
        assertEquals(Status.OK, Status.fromCode(200))
        assertEquals(Status.MOVED_PERMANENTLY, Status.fromCode(301))
        assertEquals(Status.BAD_REQUEST, Status.fromCode(400))
        assertEquals(Status.INTERNAL_SERVER_ERROR, Status.fromCode(500))
        assertEquals(Status.THIS_IS_FINE, Status.fromCode(218))
    }

    @Test
    fun `should throw IllegalArgumentException for invalid codes`() {
        val exception = assertThrows<IllegalArgumentException> {
            Status.fromCode(999)
        }
        assertEquals("Invalid status code: 999", exception.message)
    }

    @Test
    fun `should match all enum entries with their codes`() {
        Status.entries.forEach { status ->
            assertEquals(status, Status.fromCode(status.code))
        }
    }
}
