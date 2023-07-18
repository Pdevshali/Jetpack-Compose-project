import com.example.composeproject.R



data class Post(
    val id: String,
    val authorImage: Int,
    val authorName: String,
    val postType: String,
    val text: String,
    val image: Int,
    val likes: Int,
    val comments: Int
)

fun getStaticPosts(): List<Post> {
    return listOf(
        Post(
            id = "1",
            authorImage = R.drawable.dummy,
            authorName = "John Doe",
            postType = "Question ?",
            text = "This is the first post",
            image = R.drawable.try_later,
            likes = 10,
            comments = 5
        ),

        Post(
            id = "2",
            authorImage = R.drawable.dummy,
            authorName = "Ayush",
            postType = "Marketing",
            text = "This is the first post about a new marketing campaign. We are excited to share our latest product with the world!",
            image = R.drawable.pixels,
            likes = 10,
            comments = 5
        ),

        // Adding more posts as needed
        Post(
            id = "3",
            authorImage =  R.drawable.dummy,
            authorName = "John Doe",
            postType = "Question?",
            text = "This is the first post",
            image = R.drawable.try_later,
            likes = 10,
            comments = 5
        ),
        Post(
            id = "4",
            authorImage =  R.drawable.dummy,
            authorName = "John Doe",
            postType = "Question",
            text = "This is the first post.Please ensure that you have these dependencies " +
                    "included in your build.gradle file and that " +
                    "the versions are compatible with each other.",
            image = R.drawable.pixels,
            likes = 10,
            comments = 5
        ),
        Post(
            id = "5",
            authorImage = R.drawable.dummy,
            authorName = "John Doe",
            postType = "Question",
            text = "Hey everyone, I have a question regarding the latest earth surface  Can anyone help me out?",
            image = R.drawable.earth,
            likes = 10,
            comments = 5
        ),
        Post(
            id = "6",
            authorImage = R.drawable.dummy,
            authorName = "John Doe",
            postType = "Question",
            text = "Hello everyone, I'm facing an issue with my app's navigation. The screen transitions are not working as expected. Any suggestions?",
            image = R.drawable.try_later,
            likes = 10,
            comments = 5
        ),

                Post(
            id = "7",
            authorImage = R.drawable.dummy,
            authorName = "John Doe",
            postType = "Question",
            text = "This is the first post",
            image = R.drawable.night,
            likes = 10,
            comments = 5
        ),
        Post(
            id = "8",
            authorImage = R.drawable.dummy,
            authorName = "John Doe",
            postType = "Question",
            text = "This is the nth post",
            image = R.drawable.earth,
            likes = 10,
            comments = 5
        ),
        Post(
            id = "9",
            authorImage = R.drawable.dummy,
            authorName = "John Doe",
            postType = "Question",
            text = "This is the first post",
            image = R.drawable.night,
            likes = 10,
            comments = 5
        ),
        Post(
            id = "10",
            authorImage = R.drawable.dummy,
            authorName = "John Doe",
            postType = "Question",
            text = "This is the first post",
            image = R.drawable.pixels,
            likes = 10,
            comments = 5
        )

    )
}
