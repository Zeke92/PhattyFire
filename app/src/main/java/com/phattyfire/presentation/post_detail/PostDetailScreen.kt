package com.phattyfire.presentation.post_detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.phattyfire.R
import com.phattyfire.domain.models.Comment
import com.phattyfire.domain.models.Post
import com.phattyfire.presentation.components.ActionRow
import com.phattyfire.presentation.components.Post
import com.phattyfire.presentation.components.StandardToolbar
import com.phattyfire.presentation.ui.theme.*
import com.phattyfire.presentation.util.Screen
import com.phattyfire.util.Constants

@Composable
fun PostDetailScreen(
    navController: NavController,
    post: Post
    ) {
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
        ){
            item{
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colors.background)
                ) {
                    Spacer(modifier = Modifier
                        .height(SpacingLarge)
                    )
                    Box(modifier = Modifier
                        .fillMaxSize()

                    ){
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .offset(y = ProfilePictureSize / 2f)
                                .clip(MaterialTheme.shapes.medium)
                                .background(MediumGray)
                            ///.shadow(5.dp)
                        ) {
                            Image(
                                painterResource(id = R.drawable.bannerforlogin),
                                contentDescription = "Post image"
                                ,modifier = Modifier
                                    .align(CenterHorizontally)
                                    .fillMaxSize()
                            )
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(SpacingLarge)
                            ) {
                                ActionRow(
                                    userName = "Zak falkenbach",
                                    modifier = Modifier.fillMaxWidth(),
                                    onLikeCLick = {
                                            isLiked ->
                                    },
                                    onCommentClick = {

                                    },
                                    onShareClick = {

                                    },
                                    onUserNameClick = { username ->

                                    }

                                )
                                Spacer(modifier = Modifier.height(SpacingSmall))
                                Text(
                                    text = post.description,
                                    style = MaterialTheme.typography.body2,
                                )
                                Spacer(modifier = Modifier.height(SpacingSmall))
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {

                                    Text(
                                        text = stringResource(id = R.string.x_comments,
                                            post.commentCount
                                        ),
                                        fontWeight = FontWeight.Bold,
                                        style = MaterialTheme.typography.body2
                                    )
                                }


                            }
                        }

                        Image(
                            painterResource(id = R.drawable.weeeed),
                            contentDescription = "Profile picture",
                            modifier = Modifier
                                .clip(CircleShape)
                                .size(ProfilePictureSize)
                                .align(Alignment.TopCenter)
                        )
                    }

                }
                Spacer(modifier = Modifier.height(SpacingLarge))
            }
            
            items(20){
                Comment(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = SpacingLarge,
                            vertical = SpacingSmall
                        ),

                    comment = Comment(
                        username = "Zak Falkenbach$it",
                        comment = "This is a test comment.This is a test comment."
                    )
                )
            }
        }
    }

}

@Composable
fun Comment(
    modifier: Modifier = Modifier,
    comment: Comment = Comment(),
    onLikeClick: (Boolean) -> Unit = {}


){
    Card(modifier = modifier
        .padding(SpacingSmall),
        elevation = 5.dp,
        shape = MaterialTheme.shapes.medium,
        backgroundColor = MaterialTheme.colors.onSurface

    ) {
        Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(SpacingMedium)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                   Image(
                       painter = painterResource(id = R.drawable.weeeed),
                       contentDescription = null,
                       modifier = Modifier
                           .clip(CircleShape)
                           .size(ProfilePictureSizeSmall)
                   )
                    Spacer(modifier = Modifier.width(SpacingSmall))
                    Text(
                        text = comment.username,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.body2,
                        color = MaterialTheme.colors.onBackground

                    )
                }
                Text(text = "2 days ago",
                    style = MaterialTheme.typography.body2
                )

            }
            Spacer(modifier = Modifier.height(SpacingMedium))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically

            ) {
                Text(
                    text = comment.comment,
                    style = MaterialTheme.typography.body2,
                    color = MaterialTheme.colors.onBackground,
                    modifier = Modifier.weight(9f)


                )
                Spacer(modifier = Modifier.width(SpacingMedium))
                IconButton(
                    onClick = {
                        onLikeClick(comment.isLiked)
                },
                    modifier = Modifier.weight(1f)
                ) {
                   Icon(imageVector = Icons.Default.Favorite,
                       contentDescription = if (comment.isLiked){
                           stringResource(id = R.string.unlike)
                       }else stringResource(id = R.string.like)

                   )
                }

            }
            Spacer(modifier = Modifier.height(SpacingMedium))
            Text(
                text = stringResource(id = R.string.liked_by_x_people, comment.likeCount),
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.body2
            )

        }
    }

}