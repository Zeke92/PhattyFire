package com.phattyfire.presentation.login

import android.widget.Space
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.phattyfire.R
import com.phattyfire.presentation.components.StandardTextField
import com.phattyfire.presentation.ui.theme.SpacingLarge
import com.phattyfire.presentation.ui.theme.SpacingMedium
import com.phattyfire.presentation.ui.theme.SpacingSmall
import com.phattyfire.presentation.util.Screen

@Composable
    fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel()
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
                text = stringResource(id = R.string.login),
                style = MaterialTheme.typography.h1
            )
            Spacer(modifier = Modifier.height(SpacingSmall))
            StandardTextField(text = viewModel.usernameText.value,
                onValueChange =  {
                    viewModel.setUsernameText(it)
                },
                error = viewModel.isUserNameError.value,
                hint = stringResource(id = R.string.login_hint)

            )
            Spacer(modifier = Modifier.height(SpacingSmall))
            StandardTextField(text = viewModel.passwordText.value,
                onValueChange =  {
                    viewModel.setPasswordText(it)
                },
                hint = stringResource(id = R.string.password_hint),
                keyboardType = KeyboardType.Password,
                error = viewModel.isPasswordError.value,
                showPasswordToggle = viewModel.showPassword.value,
                onPasswordToggleClick = {
                    viewModel.setShowPassWord(it)
                }

            )
            Spacer(modifier = Modifier.height(SpacingMedium))
            Button(
                onClick = {
                          navController.navigate(
                              Screen.MainFeedScreen.route
                          )
                },
            modifier = Modifier
                .align(Alignment.End))
            {
                Text(
                    text = stringResource(id = R.string.login),
                    color = MaterialTheme.colors.onPrimary

                )
            }

        }
        Text(
            text = buildAnnotatedString {
                append(stringResource(id = R.string.dont_have_an_account_yet))
                append(" ")
                val signUpText = stringResource(id = R.string.sign_up)
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
                    navController.navigate(
                        Screen.RegisterScreen.route
                    )
                }
        )

    }

}

