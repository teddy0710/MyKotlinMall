package com.kotlin.user.presenter

import com.kotlin.base.ext.execute
import com.kotlin.base.presenter.BasePresenter
import com.kotlin.base.rx.BaseSubscriber
import com.kotlin.user.data.protocol.UserInfo
import com.kotlin.user.presenter.view.UserInfoView
import com.kotlin.user.service.UploadService
import com.kotlin.user.service.UserService
import javax.inject.Inject

/**
 * Created by ZFL on 2018/3/5
 */
class UserInfoPresenter @Inject constructor() : BasePresenter<UserInfoView>() {
    @Inject
    lateinit var userService: UserService

    @Inject
    lateinit var uploadService: UploadService

    fun getUploadToken() {
        if (!checkNetWork()) {
            return
        }
        uploadService.getUploadToken().execute(object : BaseSubscriber<String>(mView) {
            override fun onNext(t: String) {
                mView.onGetUploadTokenResult(t)
            }
        }, lifecycleProvider)
    }

    fun editUser(userIcon: String, userName: String,
                 userGender: String, userSign: String) {
        if (!checkNetWork()) {
            return
        }
        userService.editUser(userIcon, userName, userGender, userSign)
                .execute(object : BaseSubscriber<UserInfo>(mView) {
                    override fun onNext(t: UserInfo) {
                        mView.onGetEditUserResult(t)
                    }
                }, lifecycleProvider)
    }


}