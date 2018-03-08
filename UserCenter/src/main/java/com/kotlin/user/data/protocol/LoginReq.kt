package com.kotlin.user.data.protocol

/**
 * 数据类 登录请求
 * Created by TEDDY on 2018/3/5.
 */
data class LoginReq(val mobile: String, val pwd: String, val pushId: String)