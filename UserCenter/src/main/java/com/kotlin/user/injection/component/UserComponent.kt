package com.kotlin.user.injection.component

import com.kotlin.user.injection.module.UserModule
import com.kotlin.user.ui.activity.RegisterActivity
import dagger.Component
import dagger.Module

/**
 * Created by ZFL on 2018/3/6
 */
@Component(modules = arrayOf(UserModule::class))
interface UserComponent {
    fun inject(activity: RegisterActivity)
}