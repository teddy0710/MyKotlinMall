package com.kotlin.goods.ui.adapter

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.kotlin.goods.ui.fragment.GoodsDetailTypeOneFragment
import com.kotlin.goods.ui.fragment.GoodsDetailTypeTwoFragment

/**
 * 商品详情页滑动翻页ViewPager adapter
 * Created by ZFL on 2018/3/13
 */
class GoodsDetailVpAdapter(fm: FragmentManager, context: Context) : FragmentPagerAdapter(fm) {
    private val titles = arrayOf("商品", "详情")
    override fun getItem(position: Int): Fragment {
        return if (position == 0) {
            GoodsDetailTypeOneFragment()
        } else {
            GoodsDetailTypeTwoFragment()
        }

    }

    override fun getCount(): Int {
        return titles.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titles[position]
    }
}