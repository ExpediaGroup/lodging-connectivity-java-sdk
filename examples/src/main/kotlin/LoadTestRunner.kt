import com.expediagroup.sdk.core.http.Method
import com.expediagroup.sdk.core.http.Request
import com.expediagroup.sdk.core.pipeline.ExecutionPipeline
import com.expediagroup.sdk.core.transport.AbstractRequestExecutor
import java.time.Duration
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger
import java.util.concurrent.atomic.AtomicLong
import kotlin.math.roundToLong

class LoadTestRunner(private val client: AbstractRequestExecutor) {
    // Metrics collection
    class MetricsRecorder {
        val totalRequests = AtomicInteger()
        val totalErrors = AtomicInteger()
        val totalLatency = AtomicLong()

        fun recordRequest(latency: Long) {
            totalRequests.incrementAndGet()
            totalLatency.addAndGet(latency)
        }

        fun recordError() {
            totalErrors.incrementAndGet()
        }

        fun averageLatency(): Double {
            val total = totalLatency.get()
            val count = totalRequests.get().toDouble()
            return if (count > 0) total / count else 0.0
        }
    }

    fun runLoadTest(
        threads: Int = 10,
        duration: Duration = Duration.ofSeconds(30),
        warmUpSeconds: Int = 5
    ): MetricsRecorder {
        val metrics = MetricsRecorder()
        val executor = Executors.newFixedThreadPool(threads)

        // Warm-up phase
//        println("Starting warm-up...")
//        runWarmUp(warmUpSeconds, executor)
//        println("Warm-up completed")

        // Test phase
        println("Starting load test...")
        val testDurationNanos = duration.toNanos()
        val startTime = System.nanoTime()

        repeat(threads) {
            executor.submit {
                while (System.nanoTime() - startTime < testDurationNanos) {
                    val start = System.currentTimeMillis()
                    try {
                        val request = Request.builder().url("http://localhost:8080/hello").method(Method.GET).build()
                        client.execute(request) // Replace with your actual method
                        val latency = System.currentTimeMillis() - start
                        metrics.recordRequest(latency)
                    } catch (e: Exception) {
                        metrics.recordError()
                    }
                }
            }
        }

        executor.shutdown()
        executor.awaitTermination(duration.toMinutes() / 60 + 10, TimeUnit.SECONDS)
        return metrics
    }

    private fun runWarmUp(warmUpSeconds: Int, executor: ExecutorService) {
        val warmUpEnd = System.currentTimeMillis() + warmUpSeconds * 1000
        repeat(Runtime.getRuntime().availableProcessors() * 2) {
            executor.submit {
                while (System.currentTimeMillis() < warmUpEnd) {
                    try {
                        val request = Request.builder().url("http://localhost:8081/hello").method(Method.GET).build()
                        client.execute(request) // Replace with your actual method
                    } catch (e: Exception) {
                        // Ignore warm-up errors
                    }
                }
            }
        }
        Thread.sleep(warmUpSeconds * 1000L)
    }
}

// Usage example
fun main() {
    val client = object : AbstractRequestExecutor() {
        override val executionPipeline: ExecutionPipeline = ExecutionPipeline(emptyList(), emptyList())
    }

    val loadTester = LoadTestRunner(client)

    val testDuration = Duration.ofMinutes(1)

    val metrics = loadTester.runLoadTest(
        threads = 50,
        duration = testDuration,
        warmUpSeconds = 10
    )

    println("\n=== Load Test Results ===")
    println("Total requests: ${metrics.totalRequests.get()}")
    println("Total errors: ${metrics.totalErrors.get()}")
    println("Average latency: ${metrics.averageLatency().roundToLong()} ms")
    println("Requests/sec: ${metrics.totalRequests.get() / testDuration.seconds}")
    println("Error rate: ${(metrics.totalErrors.get().toDouble() / metrics.totalRequests.get()) * 100}%")
}