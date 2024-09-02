class MarkdownNode(
  private val text: String?,
  val list: Boolean = false,
  var index: Int? = null,
) {
  val children = mutableListOf<MarkdownNode>()

  override fun toString(): String = buildString {
    if (text != null) {
      val index = index
      if (index != null) append("${index + 1}. ")
      append(text)
    }
    children.iterator().let { children ->
      while (children.hasNext()) {
        append(children.next())
        if (children.hasNext()) appendLine()
      }
    }
  }
}
