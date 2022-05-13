package com.phattyfire.presentation.splash

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.navigation.NavController
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.phattyfire.presentation.MainActivity
import com.phattyfire.presentation.ui.theme.PhattyFireTheme
import com.phattyfire.presentation.util.Screen
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineScheduler
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)


class SplashScreenTest {

    @get: Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @RelaxedMockK
    lateinit var navController: NavController

    private val testDispatcher = TestCoroutineScheduler()

    @Before
    fun setUp(){
        MockKAnnotations.init(this)

    }

    @Test
    fun splashScreen_displaysAndDisappears() =  runBlocking{

        composeTestRule.setContent {
            PhattyFireTheme {
                SplashScreen(navController = navController)

            }
        }

        composeTestRule
            .onNodeWithContentDescription("Logo")
            .assertExists()


        verify {
            navController.popBackStack()
            navController.navigate(Screen.LoginScreen.route)

        }
    }
}