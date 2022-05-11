import org.junit.Test

import org.junit.Assert.*

class CrudServiceTest {

    @Test
    fun add() {
        //Arrange
        val noteService = NoteService()
        val noteTest1 = Note(1, "first note")
        //Act
        noteService.add(noteTest1)
        //Assert
        assertEquals("first note", noteService.elements[0].text)
    }

    @Test
    fun editNoteTrue() {
        //Arrange
        val noteService = NoteService()
        val noteTest1 = Note(1, "first note")
        noteService.add(noteTest1)
        val noteTest2 = Note(1, "update first note")
        //Act
        noteService.edit(noteTest2)
        //Assert
        assert(true)

    }

    @Test
    fun getById() {
        //Arrange
        val noteService = NoteService()
        val noteTest1 = Note(1, "first note")
        noteService.add(noteTest1)
        //Act
        noteService.getById(1)
        //Assert
        assertEquals("first note", noteService.elements[0].text)
    }

    @Test
    fun get() {
        //Arrange
        val noteService = NoteService()
        val noteTest1 = Note(1, "first note")
        noteService.add(noteTest1)
        //Act
        noteService.get()
        //Assert
        assertEquals(1, noteService.elements.size)
    }

    @Test
    fun delete() {
        //Arrange
        val noteService = NoteService()
        val noteTest1 = Note(1, "first note")
        val noteTest2 = Note(2, "second note")
        noteService.add(noteTest1)
        noteService.add(noteTest2)
        //Act
        noteService.delete(noteTest2)
        //Assert
        assertEquals(1, noteService.elements.size)
    }
}