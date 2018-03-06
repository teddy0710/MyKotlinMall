package com.kotlin.base.injection.module

import android.app.Activity
import com.kotlin.base.injection.ActivityScope
import com.trello.rxlifecycle.LifecycleProvider
import dagger.Module
import dagger.Provides

/**
 * Created by ZFL on 2018/3/6
 */
@Module
class LifeCycleProviderModule(private val lifecycleProvider: LifecycleProvider<*>) {
    @Provides
    fun providesLifeCycleProvider(): LifecycleProvider<*> {
        return lifecycleProvider
    }
}