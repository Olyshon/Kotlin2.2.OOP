import java.util.*


fun main() {
    /*   val videoAttachment = VideoAttachment("video")
       val audioAttachment = AudioAttachment("audio")
       val docAttachment = DocAttachment("doc")
       val postNum1 = Post(
           text = "This is my first post",
           likes = Post.Likes(10u, userLikes = false, canLike = true, canPublish = true),
           attachment = videoAttachment
       )
       val postNum2 = Post(
           text = "This is my second post",
           likes = Post.Likes(200u, userLikes = false, canLike = true, canPublish = true),
           attachment = audioAttachment
       )

       val wallService = WallService()
       wallService.add(postNum1)
       val postNum2UP = wallService.add(postNum2)
       val postNum3 = Post(
           id = postNum2UP.id,
           text = "This is update second post",
           likes = Post.Likes(300u, userLikes = false, canLike = true, canPublish = true),
           attachment = docAttachment
       )
       wallService.update(postNum3)
       // wallService.createComment(comment)


       val noteService = NoteService()
       val testComment = Comment(false, "test note's comment", 1)
       val testComment2 = Comment(false, "second comment", 2)

       noteService.add(Note(1, "first note"))
       noteService.add(Note(1, "second note"))
       println("Список заметок:  " + noteService.get())

       noteService.delete(Note(2, "second note"))
       println("Список заметок после удаления второй заметки:  " + noteService.get())

       println("Нашли по id 1 элемент:  " + noteService.getById(1))

       noteService.edit(Note(1, "update first note"))
       println("Список заметок после обновления первой заметки " + noteService.get())

       noteService.createComment(1, testComment)
       println("Добавили первый коммент к первой заметке  " + noteService.elements)

       noteService.createComment(1, testComment2)
       println("Добавили второй коммент к первой заметке  " + noteService.elements)

       noteService.editComment(1, testComment, Comment(false, "update first comment", 1))
       println("Обновили коммент  " + noteService.elements)

       noteService.deleteComment(1, testComment2)
       println("Удалили коммент к первой заметке и выводим список комментов к заметке 1:  " + noteService.getComments(1))
   */
    val chatService = ChatService()
    val testMess1 = Message(0, 1, "аа")
    val testMess2 = Message(0, 2, "бб")
    val testMess3 = Message(0, 3, "вв")
    val testMess4 = Message(0, 4, "гг")
    val testMess5 = Message(0, 5, "дд")

    println("Добавляем новые чаты:")
    chatService.addMessage(listOf(1, 2), testMess1)
    chatService.addMessage(listOf(1, 2), testMess2)
    chatService.addMessage(listOf(1, 2), testMess4)
    println(chatService.chats)
    println("Добавляем новое сообщение в чат №2:")
    chatService.addMessage(listOf(2, 1), testMess3)
    println(chatService.chats)
    println("Получаем все сообщения из чата №1:")
    println(chatService.getMessages(1, 1, 1))
    println("Удаляем сообщение №1 из чата №1")
    chatService.deleteMessage(listOf(1, 2), testMess1)

    chatService.addMessage(listOf(3, 1), testMess4)
    chatService.addMessage(listOf(2, 3), testMess5)
    chatService.deleteMessage(listOf(1, 2), testMess4)
    println(chatService.chats)
    println("Число непрочитанных сообщений в чате №1 = " + chatService.unreadMessagesCount(1, 1))
    println(chatService.getMessages(1, 1, 1))
    println("У пользователя №1 имеются непрочитанные сообщения в чатах:")
    println(chatService.unreadChatsList(1))
}

