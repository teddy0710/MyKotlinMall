package com.kotlin.user.ui.presenter.view

import com.kotlin.base.presenter.view.BaseView

/**
 * Created by ZFL on 2018/3/5
 */
interface RegisterView :BaseView{
    fun onRegisterResult(result: Boolean)
}