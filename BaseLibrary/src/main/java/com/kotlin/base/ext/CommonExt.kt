package com.kotlin.base.ext

import com.kotlin.base.rx.BaseSubscriber
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by ZFL on 2018/3/5
 */
fun <T> Observable<T>.execute(subscriber: BaseSubscriber<T>) {
    this.observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(subscriber)
}