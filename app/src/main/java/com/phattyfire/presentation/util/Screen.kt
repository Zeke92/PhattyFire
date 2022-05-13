package com.phattyfire.presentation.util

sealed class Screen(val route: String){
    object SplashScreen : Screen("splash_screen")
    object LoginScreen : Screen("login_screen")
    object RegisterScreen : Screen("register_screen")
    object MainFeedScreen : Screen("main_screen")
    object ChatScreen : Screen("chat_screen")
    object ActivityScreen : Screen("activity_screen")
    object ETrainerScreen : Screen("e_trainer_screen")
    object ProfileScreen : Screen("profile_screen")
    object EditProfileScreen : Screen("edit_profile_screen")
    object SettingScreen : Screen("settings_screen")

}
