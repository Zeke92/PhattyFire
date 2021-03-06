package com.phattyfire.presentation.profile.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.phattyfire.R
import com.phattyfire.domain.models.User
import com.phattyfire.presentation.ui.theme.*

@Composable
fun ProfileHeaderSection(
    user: User,
    modifier: Modifier = Modifier,
    isOwnProfile: Boolean = true,
    onEditClick: () -> Unit = {}

){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .offset(y = -ProfilePictureSizeLarge / 2f),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.cat),
            contentDescription = stringResource(id = R.string.profile_image),
            modifier = Modifier
                //.aspectRatio(1f)
                .size(ProfilePictureSizeLarge)
                .clip(CircleShape)
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colors.onSurface,
                    shape = CircleShape
                )

        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .offset(x =
                if (isOwnProfile) {
                    (30.dp + SpacingSmall) / 2f
                }else 0.dp
                    )
            )
        {
            Text(text = user.username,
                style = MaterialTheme.typography.h1.copy(
                    fontSize = 24.sp
                ),
                textAlign = TextAlign.Center
            )
            if (isOwnProfile){
                Spacer(modifier = Modifier.width(SpacingSmall))
                IconButton(
                    onClick = onEditClick,
                    modifier = Modifier.size(30.dp)

                ) {
                    Icon(imageVector = Icons.Default.Edit,
                        contentDescription = stringResource(id = R.string.edit)
                    )
                }
            }

        }
        Spacer(modifier = Modifier.height(SpacingMedium))
        Text(
            text = user.description,
            style = MaterialTheme.typography.body2,
            textAlign = TextAlign.Center
            )
        Spacer(modifier = Modifier.height(SpacingLarge))
        ProfileStats(user = user, modifier, isOwnProfile = isOwnProfile)
    }
}

