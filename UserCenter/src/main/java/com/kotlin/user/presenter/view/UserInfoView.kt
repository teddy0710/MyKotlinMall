package com.kotlin.user.presenter.view

import com.kotlin.base.presenter.view.BaseView
import com.kotlin.user.data.protocol.UserInfo

/**
 * Created by ZFL on 2018/3/5
 */
interface UserInfoView : BaseView {
    fun onGetUploadTokenResult(result: String)

    fun onGetEditUserResult(result: UserInfo)
}