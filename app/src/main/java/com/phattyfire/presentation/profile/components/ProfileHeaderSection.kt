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
import com.phattyfire.presentation.ui.theme.ProfilePictureLarge
import com.phattyfire.presentation.ui.theme.ProfilePictureSize
import com.phattyfire.presentation.ui.theme.SpacingSmall

@Composable
fun ProfileHeaderSection(
    user: User,
    modifier: Modifier = Modifier,
    onEditClick: () -> Unit = {}

){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .offset(y = -ProfilePictureLarge / 2f)
    ) {
        Image(
            painter = painterResource(id = R.drawable.cat),
            contentDescription = stringResource(id = R.string.profile_image),
            modifier = Modifier
                .aspectRatio(1f)
                .size(ProfilePictureLarge)
                .clip(CircleShape)
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colors.onSurface
                )

        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .offset(x = -(SpacingSmall + 30.dp))
            )
        {
            Text(text = user.username,
                style = MaterialTheme.typography.h1.copy(
                    fontSize = 24.sp
                ),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.width(SpacingSmall))
            IconButton(
                onClick = onEditClick,
                modifier = Modifier.size(30.dp)

                ) {
                Icon(imageVector = Icons.Default.Edit,
                    contentDescription = stringResource(id = R.string.edit) )
            }
        }
    }
}

