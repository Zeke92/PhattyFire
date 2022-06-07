package com.phattyfire.presentation.profile

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
import com.phattyfire.domain.models.User
import com.phattyfire.domain.util.ActivityAction
import com.phattyfire.domain.util.DateFormatUtil
import com.phattyfire.presentation.activity.ActivityItem
import com.phattyfire.presentation.components.StandardScaffold
import com.phattyfire.presentation.components.StandardToolbar
import com.phattyfire.presentation.profile.components.BannerSection
import com.phattyfire.presentation.profile.components.ProfileHeaderSection
import com.phattyfire.presentation.ui.theme.SpacingMedium
import kotlin.random.Random

@Composable
fun ProfileScreen(navController: NavController){
    Column(modifier = Modifier
        .fillMaxSize()
    ){
        StandardToolbar(
            navController = navController,
            title = {
                Text(
                    text = stringResource(id = R.string.your_profile),
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.onBackground
                )

            },
            modifier = Modifier.fillMaxWidth(),
            showBackArrow = false,

            )
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ){
            item {
                BannerSection(
                    modifier = Modifier
                        .aspectRatio(2.5f)
                )
            }
            item {
                ProfileHeaderSection(
                    user = User(
                        profilePrictureUrl = " ",
                        username = " ",
                        description = " ",
                        followerCount = 1,
                        folowingCount = 3,
                        postCount = 23

                    ) )
            }

            items(20){

            }
        }
    }
}