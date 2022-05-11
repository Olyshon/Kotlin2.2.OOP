class NoteService : CrudService<Note>() {

    fun createComment(noteId: Int, comment: Comment) {
        getById(noteId)?.comments?.add(comment)
    }

    fun getComments(noteId: Int): List<Comment>? {
        return getById(noteId)?.comments?.filter { !it.deleted }
    }

    fun deleteComment(noteId: Int, comment: Comment) {
        if (comment.deleted) throw CommentDeletedException("This comment has already been deleted")
        else comment.deleted = true
    }

    fun restoreComment(noteId: Int, comment: Comment) {
        if (!comment.deleted) throw CommentDeletedException("This comment has already been restored")
        else comment.deleted = false
    }

    fun editComment(noteId: Int, comment: Comment, newComment: Comment): Boolean {
        if (!comment.deleted) {
            for ((index, curElem) in elements[noteId - 1].comments.withIndex()) {
                if (curElem.id == comment.id) {
                    elements[noteId - 1].comments[index] = newComment
                    return true
                }
            }
            return false
        }
        throw CommentDeletedException("This comment has already been deleted")
    }
}


