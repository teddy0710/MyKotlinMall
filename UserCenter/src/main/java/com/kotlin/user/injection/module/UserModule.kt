package com.kotlin.user.injection.module

import com.kotlin.user.service.UserService
import com.kotlin.user.service.impl.UserServiceImpl
import com.kotlin.user.service.impl.UserServiceImpl2
import dagger.Module
import dagger.Provides
import javax.inject.Named

/**
 * Created by ZFL on 2018/3/6
 */
@Module
class UserModule {
    @Provides
    @Named("service")
    fun providesUserService(service: UserServiceImpl): UserService {
        return service
    }

    @Provides
    @Named("service2")
    fun providesUserService2(service: UserServiceImpl2): UserService {
        return service
    }

}