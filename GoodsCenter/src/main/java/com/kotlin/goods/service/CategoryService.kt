package com.kotlin.goods.service

import com.kotlin.goods.data.protocol.Category
import rx.Observable

/**
 * Created by ZFL on 2018/3/5
 */
interface CategoryService {
    fun getCategory(parentId: Int): Observable<MutableList<Category>?>
}