import androidx.lifecycle.ViewModel


class FeedViewModel : ViewModel() {
    private val posts: List<Post> = getStaticPosts() // Retrieve the static data source

    fun getPosts(): List<Post> {
        return posts
    }
}
