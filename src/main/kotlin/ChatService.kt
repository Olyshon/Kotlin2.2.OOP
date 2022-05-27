import org.ietf.jgss.MessageProp

class ChatService {
    val chats = hashMapOf<List<Int>, Chat>()

    fun getChats(userId: Int): List<Chat> {
        return chats
            .filter { entry -> entry.key.contains(userId) }
            .values
            .toList()
    }

    fun getChat(userId: Int, chatId: Int): Chat? {
        return getChats(userId)
            .find { it.idChat == chatId }
    }

    fun addChat(userIds: List<Int>, message: Message): Chat {
        return chats
            .getOrPut(userIds) {
                Chat(
                    uniqueChatId(),
                    userIds[0],
                    userIds[1],
                    mutableListOf(message)
                )
            }
    }

    fun deleteChat(userIds: List<Int>): Chat? {
        return chats.remove(userIds)
    }

    fun addMessage(userIds: List<Int>, message: Message): Chat {
        val newChatId = uniqueChatId()
        message.idMess = uniqueMessageId(userIds)
        return chats
            .getOrPut(userIds) {
                Chat(newChatId, userIds[0], userIds[1])
            }
            .apply {
                messages.add(message)
            }
    }

    fun deleteMessage(userIds: List<Int>, message: Message): Chat? {
        chats[userIds]?.apply { messages.remove(message) }
        if (chats[userIds]?.messages?.isEmpty() == true) {
            deleteChat(userIds)
            return null
        }
        return chats[userIds]
    }


    fun unreadChatsList(userId: Int): List<Message> {
        val allChats = getChats(userId)
        var unReadMes = listOf<Message>()

        allChats.forEach { chat ->
            unReadMes += chat.messages
                .filter { !it.isRead }
        }
        return unReadMes
    }

    fun unreadMessagesCount(userId: Int, chatId: Int): Int? {
        val chat = getChat(userId, chatId)
        val updateMess = chat?.messages
            ?.map { it.copy(isRead = true) }
        return updateMess?.size
    }

    fun getMessages(userId: Int, chatId: Int, messageCount: Int): List<Message>? {
        val chat = getChat(userId, chatId)
        val updateMess = chat?.messages
            ?.take(messageCount)
            ?.map { it.copy(isRead = true) }
        return updateMess
    }

    private fun uniqueChatId(): Int {
        return chats.maxOfOrNull { it.value.idChat }?.plus(1) ?: 1
    }

    private fun uniqueMessageId(userIds: List<Int>): Int {
        return chats[userIds]?.messages?.maxOf { it.idMess }?.plus(1) ?: 1
    }
}










