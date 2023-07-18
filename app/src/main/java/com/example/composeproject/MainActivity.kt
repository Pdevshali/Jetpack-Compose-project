package com.example.composeproject

import FeedViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackassignment.CommentScreen
import com.example.jetpackassignment.FeedPage

class MainActivity : ComponentActivity() {
    private lateinit var feedViewModel: FeedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        feedViewModel = ViewModelProvider(this).get(FeedViewModel::class.java)

        setContent {

                // Create a ViewModel instance using viewModel() composable function
                val viewModel: FeedViewModel = viewModel()

                // Pass the ViewModel instance to AppNavigation composable
                AppNavigation(viewModel)

        }
    }
}


@Composable
fun AppNavigation(viewModel: FeedViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "feed") {
        composable("feed") {
            FeedPage(viewModel, navController)
        }
        composable("comment/{postId}") { backStackEntry ->
            val postId = backStackEntry.arguments?.getString("postId")
            CommentScreen(postId)
        }
    }
}


