package com.kotlin.base.common

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.alibaba.android.arouter.launcher.ARouter
import com.kotlin.base.injection.component.AppComponent
import com.kotlin.base.injection.component.DaggerAppComponent
import com.kotlin.base.injection.module.AppModule

/**
 * Created by ZFL on 2018/3/6
 */
open class BaseApplication : Application() {
    lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()

        initAppInjection()

        context = this

        //ARouter初始化
        ARouter.openLog()    // 打印日志
        ARouter.openDebug()
        ARouter.init(this)
    }

    private fun initAppInjection() {
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }

}