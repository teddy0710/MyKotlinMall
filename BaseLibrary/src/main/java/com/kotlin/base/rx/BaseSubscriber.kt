package com.kotlin.base.rx

import com.kotlin.base.presenter.view.BaseView
import rx.Subscriber

/**
 * 封装rxJava Subscriber的通用方法
 * Created by ZFL on 2018/3/5
 */
open class BaseSubscriber<T>(val baseView: BaseView) : Subscriber<T>() {
    override fun onNext(t: T) {
        baseView.hideLoading()
    }

    override fun onCompleted() {
    }

    override fun onError(e: Throwable?) {
        baseView.hideLoading()
    }
}