fun main() {
    val postNum1 = Post(
        text = "This is my first post",
        likes = Post.Likes(10u, userLikes = false, canLike = true, canPublish = true),
    )
    val postNum2 = Post(
        text = "This is my second post",
        likes = Post.Likes(200u, userLikes = false, canLike = true, canPublish = true),
    )

    val wallService = WallService()

    wallService.add(postNum1)
    val postNum2UP = wallService.add(postNum2)

    val postNum3 = Post(
        id = postNum2UP.id,
        text = "This is update second post",
        likes = Post.Likes(300u, userLikes = false, canLike = true, canPublish = true),
    )
    wallService.update(postNum3)

}