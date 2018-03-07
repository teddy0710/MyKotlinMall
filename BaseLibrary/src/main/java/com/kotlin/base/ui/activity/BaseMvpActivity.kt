package com.kotlin.base.ui.activity

import android.os.Bundle
import com.kotlin.base.common.BaseApplication
import com.kotlin.base.injection.component.ActivityComponent
import com.kotlin.base.injection.component.DaggerActivityComponent
import com.kotlin.base.injection.module.ActivityModule
import com.kotlin.base.injection.module.LifeCycleProviderModule
import com.kotlin.base.presenter.BasePresenter
import com.kotlin.base.presenter.view.BaseView
import com.kotlin.base.widgets.ProgressLoading
import org.jetbrains.anko.toast
import javax.inject.Inject

/**
 * 持有BasePresenter的引用
 * 实现BaseView
 * Created by ZFL on 2018/3/5
 */
abstract class BaseMvpActivity<T : BasePresenter<*>> : BaseActivity(), BaseView {

    /*
    使用 @Inject 标注的属性
     */
    @Inject
    lateinit var mPresenter: T

    lateinit var activityComponent: ActivityComponent

    private lateinit var mLoadingDialog:ProgressLoading

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initActivityInjection()
        injectComponent()

        mLoadingDialog = ProgressLoading.create(this)
    }

    abstract fun injectComponent()

    private fun initActivityInjection() {
        activityComponent = DaggerActivityComponent
                .builder()
                .appComponent((application as BaseApplication).appComponent)
                .activityModule(ActivityModule(this))
                .lifeCycleProviderModule(LifeCycleProviderModule(this))
                .build()

    }

    override fun showLoading() {
        mLoadingDialog.showLoading()
    }

    override fun hideLoading() {
        mLoadingDialog.hideLoading()
    }

    override fun onError(string: String) {
        toast(string)
    }

}