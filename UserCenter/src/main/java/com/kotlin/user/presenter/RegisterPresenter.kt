package com.kotlin.user.presenter

import com.kotlin.base.ext.execute
import com.kotlin.base.presenter.BasePresenter
import com.kotlin.base.rx.BaseSubscriber
import com.kotlin.user.presenter.view.RegisterView
import com.kotlin.user.service.UserService
import javax.inject.Inject
import javax.inject.Named

/**
 * Created by ZFL on 2018/3/5
 */
class RegisterPresenter @Inject constructor() : BasePresenter<RegisterView>() {
    @Inject
    @field:[Named ("service")]
    lateinit var userService: UserService

    @Inject
    @field:[Named ("service2")]
    lateinit var userService2: UserService

    fun register(mobile: String, pwd: String, verifyCode: String) {
        /*
            业务逻辑
         */
        userService.register(mobile, pwd, verifyCode)
                .execute(object : BaseSubscriber<Boolean>() {
                    override fun onNext(t: Boolean) {
                        mView.onRegisterResult(t)
                    }
                })
    }
    fun register2(mobile: String, pwd: String, verifyCode: String) {
        /*
            业务逻辑
         */
        userService2.register(mobile, pwd, verifyCode)
                .execute(object : BaseSubscriber<Boolean>() {
                    override fun onNext(t: Boolean) {
                        mView.onRegisterResult(t)
                    }
                })
    }
}