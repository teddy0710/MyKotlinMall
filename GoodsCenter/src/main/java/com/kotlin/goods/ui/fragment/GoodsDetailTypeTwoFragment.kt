package com.kotlin.goods.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.eightbitlab.rxbus.Bus
import com.eightbitlab.rxbus.registerInBus
import com.kotlin.base.ext.loadUrl
import com.kotlin.base.ui.fragment.BaseFragment
import com.kotlin.goods.R
import com.kotlin.goods.event.GoodsDetailImageEvent
import kotlinx.android.synthetic.main.fragment_goods_detail_tab_two.*

/**
 * 商品详情Tab二
 * Created by TEDDY on 2018/3/12.
 */
class GoodsDetailTypeTwoFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_goods_detail_tab_two, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObserver()
    }

    private fun initObserver() {
        Bus.observe<GoodsDetailImageEvent>()
                .subscribe { t: GoodsDetailImageEvent ->
                    run {
                        mGoodsDetailOneIv.loadUrl(t.imageOne)
                        mGoodsDetailTwoIv.loadUrl(t.imageTwo)
                    }
                }
                .registerInBus(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        Bus.unregister(this)
    }


}