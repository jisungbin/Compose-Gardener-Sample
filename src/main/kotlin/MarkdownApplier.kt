import androidx.compose.runtime.Applier

class MarkdownApplier(private val root: MarkdownNode) : Applier<MarkdownNode> {
  private val stack = mutableListOf(root)
  override var current = root

  override fun insertTopDown(index: Int, instance: MarkdownNode) {
    if (current.list) instance.index = index
    current.children.add(instance)
  }

  override fun insertBottomUp(index: Int, instance: MarkdownNode) {
    // Ignored. We use `insertTopDown` instead.
  }

  override fun down(node: MarkdownNode) {
    stack += node
    current = node
  }

  override fun up() {
    stack.removeLast()
    current = stack.last()
  }

  override fun move(from: Int, to: Int, count: Int) {
    TODO("Not used in this sample.")
  }

  override fun remove(index: Int, count: Int) {
    TODO("Not used in this sample.")
  }

  override fun clear() {
    stack.clear()
    stack += root
    current = root
  }
}
