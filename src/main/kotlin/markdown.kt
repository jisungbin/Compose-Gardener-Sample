import androidx.compose.runtime.Composable
import androidx.compose.runtime.Composition
import androidx.compose.runtime.withRunningRecomposer
import kotlin.coroutines.coroutineContext
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

fun main() {
  val markdown = runBlocking {
    markdown {
      Text("Hello Markdown!")
      Text("")
      Text("This is my list:")
      Text("")
      List {
        Text("First item")
        Text("Second item")
        Text("Third item")
      }
      Text("")
      Text("Goodbye Markdown!")
    }
  }
  println(markdown)
}

private suspend fun markdown(content: @Composable () -> Unit): String {
  val runningJob = Job(parent = coroutineContext[Job])
  val markdownJob = coroutineContext + runningJob + MarkdownFrameClock

  val markdown = MarkdownNode(text = null)
  var composition: Composition? = null

  withContext(markdownJob) {
    withRunningRecomposer { recomposer ->
      composition = Composition(applier = MarkdownApplier(markdown), parent = recomposer).apply {
        setContent(content)
      }
    }
  }

  runningJob.cancelAndJoin()
  return markdown.toString().also { composition?.dispose() }
}
