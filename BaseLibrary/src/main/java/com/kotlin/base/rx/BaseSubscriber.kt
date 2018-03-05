package com.kotlin.base.rx

import rx.Subscriber

/**
 * 封装rxJava Subscriber的通用方法
 * Created by ZFL on 2018/3/5
 */
open class BaseSubscriber<T> : Subscriber<T>() {
    override fun onNext(t: T) {
    }

    override fun onCompleted() {
    }

    override fun onError(e: Throwable?) {
    }
}