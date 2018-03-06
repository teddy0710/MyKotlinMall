package com.kotlin.base.injection

import java.lang.annotation.Retention
import javax.inject.Scope
import java.lang.annotation.RetentionPolicy.RUNTIME


/**
 * Created by ZFL on 2018/3/6
 */
@Scope
@Retention(RUNTIME)
annotation class ActivityScope