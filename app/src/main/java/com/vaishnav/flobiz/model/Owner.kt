package com.vaishnav.flobiz.model

data class Owner(
    val profile_image: String? = null,
    val userType: String? = null,
    val userId: Int? = null,
    val link: String? = null,
    val reputation: Int? = null,
    val display_name: String? = null,
    val acceptRate: Int? = null
)