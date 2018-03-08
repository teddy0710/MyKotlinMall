package com.kotlin.user.ui.activity

import android.os.Bundle
import com.bigkoo.alertview.AlertView
import com.bigkoo.alertview.OnItemClickListener
import com.kotlin.base.ext.onClick
import com.kotlin.base.ui.activity.BaseMvpActivity
import com.kotlin.user.R
import com.kotlin.user.injection.component.DaggerUserComponent
import com.kotlin.user.injection.module.UserModule
import com.kotlin.user.presenter.UserInfoPresenter
import com.kotlin.user.presenter.view.UserInfoView
import kotlinx.android.synthetic.main.activity_user_info.*
import org.jetbrains.anko.toast

/*
用户信息界面
 */
class UserInfoActivity : BaseMvpActivity<UserInfoPresenter>(), UserInfoView {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_info)

        initView()

    }

    private fun initView() {
        mUserIconView.onClick {
            showAlertView()
        }
    }

    private fun showAlertView() {
        AlertView("选择图片","","取消",null, arrayOf("拍照","相册"),this,
                AlertView.Style.ActionSheet,object :OnItemClickListener{
            override fun onItemClick(o: Any?, position: Int) {
                when (position) {
                    0->toast("拍照")
                    1->toast("相册")
                }
            }
        }).show()

    }

    override fun injectComponent() {
        DaggerUserComponent.builder()
                .activityComponent(activityComponent)
                .userModule(UserModule())
                .build()
                .inject(this)
        mPresenter.mView = this
    }

}
