data class Chat(
    val idChat: Int = 0,
    val idSender: Int = 0,
    val idRecipient: Int = 0,
    val messages: MutableList<Message> = mutableListOf()
) {
    override fun toString(): String {
        return "Чат №$idChat: '$idSender' -> '$idRecipient', сообщения: $messages"
    }
}