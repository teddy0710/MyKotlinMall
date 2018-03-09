package com.kotlin.user.data.api

import com.kotlin.base.data.protocol.BaseResp
import com.kotlin.user.data.protocol.*
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

    /*
    忘记密码
     */
    @POST("userCenter/forgetPwd")
    fun forgetPwd(@Body req: ForgetPwdReq): Observable<BaseResp<String>>

    /*
    重置密码
     */
    @POST("userCenter/resetPwd")
    fun resetPwd(@Body req: ResetPwdReq): Observable<BaseResp<String>>

    /*
    修改个人信息
     */
    @POST("userCenter/editUser")
    fun editUser(@Body req: EditUserReq): Observable<BaseResp<UserInfo>>
}