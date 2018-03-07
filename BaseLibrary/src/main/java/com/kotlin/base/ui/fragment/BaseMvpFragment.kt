package com.kotlin.base.ui.fragment

import android.os.Bundle
import com.kotlin.base.common.BaseApplication
import com.kotlin.base.injection.component.ActivityComponent
import com.kotlin.base.injection.component.DaggerActivityComponent
import com.kotlin.base.injection.module.ActivityModule
import com.kotlin.base.injection.module.LifeCycleProviderModule
import com.kotlin.base.presenter.BasePresenter
import com.kotlin.base.presenter.view.BaseView
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initActivityInjection()
        injectComponent()
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

    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun onError(string: String) {
        toast(string)
    }

}