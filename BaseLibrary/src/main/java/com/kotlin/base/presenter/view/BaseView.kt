package com.kotlin.base.presenter.view

/**
 * Created by ZFL on 2018/3/5
 */
interface BaseView {
    fun showLoading()
    fun hideLoading()
    fun onError(string: String)
}