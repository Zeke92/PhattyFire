package com.phattyfire.presentation.components

import android.graphics.Picture
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Comment
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.*
import com.phattyfire.R
import com.phattyfire.domain.models.Post
import com.phattyfire.presentation.ui.theme.*
import com.phattyfire.util.Constants
import okhttp3.internal.userAgent

@Composable
fun Post(post: Post,
        profilePictureSize: Dp = 75.dp
){
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(SpacingMedium)
    ){
        Column(
            modifier = Modifier
            .fillMaxWidth()
            .offset(y = profilePictureSize / 2f)
            .clip(MaterialTheme.shapes.medium)
            .background(MediumGray)
            .shadow(5.dp)
        ) {
            Image(
                painterResource(id = R.drawable.bannerforlogin),
                contentDescription = "Post image"
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(SpacingMedium)
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
                    text = buildAnnotatedString {
                        append(post.description)
                        withStyle(SpanStyle(
                            color = HintGrey,
                        )){
                            append(
                                LocalContext.current.getString(
                                    R.string.read_more
                                )
                            )
                        }
                    },
                    style = MaterialTheme.typography.body2,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = Constants.MAX_POST_DESCRIPTION_LINES
                )
                Spacer(modifier = Modifier.height(SpacingSmall))
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = stringResource(id = R.string.liked_by_x_people,
                            post.likeCount
                        ),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.h2
                    )
                    Text(
                        text = stringResource(id = R.string.x_comments,
                            post.commentCount
                        ),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.h2
                    )
                }
            }

        }
        Image(
            painterResource(id = R.drawable.weeeed),
            contentDescription = "Profile picture",
            modifier = Modifier
                .fillMaxWidth()
                .size(profilePictureSize)
                .clip(CircleShape)
                .align(Alignment.TopCenter)
        )
    }
}

@Composable
fun EngagementButtons(
                      modifier: Modifier = Modifier,
                      isLiked: Boolean = false,
                      iconSize: Dp = 30.dp,
                      onLikeCLick: (Boolean)-> Unit = {},
                      onCommentClick: ()-> Unit = {},
                      onShareClick: ()-> Unit = {},
                      ){
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        IconButton(
            onClick = {
                onLikeCLick(!isLiked)
        },
            modifier = Modifier.size(iconSize)
        ) {
            Icon(
                imageVector = Icons.Filled.Favorite,
                tint = if (isLiked){
                                   Color.Red
                                   } else{
                                         TextWhite
                                         },
                contentDescription = if (isLiked){
                    stringResource(id = R.string.unlike)
                }else{
                    stringResource(id = R.string.like)
                }
            )
        }
        IconButton(
            onClick = {
            onCommentClick()
        }) {
            Icon(
                imageVector = Icons.Filled.Comment,
                contentDescription = stringResource(id = R.string.comment)

            )
        }

        IconButton(
            onClick = {
            onShareClick()
        }) {
            Icon(
                imageVector = Icons.Filled.Share,
                contentDescription = stringResource(id = R.string.share)

            )
        }
    }


}


@Composable
fun ActionRow(
    modifier: Modifier = Modifier,
    isLiked: Boolean = false,
    onLikeCLick: (Boolean)-> Unit = {},
    onCommentClick: ()-> Unit = {},
    onShareClick: ()-> Unit = {},
    userName: String,
    onUserNameClick: (String) -> Unit = {}
){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier,
    ) {
        Text(
            text = userName,
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.primary

            ),
            modifier = Modifier
                .clickable {
                    onUserNameClick(userName)
                }
        )
        EngagementButtons(
            modifier = Modifier
                .width(100.dp),
            isLiked = isLiked,
            onLikeCLick = onLikeCLick,
            onCommentClick = onCommentClick,
            onShareClick = onShareClick
        )

    }


}
