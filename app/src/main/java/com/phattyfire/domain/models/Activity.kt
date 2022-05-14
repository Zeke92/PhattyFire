package com.phattyfire.domain.models

import com.phattyfire.domain.util.ActivityAction

data class Activity(
    val username: String,
    val actionType: ActivityAction,
    val timestamp: Long,
)
