package com.phattyfire.domain.models

data class User(
    val profilePrictureUrl: String,
    val username: String,
    val description: String,
    val followerCount: Int,
    val folowingCount: Int,
    val postCount: Int
)
