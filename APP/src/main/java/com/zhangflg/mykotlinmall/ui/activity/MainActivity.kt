package com.zhangflg.mykotlinmall.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.eightbitlab.rxbus.Bus
import com.eightbitlab.rxbus.registerInBus
import com.kotlin.base.ui.fragment.BaseFragment
import com.kotlin.base.utils.AppPrefsUtils
import com.kotlin.goods.common.GoodsConstant
import com.kotlin.goods.event.UpdateCartSizeEvent
import com.kotlin.goods.ui.fragment.CartFragment
import com.kotlin.goods.ui.fragment.CategoryFragment
import com.zhangflg.mykotlinmall.R
import com.zhangflg.mykotlinmall.ui.fragment.HomeFragment
import com.zhangflg.mykotlinmall.ui.fragment.MineFragment
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    private val mStack = Stack<BaseFragment>()
    private val mHomeFragment: HomeFragment by lazy { HomeFragment() }
    private val mCategoryFragmentFragment: CategoryFragment by lazy { CategoryFragment() }
    private val mCartFragment: CartFragment by lazy { CartFragment() }
    private val mMsgFragment: HomeFragment by lazy { HomeFragment() }
    private val mMineFragment: MineFragment by lazy { MineFragment() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initFragment()
        initBottomNav()
        changeFragment(0)
        initObserve()
        loadCartSize()

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

    private fun initObserve() {
        Bus.observe<UpdateCartSizeEvent>()
                .subscribe {
                    loadCartSize()
                }.registerInBus(this)

    }

    private fun loadCartSize() {
        //        mNavigationBar.checkMsgBadge(false)
        mNavigationBar.checkCartBadge(AppPrefsUtils.getInt(GoodsConstant.SP_CART_SIZE))

    }

    override fun onDestroy() {
        super.onDestroy()
        Bus.unregister(this)
    }
}
