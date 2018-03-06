package com.kotlin.user.injection.module

import com.kotlin.user.service.UserService
import com.kotlin.user.service.impl.UserServiceImpl
import dagger.Module
import dagger.Provides

/**
 * Created by ZFL on 2018/3/6
 */
@Module
class UserModule {
    @Provides
    fun providesUserService(serviceImpl: UserServiceImpl): UserService {
        return serviceImpl
    }

}