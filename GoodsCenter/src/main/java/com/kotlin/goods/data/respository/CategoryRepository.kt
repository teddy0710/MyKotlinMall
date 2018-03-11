package com.kotlin.goods.data.respository

import com.kotlin.base.data.net.RetrofitFactory
import com.kotlin.base.data.protocol.BaseResp
import com.kotlin.goods.data.api.CategoryApi
import com.kotlin.goods.data.protocol.Category
import com.kotlin.goods.data.protocol.GetCategoryReq
import rx.Observable
import javax.inject.Inject

/**
 * 真正请求网络的地方
 * Created by TEDDY on 2018/3/5.
 */
class CategoryRepository @Inject constructor() {
    fun getCateGory(parentId: Int): Observable<BaseResp<MutableList<Category>?>> {
        return RetrofitFactory.instance
                .create(CategoryApi::class.java)
                .getCategory(GetCategoryReq(parentId))
    }
}