package com.kotlin.goods.service.impl

import com.kotlin.base.ext.convert
import com.kotlin.goods.data.protocol.Category
import com.kotlin.goods.data.protocol.Goods
import com.kotlin.goods.data.repository.GoodsRepository
import com.kotlin.goods.data.respository.CategoryRepository
import com.kotlin.goods.service.CategoryService
import com.kotlin.goods.service.GoodsService
import rx.Observable
import javax.inject.Inject

/**
 * Created by ZFL on 2018/3/5
 */
class GoodsServiceImpl @Inject constructor() : GoodsService {


    @Inject
    lateinit var repository: GoodsRepository

    override fun getGoodsList(categoryId: Int, pageNo: Int): Observable<MutableList<Goods>?> {
        return repository.getGoodsList(categoryId,pageNo).convert()
    }
}