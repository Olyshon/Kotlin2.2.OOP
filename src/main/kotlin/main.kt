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
    print(wallService.update(postNum3))


}
