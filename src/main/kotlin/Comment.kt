class Comment(var deleted: Boolean = false, val text: String = "", id: Int) : ElementId(id) {
    val postId: Long = 0   // Идентификатор поста комментария
    val from_id: Int = 0  // Идентификатор автора комментария.
    val date: Int = 0    // Дата создания комментария в формате Unixtime.
    val donut: Donut = Donut(false, "")      //Информация о записи VK Donut:
    val attachment: Attachment = NoteAttachment()
    val thread: Thread = Thread(
        0,
        false,
        true,
        groupsCanPost = true
    )         //Информация о вложенной ветке комментариев, объект с полями:
    val replyToUser: Int =
        0    //Идентификатор пользователя или сообщества, в ответ которому оставлен текущий комментарий (если применимо).
    val replyToComment: Int = 0 //Идентификатор комментария, в ответ на который оставлен текущий (если применимо).

    class Thread(
        val count: Int,                 //количество комментариев в ветке. .
        val canPost: Boolean,           // может ли текущий пользователь оставлять комментарии в этой ветке.
        val showReplyButton: Boolean,   // нужно ли отображать кнопку «ответить» в ветке.
        val groupsCanPost: Boolean      //– могут ли сообщества оставлять комментарии в ветке.
    )

    class Donut(
        val isDon: Boolean,              // является ли комментатор подписчиком VK Donut;
        val placeholder: String,         // заглушка для пользователей, которые не оформили подписку VK Donut. Отображается вместо содержимого записи.
    )

    override fun toString(): String {
        return "$id: $text   Удален: $deleted"
    }
}

