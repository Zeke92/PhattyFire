package com.phattyfire.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.phattyfire.presentation.components.Post
import com.phattyfire.presentation.components.StandardScaffold

@Composable
fun MainFeedScreen(
    navController: NavController
){
            Post(
                post = com.phattyfire.domain.models.Post(
                    username = "Zak Falkenbach",
                    imageUrl = "",
                    profilePictureUrl = "",
                    description = "This is random text",
                    likeCount = 17,
                    commentCount = 5
                )
            )
}