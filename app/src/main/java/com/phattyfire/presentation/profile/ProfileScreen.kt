package com.phattyfire.presentation.profile

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.phattyfire.R
import com.phattyfire.domain.models.Activity
import com.phattyfire.domain.models.Post
import com.phattyfire.domain.models.User
import com.phattyfire.domain.util.ActivityAction
import com.phattyfire.domain.util.DateFormatUtil
import com.phattyfire.presentation.activity.ActivityItem
import com.phattyfire.presentation.components.Post
import com.phattyfire.presentation.components.StandardScaffold
import com.phattyfire.presentation.components.StandardToolbar
import com.phattyfire.presentation.profile.components.BannerSection
import com.phattyfire.presentation.profile.components.ProfileHeaderSection
import com.phattyfire.presentation.ui.theme.ProfilePictureSizeLarge
import com.phattyfire.presentation.ui.theme.SpacingMedium
import com.phattyfire.presentation.util.Screen
import me.onebone.toolbar.*
import kotlin.random.Random

@Composable
fun ProfileScreen(navController: NavController) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        state = rememberLazyListState()
    ) {
        item {
            BannerSection()
        }
        item {
            ProfileHeaderSection(
                user = User(
                    profilePictureUrl = " ",
                    username = " Zak",
                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing" +
                            " elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ",
                    followerCount = 211,
                    followingCount = 332,
                    postCount = 213
                )
            )
            for (i in 1..20){
                Spacer(modifier = Modifier.height(SpacingMedium))
                Post(
                    post = Post(
                        username = "Zak Falk",
                        imageUrl = "",
                        profilePictureUrl = "",
                        description = " This is it",
                        likeCount = 1,
                        commentCount = 2,
                    ),
                    showProfileImage = false,
                    onPostClick = {
                        navController.navigate(Screen.PostDetailScreen.route)
                    },
                    modifier = Modifier
                        .offset(y = -ProfilePictureSizeLarge / 2f),
                )
            }
        }

    }

}
