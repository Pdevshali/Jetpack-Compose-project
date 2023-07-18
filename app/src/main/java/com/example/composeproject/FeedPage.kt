package com.example.jetpackassignment

import FeedViewModel
import Post
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.composeproject.R

@Preview(showBackground = true, name = "Hello World", widthDp = 300, heightDp = 500)
@Composable
fun FeedPagePreview() {
    val navController = rememberNavController()
    val viewModel = FeedViewModel()

    FeedPage(navController = navController, viewModel = viewModel)
}

@Composable
fun FeedPage(viewModel: FeedViewModel, navController: NavHostController) {
    val posts = viewModel.getPosts() // Retrieve the static data source

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(posts) { post ->
            PostItem(post, navController)
        }
    }
}
@Composable
fun PostItem(post: Post, navController: NavController) {
    Column(modifier = Modifier.padding(16.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            AuthorInfo(post.authorImage, post.authorName)
            Text(
                text = post.postType,
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 10.dp, end = 10.dp, bottom = 0.dp)
                    .fillMaxWidth(),
                color = Color.Blue,
            )
            Image(
                painter = painterResource(id = R.drawable.drawable_vert),
                contentDescription = "Author Image",
                modifier = Modifier.size(20.dp))
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = post.text)
        Spacer(modifier = Modifier.height(8.dp))
        Image(
            painter = painterResource(id = post.image),
            contentDescription = "Post Image",
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(painter = painterResource(R.drawable.baseline_heart_broken_24),
                contentDescription = "comment img")
            Spacer(modifier = Modifier.width(3.dp))
            Text(text = "${post.likes} likes")
            Spacer(modifier = Modifier.width(18.dp))
            Image(painter = painterResource(R.drawable.baseline_comment_24),
                contentDescription = "comment img")
            Spacer(modifier = Modifier.width(3.dp))

            Text(text = "Comments: ${post.comments}", modifier = Modifier.clickable {
                navController.navigate("comments/${post.id}")
            })
            Spacer(modifier = Modifier.width(18.dp))
            Image(painter = painterResource(R.drawable.baseline_share_24),
                contentDescription = "comment img")
            Spacer(modifier = Modifier.width(3.dp))
            Text(text = "5 share")
        }
        Spacer(modifier = Modifier.height(8.dp))
    }
}

@Composable
fun AuthorInfo(authorImage: Int, authorName: String) {
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




