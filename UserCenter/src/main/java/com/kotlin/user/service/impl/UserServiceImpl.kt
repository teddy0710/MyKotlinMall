package com.kotlin.user.service.impl

import com.kotlin.user.service.UserService
import rx.Observable

/**
 * Created by ZFL on 2018/3/5
 */
class UserServiceImpl : UserService {
    override fun register(mobile: String, verifyCode: String, pwd: String): Observable<Boolean> {
        return Observable.just(true)
    }
}