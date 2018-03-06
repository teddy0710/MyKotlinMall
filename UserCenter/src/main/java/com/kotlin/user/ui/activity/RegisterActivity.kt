package com.kotlin.user.ui.activity

import android.os.Bundle
import com.kotlin.base.ui.activity.BaseMvpActivity
import com.kotlin.user.R
import com.kotlin.user.injection.component.DaggerUserComponent
import com.kotlin.user.injection.module.UserModule
import com.kotlin.user.presenter.RegisterPresenter
import com.kotlin.user.presenter.view.RegisterView
import org.jetbrains.anko.toast
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : BaseMvpActivity<RegisterPresenter>(), RegisterView {
    override fun onRegisterResult(result: Boolean) {
        toast("注册成功")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

//        mPresenter = RegisterPresenter()
        initInjection()

        mRegisterBtn.setOnClickListener {
            mPresenter.register(mMobileEt.text.toString(),mPwd.text.toString(),mVerifyCodeEt.text.toString())
        }

    }

    private fun initInjection() {
        DaggerUserComponent.builder().userModule(UserModule()).build().inject(this)
        mPresenter.mView = this
    }
}
