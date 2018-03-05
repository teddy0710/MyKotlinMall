package com.kotlin.user.data.protocol

/**
 * 数据类
 * Created by TEDDY on 2018/3/5.
 */
data class RegisterReq(val mobile: String, val pwd: String, val verifyCode: String) {
}