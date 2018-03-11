package com.kotlin.goods.injection.module

import com.kotlin.goods.service.CategoryService
import com.kotlin.goods.service.impl.CategoryServiceImpl
import dagger.Module
import dagger.Provides

/**
 * Created by ZFL on 2018/3/6
 */
@Module
class CategoryModule {
    @Provides
    fun providesCategoryService(service: CategoryServiceImpl): CategoryService {
        return service
    }
}