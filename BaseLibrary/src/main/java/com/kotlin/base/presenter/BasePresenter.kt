package com.kotlin.base.presenter

import com.kotlin.base.presenter.view.BaseView

/**
 * BasePresenter 许要持有一个BaseView的引用
 * Created by ZFL on 2018/3/5
 */
open class BasePresenter<T:BaseView> {
    lateinit var mView:T
}