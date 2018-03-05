package com.kotlin.user.service

import rx.Observable

/**
 * Created by ZFL on 2018/3/5
 */
interface UserService {
    fun register(mobile: String, verifyCode: String, pwd: String): Observable<Boolean>
}