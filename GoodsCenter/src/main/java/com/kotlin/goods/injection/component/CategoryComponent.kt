package com.kotlin.goods.injection.component

import com.kotlin.base.injection.PerComponentScope
import com.kotlin.base.injection.component.ActivityComponent
import com.kotlin.goods.injection.module.CategoryModule
import com.kotlin.goods.ui.fragment.CategoryFragment
import dagger.Component

/**
 * Created by ZFL on 2018/3/6
 */
@PerComponentScope
@Component(dependencies = [(ActivityComponent::class)], modules = [(CategoryModule::class)])
interface CategoryComponent {
    fun inject(fragment: CategoryFragment)
}