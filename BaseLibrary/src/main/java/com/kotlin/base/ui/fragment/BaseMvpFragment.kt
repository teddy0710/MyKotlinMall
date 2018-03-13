package com.kotlin.base.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kotlin.base.common.BaseApplication
import com.kotlin.base.injection.component.ActivityComponent
import com.kotlin.base.injection.component.DaggerActivityComponent
import com.kotlin.base.injection.module.ActivityModule
import com.kotlin.base.injection.module.LifeCycleProviderModule
import com.kotlin.base.presenter.BasePresenter
import com.kotlin.base.presenter.view.BaseView
import com.kotlin.base.widgets.ProgressLoading
import org.jetbrains.anko.support.v4.toast
import javax.inject.Inject

/**
 * 持有BasePresenter的引用
 * 实现BaseView
 * Created by ZFL on 2018/3/5
 */
abstract class BaseMvpFragment<T : BasePresenter<*>> : BaseFragment(), BaseView {

    /*
    使用 @Inject 标注的属性
     */
    @Inject
    lateinit var mPresenter: T

    lateinit var activityComponent: ActivityComponent

    private lateinit var mLoadingDialog: ProgressLoading


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        initActivityInjection()
        injectComponent()
        //初始加载框
        mLoadingDialog = ProgressLoading.create(this.context!!)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    abstract fun injectComponent()

    private fun initActivityInjection() {
        activityComponent = DaggerActivityComponent
                .builder()
                .appComponent((activity!!.application as BaseApplication).appComponent)
                .activityModule(ActivityModule(activity!!))
                .lifeCycleProviderModule(LifeCycleProviderModule(this))
                .build()

    }

    /*
       显示加载框，默认实现
    */
    override fun showLoading() {
        mLoadingDialog.showLoading()
    }

    /*
        隐藏加载框，默认实现
     */
    override fun hideLoading() {
        mLoadingDialog.hideLoading()
    }

    /*
        错误信息提示，默认实现
     */
    override fun onError(string: String) {
        toast(string)
    }

}