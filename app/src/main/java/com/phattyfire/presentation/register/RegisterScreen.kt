package com.phattyfire.presentation.register

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.phattyfire.R
import com.phattyfire.presentation.components.StandardTextField
import com.phattyfire.presentation.register.RegisterViewModel
import com.phattyfire.presentation.ui.theme.SpacingLarge
import com.phattyfire.presentation.ui.theme.SpacingMedium
import com.phattyfire.presentation.ui.theme.SpacingSmall

@Composable
fun RegisterScreen(
    navController: NavController,
    viewModel: RegisterViewModel = hiltViewModel()
) {
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(
            start = SpacingLarge,
            end = SpacingLarge,
            top = SpacingLarge,
            bottom = 50.dp
        )
    ){

        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(SpacingMedium)
                .align(Alignment.Center),

            ) {
            Text(
                text = stringResource(id = R.string.register),
                style = MaterialTheme.typography.h1
            )
            Spacer(modifier = Modifier.height(SpacingSmall))
            StandardTextField(
                text = viewModel.emailText.value,
                onValueChange =  {
                    viewModel.setEmailText(it)
                },
                error = viewModel.emailError.value,
                hint = stringResource(id =R.string.email)

            )
            Spacer(modifier = Modifier.height(SpacingMedium))
            StandardTextField(
                text = viewModel.usernameText.value,
                onValueChange =  {
                    viewModel.setUsernameText(it)
                },
                error = viewModel.usernameText.value,
                hint = stringResource(id = R.string.username),


            )
            Spacer(modifier = Modifier.height(SpacingSmall))
            StandardTextField(text = viewModel.passwordText.value,
                onValueChange =  {
                    viewModel.setPasswordText(it)
                },
                hint = stringResource(id = R.string.password_hint),
                keyboardType = KeyboardType.Password,
                showPasswordToggle = viewModel.showPassword.value,
                onPasswordToggleClick = {
                    viewModel.setShowPassWord(it)
                }

            )
            Spacer(modifier = Modifier.height(SpacingMedium))
            Button(
                onClick = {},
                modifier = Modifier.align(Alignment.End))
            {
                Text(
                    text = stringResource(id = R.string.register),
                    color = MaterialTheme.colors.onPrimary

                )
            }

        }
        Text(
            text = buildAnnotatedString {
                append(stringResource(id = R.string.already_have_an_account))
                append(" ")
                val signUpText = stringResource(id = R.string.sign_in)
                withStyle(style = SpanStyle(
                    color = MaterialTheme.colors.primary
                ) ){
                    append(signUpText)
                }

            },
            style = MaterialTheme.typography.body1,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .clickable {
                    navController.popBackStack()
                }
        )

    }

}

