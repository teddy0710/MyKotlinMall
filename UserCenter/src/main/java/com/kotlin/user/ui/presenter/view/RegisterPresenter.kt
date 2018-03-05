package com.kotlin.user.ui.presenter.view

import com.kotlin.base.presenter.BasePresenter

/**
 * Created by ZFL on 2018/3/5
 */
class RegisterPresenter : BasePresenter<RegisterView>() {
    fun register(mobile: String, verifyCode: String) {
        /*业务逻辑
         */
        mView.onRegisterResult(true)
    }
}