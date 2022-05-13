package com.phattyfire.presentation.components

import android.widget.ToggleButton
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import com.phattyfire.R
import com.phattyfire.presentation.util.TestTags

@Composable
fun StandardTextField(
    modifier: Modifier = Modifier,
    text: String = "",
    hint: String = "",
    maxLength: Int = 40,
    error: String = "s",
    keyboardType: KeyboardType = KeyboardType.Text,
    showPasswordToggle: Boolean = false,
    onPasswordToggleClick: (Boolean) -> Unit = { },
    onValueChange: (String) -> Unit

){
    var isPasswordToggleDisplayed by remember {
        mutableStateOf(keyboardType == KeyboardType.Password)
    }
    var isPasswordVisible by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {

    }
    TextField(
        value = text,
        onValueChange = {
                        if(it.length <= maxLength){
                            onValueChange(it)
                        }
        },
        placeholder = {
            Text(text = hint,
                style = MaterialTheme.typography.body1
            )
        },
        isError = error != "",
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType
        ),
        visualTransformation = if(!showPasswordToggle && isPasswordToggleDisplayed){
            PasswordVisualTransformation()
        }else{
            VisualTransformation.None
             },

        singleLine = true,
        trailingIcon = {
            if (isPasswordToggleDisplayed){
                IconButton(
                    onClick = {
                    onPasswordToggleClick(!showPasswordToggle)
                },
                    modifier = Modifier
                        .semantics {
                            testTag = TestTags.PASSWORD_TOGGLE
                        }
                ) {
                    Icon(
                        imageVector = if (!showPasswordToggle){
                        Icons.Filled.VisibilityOff
                        }else{
                             Icons.Filled.Visibility
                    },

                       tint = MaterialTheme.colors.onSecondary,
                        contentDescription = if (!showPasswordToggle){
                            stringResource(id = R.string.password_visible_content_description)
                        }else{
                            stringResource(id = R.string.password_hidden_content_description)
                        }

                    )

                }
            }

        },
        modifier = modifier
            .semantics {
                testTag = TestTags.STANDARD_TEXT_FIELD
            }
    )

    if(error.isNotEmpty()){
        Text(text = error,
        style = MaterialTheme.typography.body2,
        color = MaterialTheme.colors.error,
            textAlign = TextAlign.End,
            modifier = Modifier
                .fillMaxWidth()
            )
    }

}