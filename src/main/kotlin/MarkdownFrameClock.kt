import androidx.compose.runtime.MonotonicFrameClock

object MarkdownFrameClock : MonotonicFrameClock {
  override suspend fun <R> withFrameNanos(onFrame: (frameTimeNanos: Long) -> R): R =
    onFrame(0L) // frame time is not used in markdown
}
