import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeNode

@Composable fun Text(text: String) {
  ComposeNode<MarkdownNode, MarkdownApplier>(
    factory = { MarkdownNode(text) },
    update = {},
  )
}
