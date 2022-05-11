fun main() {
    val videoAttachment = VideoAttachment("video")
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

}
