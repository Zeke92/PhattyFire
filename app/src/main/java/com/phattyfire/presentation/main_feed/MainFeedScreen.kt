package com.phattyfire.presentation.main_feed

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.phattyfire.R
import com.phattyfire.presentation.components.Post
import com.phattyfire.presentation.components.StandardScaffold
import com.phattyfire.presentation.components.StandardToolbar

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
                    fontWeight = FontWeight.Bold
                )

            },
            modifier = Modifier.fillMaxWidth(),
            showBackArrow = true,
            navActions = {

                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = ""
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
            )
        )
    }
}
