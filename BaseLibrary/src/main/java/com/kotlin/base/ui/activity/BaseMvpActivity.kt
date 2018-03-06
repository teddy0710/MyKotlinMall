package com.kotlin.base.ui.activity

import com.kotlin.base.presenter.BasePresenter
import com.kotlin.base.presenter.view.BaseView
import javax.inject.Inject

/**
 * 持有BasePresenter的引用
 * 实现BaseView
 * Created by ZFL on 2018/3/5
 */
open class BaseMvpActivity<T:BasePresenter<*>>: BaseActivity(),BaseView {
    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun onError() {
    }
    /*
    使用 @Inject 标注的属性
     */
    @Inject
    lateinit var mPresenter:T
}