package com.kotlin.user.service.impl

import com.kotlin.base.ext.convert
import com.kotlin.base.ext.convertBoolean
import com.kotlin.user.data.protocol.UserInfo
import com.kotlin.user.data.repository.UserRepository
import com.kotlin.user.service.UserService
import rx.Observable
import javax.inject.Inject

/**
 * Created by ZFL on 2018/3/5
 */
class UserServiceImpl @Inject constructor() : UserService {
    @Inject
    lateinit var repository: UserRepository

    /**
     * 注册
     */
    override fun register(mobile: String, pwd: String, verifyCode: String): Observable<Boolean> {
        return repository.register(mobile, pwd, verifyCode)
                .convertBoolean()//.flatMap(BaseFuncBoolean())

    }

    /*
    登录
     */
    override fun login(mobile: String, pwd: String, pushId: String):
            Observable<UserInfo> {
        return repository.login(mobile, pwd, pushId)
                .convert()
    }
}