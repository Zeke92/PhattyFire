package com.phattyfire.presentation.main_feed

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.phattyfire.R
import com.phattyfire.presentation.components.Post
import com.phattyfire.presentation.components.StandardToolbar
import com.phattyfire.presentation.util.Screen

@Composable
fun MainFeedScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        StandardToolbar(
            navController = navController,
            title = {
                Text(
                    text = stringResource(id = R.string.your_feed),
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.onBackground
                )

            },
            modifier = Modifier.fillMaxWidth(),
            showBackArrow = true,
            navActions = {

                IconButton(onClick = {
                    navController.navigate(Screen.SearchScreen.route)
                }) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = stringResource(id =R.string.your_feed),
                        tint = MaterialTheme.colors.onBackground
                    )

                }
            }
        )
        Post(
            post = com.phattyfire.domain.models.Post(
                username = "Zak Falk",
                imageUrl = "",
                profilePictureUrl = "",
                description = " This is it",
                likeCount = 1,
                commentCount = 2
            ),
            onPostClick = {
                navController.navigate(Screen.PostDetailScreen.route)
            }
        )
    }
}
