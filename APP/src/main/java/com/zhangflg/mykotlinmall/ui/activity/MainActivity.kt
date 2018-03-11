package com.zhangflg.mykotlinmall.ui.activity

import android.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.kotlin.base.ui.fragment.BaseFragment
import com.kotlin.goods.ui.fragment.CategoryFragment
import com.zhangflg.mykotlinmall.R
import com.zhangflg.mykotlinmall.ui.fragment.HomeFragment
import com.zhangflg.mykotlinmall.ui.fragment.MineFragment
import kotlinx.android.synthetic.main.activity_main.*
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import java.util.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    private val mStack = Stack<BaseFragment>()
    private val mHomeFragment: HomeFragment by lazy { HomeFragment() }
    private val mCategoryFragmentFragment: CategoryFragment by lazy { CategoryFragment() }
    private val mCartFragment: HomeFragment by lazy { HomeFragment() }
    private val mMsgFragment: HomeFragment by lazy { HomeFragment() }
    private val mMineFragment: MineFragment by lazy { MineFragment() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mNavigationBar.checkMsgBadge(false)
        mNavigationBar.checkCartBadge(20)

//        initView()
        initFragment()
        initBottomNav()
        changeFragment(0)
    }

    private fun initView() {
        val manager = supportFragmentManager.beginTransaction()
        manager.replace(R.id.mContainer, HomeFragment())
        manager.commit()
    }

    private fun initFragment() {
        val manager = supportFragmentManager.beginTransaction()
        manager.add(R.id.mContainer, mHomeFragment)
        manager.add(R.id.mContainer, mCategoryFragmentFragment)
        manager.add(R.id.mContainer, mCartFragment)
        manager.add(R.id.mContainer, mMsgFragment)
        manager.add(R.id.mContainer, mMineFragment)
        manager.commit()

        mStack.add(mHomeFragment)
        mStack.add(mCategoryFragmentFragment)
        mStack.add(mCartFragment)
        mStack.add(mMsgFragment)
        mStack.add(mMineFragment)
    }

    private fun initBottomNav() {
        mNavigationBar.setTabSelectedListener(object : BottomNavigationBar.OnTabSelectedListener {
            override fun onTabReselected(position: Int) {
            }

            override fun onTabUnselected(position: Int) {
            }

            override fun onTabSelected(position: Int) {
                changeFragment(position)
            }

        })
    }

    private fun changeFragment(position: Int) {
        val manager = supportFragmentManager.beginTransaction()
        for (fragment in mStack) {
            manager.hide(fragment)
        }
        manager.show(mStack[position])
        manager.commit()
    }
}
