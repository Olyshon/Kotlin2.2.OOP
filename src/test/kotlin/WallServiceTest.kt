import org.junit.Test

import org.junit.Assert.*

class WallServiceTest {

    @Test
    fun addIDNotNull() {
        //Arrange
        val wallService = WallService()
        val audioAttachment = AudioAttachment("video")
        val postTest1 = Post(
            text = "This is my first post",
            likes = Post.Likes(10u, userLikes = false, canLike = true, canPublish = true),
            attachment = audioAttachment
        )
        //Act
        val resultPost = wallService.add(
            post = postTest1
        )
        //Assert
        assertNotEquals(0, resultPost.id)
    }

    @Test
    fun updateIdExists() {
        //Arrange
        val wallService = WallService()
        val videoAttachment = VideoAttachment("video")
        val postTest = Post(
            text = "My post for test",
            attachment = videoAttachment
        )
        val postAfterAddId = wallService.add(
            post = postTest
        )
        //Act
        val result = wallService.update(
            post = postAfterAddId
        )
        //Assert
        assertTrue(result)
    }

    @Test
    fun updateIdNotExists() {
        //Arrange
        val wallService = WallService()
        val noteAttachment = NoteAttachment("video")
        val postTest = Post(
            id = 1234567,
            attachment = noteAttachment
        )
        //Act
        val result = wallService.update(
            post = postTest
        )
        //Assert
        assertFalse(result)
    }

  @Test(expected = PostNotFoundException::class)
    fun shouldThrow() {
        //Arrange
        val wallService = WallService()
        val noteAttachment = NoteAttachment("note")
        val commentTest = Comment(
           // Id = 1234567,
            text = "test comment - shouldThrow",
            id = 1234567
          //  attachment = noteAttachment
        )
        //Act
        val result = wallService.createComment(
            comment = commentTest
        )

    }
}