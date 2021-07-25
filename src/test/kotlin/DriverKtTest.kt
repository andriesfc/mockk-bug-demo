import io.mockk.*
import org.junit.jupiter.api.Test

internal class DriverKtTest {

    @Test
    fun `Closeable Sequence Should Close Underlying Reader`() {

        val text = """
            Line 1
            Line 2
            Line 3
            Line 4
            """.trimIndent()

        val reader = spyk(text.reader().buffered()) {
            every { close() } just Runs
        }

        val closableSequence = reader.closableLineSequence()

        closableSequence.close()
        closableSequence.close()

        verify(exactly = 1) { reader.close() }

    }


}