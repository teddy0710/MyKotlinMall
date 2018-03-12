package com.kotlin.goods.ui.activity

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import com.kennyc.view.MultiStateView
import com.kotlin.base.ext.startLoading
import com.kotlin.base.ui.activity.BaseMvpActivity
import com.kotlin.goods.R
import com.kotlin.goods.data.protocol.Goods
import com.kotlin.goods.injection.component.DaggerGoodsComponent
import com.kotlin.goods.injection.module.GoodsModule
import com.kotlin.goods.presenter.GoodsListPresenter
import com.kotlin.goods.presenter.view.GoodsListView
import com.kotlin.goods.ui.adapter.GoodsAdapter
import kotlinx.android.synthetic.main.activity_goods.*

/**
 * Created by ZFL on 2018/3/12
 */
class GoodsActivity : BaseMvpActivity<GoodsListPresenter>(), GoodsListView {
    private lateinit var mGoodsAdapter: GoodsAdapter
    override fun injectComponent() {
        DaggerGoodsComponent.builder()
                .activityComponent(activityComponent)
                .goodsModule(GoodsModule())
                .build().inject(this)
        mPresenter.mView = this
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_goods)
        initView()
        loadData()
    }


    private fun initView() {
        mGoodsRv.layoutManager = GridLayoutManager(this, 2)
        mGoodsAdapter = GoodsAdapter(this)
        mGoodsRv.adapter = mGoodsAdapter
    }


    private fun loadData() {
        mMultiStateView.startLoading()
        mPresenter.getCategory(intent.getIntExtra("categoryId", 1), 1)

    }


    override fun onGetGoodsListResult(result: MutableList<Goods>?) {
        if (result != null && result.size > 0) {//有商品数据
            mGoodsAdapter.setData(result)
            mMultiStateView.viewState = MultiStateView.VIEW_STATE_CONTENT
        } else {//无数据
            mMultiStateView.viewState = MultiStateView.VIEW_STATE_EMPTY
        }
    }
}