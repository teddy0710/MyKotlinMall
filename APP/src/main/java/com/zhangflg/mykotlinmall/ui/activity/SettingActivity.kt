package com.zhangflg.mykotlinmall.ui.activity

import android.os.Bundle
import com.kotlin.base.common.AppManager
import com.kotlin.base.ext.onClick
import com.kotlin.base.ui.activity.BaseActivity
import com.kotlin.user.utils.UserPrefsUtils
import com.zhangflg.mykotlinmall.R
import kotlinx.android.synthetic.main.activity_setting.*

/**
 * 设置
 * Created by TEDDY on 2018/3/12.
 */
class SettingActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)
        mLogoutBtn.onClick {
            UserPrefsUtils.putUserInfo(null)
            AppManager.instance.finishActivity(this)
        }
    }
}