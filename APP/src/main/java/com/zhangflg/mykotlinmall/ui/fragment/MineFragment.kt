package com.zhangflg.mykotlinmall.ui.fragment

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kotlin.base.common.BaseConstant
import com.kotlin.base.ext.loadUrl
import com.kotlin.base.ui.fragment.BaseFragment
import com.kotlin.base.utils.AppPrefsUtils
import com.kotlin.base.utils.GlideUtils
import com.kotlin.base.widgets.BannerImageLoader
import com.kotlin.mall.common.*
import com.kotlin.mall.ui.adapter.TopicAdapter
import com.kotlin.provider.common.ProviderConstant
import com.youth.banner.BannerConfig
import com.youth.banner.Transformer
import com.zhangflg.mykotlinmall.R
import com.zhangflg.mykotlinmall.ui.adapter.HomeDisCountAdapter
import kotlinx.android.synthetic.main.fragment_mine.*
import me.crosswall.lib.coverflow.CoverFlow

/**
 * Created by ZFL on 2018/3/10
 */
class MineFragment : BaseFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_mine, null)
    }

    override fun onStart() {
        super.onStart()
        loadData()
    }

    private fun loadData() {
        if (AppPrefsUtils.getString(BaseConstant.KEY_SP_TOKEN).isNotBlank()) {
            val iconUrl = AppPrefsUtils.getString(ProviderConstant.KEY_SP_USER_ICON)
            if (iconUrl.isNotBlank()) {
                mUserIconIv.loadUrl(iconUrl)
            }
        }

    }
}