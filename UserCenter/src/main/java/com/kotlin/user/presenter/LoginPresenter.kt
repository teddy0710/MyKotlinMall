package com.kotlin.user.presenter

import android.util.Log
import com.kotlin.base.ext.execute
import com.kotlin.base.presenter.BasePresenter
import com.kotlin.base.rx.BaseSubscriber
import com.kotlin.user.data.protocol.UserInfo
import com.kotlin.user.presenter.view.LoginView
import com.kotlin.user.presenter.view.RegisterView
import com.kotlin.user.service.UserService
import javax.inject.Inject
import javax.inject.Named

/**
 * Created by ZFL on 2018/3/5
 */
class LoginPresenter @Inject constructor() : BasePresenter<LoginView>() {
    @Inject
    lateinit var userService: UserService


    fun login(mobile: String, pwd: String, pushId: String) {
        if (!checkNetWork()) {
            return
        }
        userService.login(mobile, pwd, pushId)
                .execute(object : BaseSubscriber<UserInfo>(mView) {
                    override fun onNext(t: UserInfo) {
                        mView.onLoginResult(t)
                    }
                }, lifecycleProvider)
    }

}