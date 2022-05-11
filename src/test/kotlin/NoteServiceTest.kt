import org.junit.Test

import org.junit.Assert.*

class NoteServiceTest {

    @Test
    fun createComment() {
        //Arrange
        val noteService = NoteService()
        noteService.add(Note(1, "first note"))
        val testComment = Comment(false, "test note's comment", 1)
        //Act
        noteService.createComment(1, testComment)
        //Assert
        assertEquals("test note's comment", noteService.elements[0].comments[0].text)
    }

    @Test
    fun getComments() {
        //Arrange
        val noteService = NoteService()
        noteService.add(Note(1, "first note"))
        val testComment = Comment(false, "test note's comment", 1)
        val testComment2 = Comment(true, "test note's comment #2", 2)
        val testArray = listOf(testComment)
        //Act
        noteService.createComment(1, testComment)
        noteService.createComment(1, testComment2)
        val result = noteService.getComments(1)
        //Assert
        assertEquals(testArray, result)
    }

    @Test
    fun deleteCommentTrue() {
        //Arrange
        val noteService = NoteService()
        noteService.add(Note(1, "first note"))
        val testComment = Comment(false, "test note's comment", 1)
        noteService.createComment(1, testComment)
        //Act
        noteService.deleteComment(1, testComment)
        //Assert
        assertEquals(true, noteService.elements[0].comments[0].deleted)
    }

    @Test(expected = CommentDeletedException::class)
    fun deleteCommentShouldThrow() {
        //Arrange
        val noteService = NoteService()
        noteService.add(Note(1, "first note"))
        val testComment = Comment(true, "test note's comment", 1)
        noteService.createComment(1, testComment)
        //Act
        noteService.deleteComment(1, testComment)

    }

    @Test
    fun restoreCommentTrue() {
        //Arrange
        val noteService = NoteService()
        noteService.add(Note(1, "first note"))
        val testComment = Comment(true, "test note's comment", 1)
        noteService.createComment(1, testComment)
        //Act
        noteService.restoreComment(1, testComment)
        //Assert
        assertEquals(false, noteService.elements[0].comments[0].deleted)
    }

    @Test(expected = CommentDeletedException::class)
    fun restoreCommentShouldThrow() {
        //Arrange
        val noteService = NoteService()
        noteService.add(Note(1, "first note"))
        val testComment = Comment(false, "test note's comment", 1)
        noteService.createComment(1, testComment)
        //Act
        noteService.restoreComment(1, testComment)
    }

    @Test
    fun editCommentTrue() {
        //Arrange
        val noteService = NoteService()
        noteService.add(Note(1, "first note"))
        val testComment = Comment(false, "test note's comment", 1)
        val newComment = Comment(false, "update first comment", 1)
        //Act
        noteService.createComment(1, testComment)
        noteService.editComment(1, testComment, newComment)
        //Assert
        assert(true)
    }

    @Test(expected = CommentDeletedException::class)
    fun editCommentDeletedComment() {
        //Arrange
        val noteService = NoteService()
        noteService.add(Note(1, "first note"))
        val testComment = Comment(true, "test note's comment", 1)
        val newComment = Comment(true, "update first comment", 1)
        //Act
        noteService.createComment(1, testComment)
        noteService.editComment(1, testComment, newComment)
    }
}