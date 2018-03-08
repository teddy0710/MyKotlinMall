package com.kotlin.user.data.protocol

/**
 * 用户实体类
 * Created by TEDDY on 2018/3/8.
 */
data class UserInfo(
        val id: String,
        val userIcon: String,
        val userName: String,
        val userGender: String,
        val userMobile: String,
        val userSign: String
)