import java.time.Instant

class WallService() {
    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comment>()

    fun createComment(comment: Comment): Comment {
        for (curPost in posts) {
            if (curPost.id == comment.postId) {
                comments += comment
                return comments.last()
            }
        }
        throw PostNotFoundException("no post with id ${comment.id}")
    }

    fun add(post: Post): Post {
        val uniqueId: Long = System.currentTimeMillis()
        val instant = Instant.ofEpochMilli(uniqueId)
        val postNewId = post.copy(id = uniqueId, date = instant)
        posts += postNewId
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((index, curPost) in posts.withIndex()) {
            if (curPost.id == post.id)
                posts[index] = curPost.copy(
                    id = post.id,
                    ownerId = post.ownerId,
                    createdBy = post.createdBy,
                    text = post.text,
                    replyOwnerId = post.replyOwnerId,
                    replyPostId = post.replyPostId,
                    friendsOnly = post.friendsOnly,
                    postType = post.postType,
                    signerId = post.signerId,
                    canPin = post.canPin,
                    canDelete = post.canDelete,
                    canEdit = post.canEdit,
                    isPinned = post.isPinned,
                    markedAsAds = post.markedAsAds,
                    isFavorite = post.isFavorite,
                    postponedId = post.postponedId,
                    likes = post.likes,
                    comments = post.comments,
                    views = post.views,
                    reposts = post.reposts,
                    copyright = post.copyright,
                    donut = post.donut,
                    postSource = post.postSource,
                    geo = post.geo,
                    copyHistory = post.copyHistory,
                    attachment = post.attachment
                )
            return true
        }
        return false
    }


}