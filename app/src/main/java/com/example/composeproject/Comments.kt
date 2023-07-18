package com.example.jetpackassignment

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeproject.R

//@Preview(showBackground = true, name = "hello world", widthDp = 300, heightDp = 500)
@Composable
fun CommentScreen(postId: String?) {
    val comments = getCommentsForPost(postId) // Retrieve comments for the given postId

    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        items(comments) { comment ->
            CommentItem(comment)
        }
    }
}

@Composable
fun CommentItem(comment: Comment) {
    Column(modifier = Modifier.padding(16.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            AuthorInfoComments(comment.authorImage, comment.authorName)
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = comment.text)
        Spacer(modifier = Modifier.height(8.dp))
        Image(
            painter = painterResource(id = comment.image),
            contentDescription = "Comment Image",
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun AuthorInfoComments(authorImage: Int, authorName: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(id = authorImage),
            contentDescription = "Author Image",
            modifier = Modifier.size(32.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = authorName)
    }
}



private fun getCommentsForPost(postId: String?): List<Comment> {
    val commentsMap = mapOf(
        "post1" to listOf(
            Comment(
                authorImage = R.drawable.arrow_icon,
                authorName = "User1",
                text = "Comment 1 for Post 1",
                image = R.drawable.arrow_icon
            ),
            Comment(
                authorImage = R.drawable.baseline_share_24,
                authorName = "User2",
                text = "Comment 2 for Post 1",
                image = R.drawable.bollywood
            )
        ),
        "post2" to listOf(
            Comment(
                authorImage = R.drawable.arrow_icon,
                authorName = "User3",
                text = "Comment 1 for Post 2",
                image = R.drawable.arrow_icon
            ),
            Comment(
                authorImage = R.drawable.baseline_share_24,
                authorName = "User4",
                text = "Comment 2 for Post 2",
                image = R.drawable.baseline_share_24
            ),
            Comment(
                authorImage = R.drawable.arrow_icon,
                authorName = "User5",
                text = "Comment 3 for Post 2",
                image = R.drawable.arrow_icon
            )
        )
    )

    return commentsMap[postId] ?: emptyList()
}


data class Comment(
    val authorImage: Int,
    val authorName: String,
    val text: String,
    val image: Int
)