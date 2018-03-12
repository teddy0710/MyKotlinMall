package com.kotlin.goods.presenter.view

import com.kotlin.base.presenter.view.BaseView
import com.kotlin.goods.data.protocol.Goods

/**
 * Created by ZFL on 2018/3/5
 */
interface GoodsListView : BaseView {
    fun onGetGoodsListResult(result: MutableList<Goods>?)
}