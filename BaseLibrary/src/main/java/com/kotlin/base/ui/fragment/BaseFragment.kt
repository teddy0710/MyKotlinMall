package com.kotlin.base.ui.fragment

import com.trello.rxlifecycle.components.support.RxFragment

/**
 * 用RxLifeCycle 解决rx的内存泄漏问题
 * 所有activity都继承自BaseActivity
 * 为不需要mvp的activity提供的BaseActivity
 * Created by ZFL on 2018/3/5
 */
open class BaseFragment : RxFragment() {
}