package com.phattyfire.presentation.profile.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.phattyfire.presentation.ui.theme.SpacingLarge
import com.phattyfire.presentation.ui.theme.SpacingMedium
import com.phattyfire.presentation.ui.theme.SpacingSmall

@Composable
fun ProfileNumber(
    number: Int,
    text: String
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = number.toString(),
            style = MaterialTheme.typography.h1.copy(
                fontSize = 24.sp
            ),
            textAlign = TextAlign.Center
            )
        Spacer(modifier = Modifier.height(SpacingLarge))
        Text(
            text = text,
            style = MaterialTheme.typography.body2,
            textAlign = TextAlign.Center

            )


    }

}