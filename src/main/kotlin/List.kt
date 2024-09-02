import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeNode

@Composable fun List(content: @Composable () -> Unit) {
  ComposeNode<MarkdownNode, MarkdownApplier>(
    factory = { MarkdownNode(text = null, list = true) },
    update = {},
    content = content,
  )
}
