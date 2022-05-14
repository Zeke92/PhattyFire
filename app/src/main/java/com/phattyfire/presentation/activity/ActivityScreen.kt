package com.phattyfire.presentation.activity

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.phattyfire.R
import com.phattyfire.domain.models.Activity
import com.phattyfire.domain.models.Comment
import com.phattyfire.domain.util.ActivityAction
import com.phattyfire.presentation.components.ActionRow
import com.phattyfire.presentation.components.StandardScaffold
import com.phattyfire.presentation.components.StandardToolbar
import com.phattyfire.presentation.post_detail.Comment
import com.phattyfire.presentation.ui.theme.*
import kotlin.random.Random

@Composable
fun ActivityScreen(navController: NavController){
    Column(modifier = Modifier
        .fillMaxSize()
    ){
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

            )
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.surface),
            contentPadding = PaddingValues(SpacingMedium)
        ){


            items(20){
                ActivityItem(
                    activity = Activity(
                        "Zak Falkenbach",
                        actionType = if (Random.nextInt(2)== 0){
                            ActivityAction.LikedPost
                        }else ActivityAction.CommentedOnPost,
                        System.currentTimeMillis()
                    )
                )
            }
        }
    }
}