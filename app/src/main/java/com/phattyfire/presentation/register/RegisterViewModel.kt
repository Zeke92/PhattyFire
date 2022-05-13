package com.phattyfire.presentation.register


import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor() : ViewModel() {

    private val _usernameText = mutableStateOf("")
    val usernameText: State<String> = _usernameText

    private val _emailText = mutableStateOf("")
    val emailText: State<String> = _emailText

    private val _passwordText = mutableStateOf("")
    val passwordText: State<String> = _passwordText

    private val _showPassword = mutableStateOf(false)
    val showPassword: State<Boolean> = _showPassword

    private val _userNameError = mutableStateOf("")
    val isUserNameError: State<String> = _userNameError

    private val _passwordError = mutableStateOf("")
    val isPasswordError: State<String> = _passwordError

    private val _emailError = mutableStateOf("")
    val emailError: State<String> = _emailError



    fun setUsernameText(username : String){
        _usernameText.value = username

    }

    fun setEmailText(email : String){
        _emailText.value = email

    }

    fun setPasswordText(password : String){
        _passwordText.value = password

    }

    fun setShowPassWord(showPassword: Boolean){
        _showPassword.value = showPassword
    }

    fun setIsUserNameError(error: String){
        _userNameError.value = error
    }

    fun setIsPasswordError(error: String){
        _passwordError.value = error
    }

    fun setIsEmailError(error: String){
        _emailError.value = error
    }

}