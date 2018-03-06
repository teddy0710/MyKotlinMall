package com.kotlin.base.injection.module

import android.content.Context
import com.kotlin.base.common.BaseApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by ZFL on 2018/3/6
 */
@Module
class AppModule(private val context: BaseApplication) {
    @Provides
    @Singleton
    fun providesContext(): Context {
        return context
    }
}