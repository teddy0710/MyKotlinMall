package com.kotlin.user.data.api

import com.kotlin.base.data.protocol.BaseResp
import com.kotlin.user.data.protocol.LoginReq
import com.kotlin.user.data.protocol.RegisterReq
import com.kotlin.user.data.protocol.UserInfo
import retrofit2.http.Body
import retrofit2.http.POST
import rx.Observable

/**
 * 提供注册功能接口
 * Created by TEDDY on 2018/3/5.
 */
interface UserApi {
    /*
    注册
     */
    @POST("userCenter/register")
    fun register(@Body req: RegisterReq): Observable<BaseResp<String>>

    /*
    登录
     */
    @POST("userCenter/login")
    fun login(@Body req: LoginReq): Observable<BaseResp<UserInfo>>
}