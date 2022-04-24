data class Note(
    val id: Int = 1,
    val ownerId: Int =  1,
    val title: String ="",
    val text: String = "",
    val date: Int = 1,
    val comments: Int = 1,
    val readComments: Int = 1,
    val viewUrl: String ="",
    val canComment: Int = 1,
    val textWiki: String =""
)
