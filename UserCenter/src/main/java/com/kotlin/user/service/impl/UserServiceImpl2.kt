package com.kotlin.user.service.impl

import com.kotlin.base.data.protocol.BaseResp
import com.kotlin.base.rx.BaseException
import com.kotlin.user.data.repository.UserRepository
import com.kotlin.user.service.UserService
import rx.Observable
import rx.functions.Func1
import javax.inject.Inject

/**
 * Created by ZFL on 2018/3/5
 */
class UserServiceImpl2 @Inject constructor(): UserService {
    @Inject
    lateinit var repository : UserRepository

    override fun register(mobile: String, pwd: String, verifyCode: String): Observable<Boolean> {
        return repository.register(mobile,pwd,verifyCode)
                .flatMap(object : Func1<BaseResp<String>, Observable<Boolean>> {
                    override fun call(t: BaseResp<String>): Observable<Boolean> {
                        if (t.status != 0) {
                            return Observable.error(BaseException(t.status, t.message))
                        }
                        return Observable.just(false)
                    }
                })
    }
}