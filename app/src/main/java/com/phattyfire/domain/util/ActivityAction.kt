package com.phattyfire.domain.util

sealed class ActivityAction{
    object LikedPost : ActivityAction()
    object CommentedOnPost : ActivityAction()
}
