package com.kotlin.user.presenter

import com.kotlin.base.presenter.BasePresenter
import com.kotlin.user.presenter.view.UserInfoView
import com.kotlin.user.service.UserService
import javax.inject.Inject

/**
 * Created by ZFL on 2018/3/5
 */
class UserInfoPresenter @Inject constructor() : BasePresenter<UserInfoView>() {
    @Inject
    lateinit var userService: UserService


}