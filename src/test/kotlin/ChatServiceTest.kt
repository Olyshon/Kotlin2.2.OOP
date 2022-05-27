import org.junit.Test

import org.junit.Assert.*

class ChatServiceTest {

    @Test
    fun addChatSuccess() {
        //Arrange
        val chatService = ChatService()
        val testMessage1 = Message(0, 1, "аа")
        //Act
        chatService.addChat(listOf(1, 2), testMessage1)
        //Assert
        assertEquals(testMessage1, chatService.chats[listOf(1, 2)]?.messages?.get(0))
    }

    @Test
    fun deleteChatSuccess() {
        //Arrange
        val chatService = ChatService()
        val testMessage1 = Message(0, 1, "аа")
        val testChat1 = chatService.addMessage(listOf(1, 2), testMessage1)
        //Act
        chatService.deleteChat(listOf(1, 2))
        //Assert
        assertNotEquals(testChat1, chatService.chats[listOf(1, 2)])
    }

    @Test
    fun addMessageSuccess() {
        //Arrange
        val chatService = ChatService()
        val testMessage1 = Message(0, 1, "аа")
        //Act
        chatService.addMessage(listOf(1, 2), testMessage1)
        //Assert
        assertEquals(testMessage1, chatService.chats[listOf(1, 2)]?.messages?.get(0))
    }

    @Test
    fun deleteMessageSuccess() {
        //Arrange
        val chatService = ChatService()
        val testMessage1 = Message(0, 1, "аа")
        val testMessage2 = Message(0, 2, "бб")
        chatService.addMessage(listOf(1, 2), testMessage1)
        chatService.addMessage(listOf(1, 2), testMessage2)
        //Act
        chatService.deleteMessage(listOf(1, 2), testMessage1)
        //Assert
        assertNotEquals(testMessage1, chatService.chats[listOf(1, 2)]?.messages?.get(0))
    }

    @Test
    fun deleteMessageNull() {
        //Arrange
        val chatService = ChatService()
        val testMessage1 = Message(0, 1, "аа")
        chatService.addMessage(listOf(1, 2), testMessage1)
        //Act
        chatService.deleteMessage(listOf(1, 2), testMessage1)
        //Assert
        assertEquals(null, chatService.chats[listOf(1, 2)]?.messages?.get(0))
    }

    @Test
    fun unreadChatsList() {
        //Arrange
        val chatService = ChatService()
        val testMessage1 = Message(0, 2, "аа")
        val testMessage2 = Message(0, 3, "бб")
        val testMessage3 = Message(0, 4, "вв")
        chatService.addMessage(listOf(2, 1), testMessage1)
        chatService.addMessage(listOf(3, 1), testMessage2)
        chatService.addMessage(listOf(4, 1), testMessage3)
        //Act
        val listMes = chatService.unreadChatsList(1)
        //Assert
        assertEquals(3, listMes.size)
    }

    @Test
    fun unreadMessagesCountOne() {
        //Arrange
        val chatService = ChatService()
        val testMessage1 = Message(0, 1, "аа")
        chatService.addMessage(listOf(1, 2), testMessage1)
        //Act
        val count = chatService.unreadMessagesCount(1, 1)
        //Assert
        assertEquals(1, count)
    }

    @Test
    fun getMessagesSuccess() {
        //Arrange
        val chatService = ChatService()
        val testMessage1 = Message(0, 1, "аа")
        chatService.addMessage(listOf(1, 2), testMessage1)
        //Act
        chatService.getMessages(1, 1, 1)
        //Assert
        assertEquals(testMessage1, chatService.chats[listOf(1, 2)]?.messages?.get(0))
    }

}