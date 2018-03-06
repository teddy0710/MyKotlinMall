package com.kotlin.base.injection

import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import javax.inject.Scope

/**
 * Created by ZFL on 2018/3/6
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
annotation class PerComponentScope