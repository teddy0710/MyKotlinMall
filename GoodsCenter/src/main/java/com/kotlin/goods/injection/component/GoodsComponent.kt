package com.kotlin.goods.injection.component

import com.kotlin.base.injection.PerComponentScope
import com.kotlin.base.injection.component.ActivityComponent
import com.kotlin.goods.injection.module.GoodsModule
import com.kotlin.goods.ui.activity.GoodsActivity
import dagger.Component

/**
 * Created by ZFL on 2018/3/6
 */
@PerComponentScope
@Component(dependencies = [(ActivityComponent::class)], modules = [(GoodsModule::class)])
interface GoodsComponent {
    fun inject(activity: GoodsActivity)
}