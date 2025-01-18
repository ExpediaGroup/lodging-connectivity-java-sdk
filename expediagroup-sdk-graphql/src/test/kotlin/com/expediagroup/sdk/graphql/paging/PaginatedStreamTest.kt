package com.expediagroup.sdk.graphql.paging

import java.util.stream.Collectors
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class TestPaginatedStream(private val pages: List<List<String?>>) : PaginatedStream<String?>() {
    private var pageIndex = 0

    override fun fetchNextPage(): List<String?> {
        return if (pageIndex < pages.size) pages[pageIndex++] else emptyList()
    }
}

class PaginatedStreamTest {

    @Test
    fun `should stream all items across multiple pages`() {
        val pages = listOf(
            listOf("item1", "item2"),
            listOf("item3", "item4"),
            listOf("item5")
        )

        val paginatedStream = TestPaginatedStream(pages)

        val result = paginatedStream.stream()

        assertEquals(listOf("item1", "item2", "item3", "item4", "item5"), result.collect(Collectors.toList()))
    }

    @Test
    fun `should stream items from a single page`() {
        val pages = listOf(
            listOf("item1", "item2", "item3")
        )
        val stream = TestPaginatedStream(pages)

        val result = stream.stream()
        assertEquals(listOf("item1", "item2", "item3"), result.collect(Collectors.toList()))
    }

    @Test
    fun `should return an empty stream when there are no items`() {
        val pages = emptyList<List<String>>() // No pages at all
        val stream = TestPaginatedStream(pages)

        val result = stream.stream()
        assertTrue(result.collect(Collectors.toList()).isEmpty())
    }

    @Test
    fun `should fetch pages lazily`() {
        val pages = listOf(
            listOf("item1", "item2"),
            listOf("item3", "item4")
        )
        val stream = TestPaginatedStream(pages)

        val iterator = stream.stream().iterator()
        assertTrue(iterator.hasNext())
        assertEquals("item1", iterator.next())
        assertEquals("item2", iterator.next())
        assertEquals("item3", iterator.next())
        assertEquals("item4", iterator.next())
        assertFalse(iterator.hasNext())
    }

    @Test
    fun `should handle null items in pages`() {
        val pages = listOf(
            listOf("item1", null, "item2"),
            listOf("item3")
        )
        val stream = TestPaginatedStream(pages)

        val result = stream.stream()
        assertEquals(listOf("item1", "item2", "item3"), result.collect(Collectors.toList()))
    }
}
