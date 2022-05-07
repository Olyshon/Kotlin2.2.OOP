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

  /*  val comment = Comment(
        postId = 1,
        attachment = audioAttachment,
        text = "My test comment"
    )*/
   // wallService.createComment(comment)
    val testComment = Comment (false, "test note's comment", 1)

    val service = NoteService()
    service.add(Note(1, "first note"))
    service.add(Note(1, "second note"))
    println("Массив заметок:  " + service.elements)
    println("Нашли по id 2 элемент:  " + service.getById(2))
    service.update(Note(1, "update first note"))
    println("Массив заметок после обновления  " + service.elements)

    service.addComment(1, testComment)
    println("Добавили коммент к первой заметке  " + service.elements)

    service.deleteComment(1, testComment)
    println("Удалили коммент к первой заметке  " + service.elements)

   // service.editComment(1, testComment, "update text in test comment")
    println("Изменили коммент к первой заметке  " + service.elements)
   // service.deleteComment(1, testComment, "update text in test comment")
}
