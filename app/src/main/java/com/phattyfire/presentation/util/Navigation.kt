package com.phattyfire.presentation.util

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.phattyfire.presentation.main_feed.MainFeedScreen
import com.phattyfire.presentation.activity.ActivityScreen
import com.phattyfire.presentation.chat.ChatScreen
import com.phattyfire.presentation.components.Post
import com.phattyfire.presentation.create_post.CreatePostScreen
import com.phattyfire.presentation.login.LoginScreen
import com.phattyfire.presentation.post_detail.PostDetailScreen
import com.phattyfire.presentation.profile.ProfileScreen
import com.phattyfire.presentation.register.RegisterScreen
import com.phattyfire.presentation.splash.SplashScreen


@Composable
fun Navigation(navController: NavHostController) {

    NavHost(
       navController = navController,
        startDestination =  Screen.SplashScreen.route)
    {

        composable(Screen.SplashScreen.route){
            SplashScreen(navController = navController)
        }
        composable(Screen.LoginScreen.route){
            LoginScreen(navController = navController)
        }
        composable(Screen.RegisterScreen.route){
            RegisterScreen(navController = navController)
        }
        composable(Screen.MainFeedScreen.route){
            MainFeedScreen(navController = navController)
        }
        composable(Screen.ChatScreen.route){
            ChatScreen(navController = navController)
        }
        composable(Screen.ActivityScreen.route){
            ActivityScreen(navController = navController)
        }
        composable(Screen.ProfileScreen.route){
            ProfileScreen(navController = navController)
        }
        composable(Screen.CreatePostScreen.route){
            CreatePostScreen(navController = navController)
        }
        composable(Screen.PostDetailScreen.route){
            PostDetailScreen(
                navController = navController,
                post = com.phattyfire.domain.models.Post(
                    username = "Zak Falkenbach",
                    imageUrl = "",
                    profilePictureUrl = "",
                    description = "",
                    likeCount = 17,
                    commentCount = 2
                )
            )
        }

    }

}