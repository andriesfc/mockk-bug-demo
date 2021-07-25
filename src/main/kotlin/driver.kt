import java.io.BufferedReader
import java.io.Closeable

interface ClosableSequence<T> : Sequence<T>, Closeable

fun BufferedReader.closableLineSequence(): ClosableSequence<String> {
    return lineSequence().let { sequence ->
        object : Sequence<String> by sequence, ClosableSequence<String> {
            private var closed = false
            override fun close() {
                if (!closed) {
                    this@closableLineSequence.close()
                    closed = true
                }
            }
        }
    }
}
