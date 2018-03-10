package com.zhangflg.mykotlinmall.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.zhangflg.mykotlinmall.R
import com.zhangflg.mykotlinmall.ui.fragment.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mNavigationBar.checkMsgBadge(false)
        mNavigationBar.checkCartBadge(20)

        initView()

//        Observable.timer(2, TimeUnit.SECONDS)
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe({ mNavigationBar.checkMsgBadge(true) })
//
//
//        Observable.timer(2, TimeUnit.SECONDS)
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe({ mNavigationBar.checkCartBadge(0) })
    }

    private fun initView() {
        val manager = supportFragmentManager.beginTransaction()
        manager.replace(R.id.mContainer, HomeFragment())
        manager.commit()
    }
}
