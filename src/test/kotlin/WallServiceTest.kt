import org.junit.Test

import org.junit.Assert.*

class WallServiceTest {

    @Test
    fun addIDNotNull() {
        //Arrange
        val wallService = WallService()
        val postTest1 = Post(
            text = "This is my first post",
            likes = Post.Likes(10u, userLikes = false, canLike = true, canPublish = true)
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
        val postTest = Post(
            text = "My post for test"
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
        val postTest = Post(
            id = 1234567
        )
        //Act
        val result = wallService.update(
            post = postTest
        )
        //Assert
        assertFalse(result)
    }
}