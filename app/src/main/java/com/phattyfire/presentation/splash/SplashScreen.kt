package com.phattyfire.presentation.splash

import android.view.animation.OvershootInterpolator
import android.window.SplashScreen
import androidx.compose.animation.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.phattyfire.R
import com.phattyfire.presentation.util.Screen
import com.phattyfire.util.Constants
import kotlinx.coroutines.*

@Composable
fun SplashScreen(
    navController: NavController,
    dispatcher: CoroutineDispatcher = Dispatchers.Main
){
    val coroutineScope = rememberCoroutineScope()
    val scale = remember {
        androidx.compose.animation.core.Animatable(0f)
    }
    val overshootInterpolator = remember {
        OvershootInterpolator(2f)
    }
    SideEffect {
        coroutineScope.launch(dispatcher) {
            scale.animateTo(
                targetValue = 0.5f,
                animationSpec = tween(
                    durationMillis = 500,
                    easing = {
                        overshootInterpolator.getInterpolation(it)
                    }
                )
            )
            delay(Constants.SPLASH_SCREEN_DURATION)
            navController.popBackStack()
            navController.navigate(Screen.LoginScreen.route){
                popUpTo(Screen.SplashScreen.route){
                    inclusive = true
                }

            }

        }
    }
    LaunchedEffect(key1 = true ){

    }
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Image(painter = painterResource(id = R.drawable.ic_satbackground),
            contentDescription = "Logo",
            modifier = Modifier.scale(scale.value)
        )
    }


}