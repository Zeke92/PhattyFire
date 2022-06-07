package com.phattyfire.presentation.profile.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.phattyfire.R
import com.phattyfire.presentation.ui.theme.SpacingSmall
import com.phattyfire.presentation.util.toPx

@Composable
fun BannerSection(
    modifier: Modifier = Modifier,
    iconSize: Dp = 30.dp,
    onFaceBookClick: () -> Unit = {},
    onInstagramClick: () -> Unit = {},
    onLinkedInClick: () -> Unit = {}
) {
    BoxWithConstraints(
        modifier = modifier
    ) {

        Image(
            painter = painterResource(id = R.drawable.untitledtest6),
            contentDescription = stringResource(id = R.string.banner_image),
            modifier = Modifier
                .fillMaxSize()

        )
        Box(
            modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.Transparent,
                        Color.Black
                    ),
                    startY = constraints.maxHeight - iconSize.toPx() * 2f
                )
            )
        )
        Row(
            modifier = Modifier
                .height(iconSize)
                .align(Alignment.BottomStart)
                .padding(SpacingSmall)
        ) {

            Image(
                painter = painterResource(id = R.drawable.ic_facebook),
                contentDescription = "facebook",
                modifier = Modifier.height(iconSize)

            )
            Spacer(modifier = Modifier.padding(SpacingSmall))

            Image(
                painter = painterResource(id = R.drawable.ic_instagram),
                contentDescription = "instagram",
                modifier = Modifier.height(iconSize)

            )


        }
        Row(
            modifier = Modifier
                .height(iconSize)
                .align(
                    Alignment.BottomEnd
                )
        ) {
            IconButton(
                onClick = { onFaceBookClick },
                modifier = Modifier.height(iconSize)

            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = "demo1" )

            }

            IconButton(
                onClick = { onInstagramClick },
                modifier = Modifier.height(iconSize)

            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = "demo2" )

            }


        }
    }
}

