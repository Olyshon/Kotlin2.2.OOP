class NoteService: CrudService <Note> () {

    fun addComment(noteId: Int, comment: Comment) {
        getById(noteId)?.comments?.add(comment)
    }

    fun deleteComment(noteId: Int, comment: Comment) {

        comment.deleted = true
    }

  /*  fun editComment(noteId: Int, comment: Comment, updateText: String): Boolean {

      if (!comment.deleted) {

          for ((index, curElem) in getById(noteId)?.comments!!.withIndex()) {
              if (curElem.id == comment.id)
                // elements[index] = elem
              //    getById(noteId)!!.comments[index] = comment.text updateText
              return true
          }
          return false
      }
        throw PostNotFoundException("Нельзя редактировать, коммент №${comment.id} удален' ")
    }*/
}
