package com.zhangflg.mykotlinmall.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kotlin.base.ext.loadUrl
import com.kotlin.base.ext.onClick
import com.kotlin.base.ui.fragment.BaseFragment
import com.kotlin.base.utils.AppPrefsUtils
import com.kotlin.provider.common.ProviderConstant
import com.kotlin.provider.common.isLogined
import com.kotlin.user.ui.activity.LoginActivity
import com.kotlin.user.ui.activity.UserInfoActivity
import com.zhangflg.mykotlinmall.R
import com.zhangflg.mykotlinmall.ui.activity.SettingActivity
import kotlinx.android.synthetic.main.fragment_mine.*
import org.jetbrains.anko.support.v4.startActivity

/**
 * Created by ZFL on 2018/3/10
 */
class MineFragment : BaseFragment(), View.OnClickListener {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_mine, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        mUserIconIv.onClick(this)
        mUserNameTv.onClick(this)
        mSettingTv.onClick(this)
    }

    override fun onStart() {
        super.onStart()
        loadData()
    }

    private fun loadData() {
        if (!isLogined()) {
            mUserIconIv.setImageResource(R.drawable.icon_default_user)
            mUserNameTv.text = getString(R.string.un_login_text)
        } else {
            val iconUrl = AppPrefsUtils.getString(ProviderConstant.KEY_SP_USER_ICON)
            if (iconUrl.isNotBlank()) {
                mUserIconIv.loadUrl(iconUrl)
            }
            mUserNameTv.text = AppPrefsUtils.getString(ProviderConstant.KEY_SP_USER_NAME)
        }

    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.mUserIconIv, R.id.mUserNameTv -> {
                if (isLogined()) {
                    startActivity<UserInfoActivity>()
                } else {
                    startActivity<LoginActivity>()
                }
            }
            R.id.mSettingTv -> {
                startActivity<SettingActivity>()
            }
        }
    }
}