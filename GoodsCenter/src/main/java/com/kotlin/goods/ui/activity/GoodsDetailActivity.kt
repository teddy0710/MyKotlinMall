package com.kotlin.goods.ui.activity

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.view.View
import com.kotlin.base.ui.activity.BaseActivity
import com.kotlin.goods.R
import com.kotlin.goods.ui.adapter.GoodsDetailVpAdapter
import kotlinx.android.synthetic.main.activity_goods_detail.*

/**
 * 商品详情
 */
class GoodsDetailActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_goods_detail)
        initView()
    }

    private fun initView() {
        mGoodsDetailTab.tabMode = TabLayout.MODE_FIXED
        mGoodsDetailVp.adapter = GoodsDetailVpAdapter(supportFragmentManager, this)

        mGoodsDetailTab.setupWithViewPager(mGoodsDetailVp)
    }

    fun getRootView(): View {
        return mRootView
    }
}
