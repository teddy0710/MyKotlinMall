package com.kotlin.goods.service.impl

import com.kotlin.base.ext.convert
import com.kotlin.goods.data.protocol.Category
import com.kotlin.goods.data.respository.CategoryRepository
import com.kotlin.goods.service.CategoryService
import rx.Observable
import javax.inject.Inject

/**
 * Created by ZFL on 2018/3/5
 */
class CategoryServiceImpl @Inject constructor() : CategoryService {
    @Inject
    lateinit var repository: CategoryRepository

    override fun getCategory(parentId: Int): Observable<MutableList<Category>?> {
        return repository.getCateGory(parentId).convert()
    }
}