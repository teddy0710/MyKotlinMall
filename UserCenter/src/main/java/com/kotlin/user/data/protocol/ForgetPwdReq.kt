package com.kotlin.user.data.protocol

/**
 * 数据类 忘记密码请求
 * Created by TEDDY on 2018/3/5.
 */
data class ForgetPwdReq(val mobile: String, val verityCode: String)