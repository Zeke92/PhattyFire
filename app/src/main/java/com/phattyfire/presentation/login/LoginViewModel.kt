package com.phattyfire.presentation.login

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {

    private val _usernameText = mutableStateOf("")
    val usernameText: State<String> = _usernameText

    private val _passwordText = mutableStateOf("")
    val passwordText: State<String> = _passwordText

    private val _showPassword = mutableStateOf(false)
    val showPassword: State<Boolean> = _showPassword

    private val _userNameError = mutableStateOf("")
    val isUserNameError: State<String> = _userNameError

    private val _passwordError = mutableStateOf("")
    val isPasswordError: State<String> = _passwordError



    fun setUsernameText(username : String){
        _usernameText.value = username

    }
    fun setPasswordText(password : String){
        _passwordText.value = password

    }

    fun setShowPassWord(showPassword: Boolean){
        _showPassword.value = showPassword
    }

    fun setIsUserNameError(isError: String){
        _userNameError.value = isError
    }

    fun setIsPasswordError(isError: String){
        _passwordError.value = isError
    }

}