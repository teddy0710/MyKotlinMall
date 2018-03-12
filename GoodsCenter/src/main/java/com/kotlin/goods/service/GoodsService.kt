package com.kotlin.goods.service

import com.kotlin.goods.data.protocol.Goods
import rx.Observable

/**
 * Created by ZFL on 2018/3/5
 */
interface GoodsService {
    fun getGoodsList(categoryId: Int, pageNo: Int): Observable<MutableList<Goods>?>
}