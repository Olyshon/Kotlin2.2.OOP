class Note(id: Int, val text: String, val comments: MutableList<Comment> = mutableListOf()) : ElementId(id) {
    val ownerId: Int = 1
    val title: String = ""
    val date: Int = 1
    val readComments: Int = 1
    val viewUrl: String = ""
    val canComment: Int = 1
    val textWiki: String = ""
    override fun toString(): String {
        return "$id: $text   Комментарии: $comments"
    }
}