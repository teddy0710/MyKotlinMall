package com.kotlin.base.injection.component

import android.app.Activity
import android.content.Context
import com.kotlin.base.injection.ActivityScope
import com.kotlin.base.injection.module.ActivityModule
import com.kotlin.base.injection.module.LifeCycleProviderModule
import com.trello.rxlifecycle.LifecycleProvider
import dagger.Component

/**
 * Created by ZFL on 2018/3/6
 */
@ActivityScope
@Component(dependencies = [(AppComponent::class)],
        modules = [(ActivityModule::class), (LifeCycleProviderModule::class)])
interface ActivityComponent {
    fun activity(): Activity
    fun context():Context
    fun LifeCycleProvider(): LifecycleProvider<*>
}