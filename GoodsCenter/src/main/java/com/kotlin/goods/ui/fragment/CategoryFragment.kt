package com.kotlin.goods.ui.fragment

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kennyc.view.MultiStateView
import com.kotlin.base.ui.adapter.BaseRecyclerViewAdapter
import com.kotlin.base.ui.fragment.BaseMvpFragment
import com.kotlin.goods.R
import com.kotlin.goods.data.protocol.Category
import com.kotlin.goods.injection.component.DaggerCategoryComponent
import com.kotlin.goods.injection.module.CategoryModule
import com.kotlin.goods.presenter.CategoryPresenter
import com.kotlin.goods.presenter.view.CategoryView
import com.kotlin.goods.ui.adapter.SecondCategoryAdapter
import com.kotlin.goods.ui.adapter.TopCategoryAdapter
import kotlinx.android.synthetic.main.fragment_category.*
import org.jetbrains.anko.support.v4.toast

/**
 * 商品分类界面
 * Created by TEDDY on 2018/3/12.
 */
class CategoryFragment : BaseMvpFragment<CategoryPresenter>(), CategoryView {
    lateinit var topCategoryAdapter: TopCategoryAdapter
    lateinit var secondCategoryAdapter: SecondCategoryAdapter
    override fun injectComponent() {
        DaggerCategoryComponent.builder()
                .activityComponent(activityComponent)
                .categoryModule(CategoryModule())
                .build()
                .inject(this)
        mPresenter.mView = this
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        loadData()
    }


    private fun initView() {
        mTopCategoryRv.layoutManager = LinearLayoutManager(context)
        topCategoryAdapter = TopCategoryAdapter(context!!)
        mTopCategoryRv.adapter = topCategoryAdapter
        topCategoryAdapter.setOnItemClickListener(object
            : BaseRecyclerViewAdapter.OnItemClickListener<Category> {
            override fun onItemClick(item: Category, position: Int) {
                for (category in topCategoryAdapter.dataList) {
                    category.isSelected = item.id == category.id
                }
                topCategoryAdapter.notifyDataSetChanged()
                loadData(item.id)
            }

        })




        mSecondCategoryRv.layoutManager = GridLayoutManager(context, 3)
        secondCategoryAdapter = SecondCategoryAdapter(context!!)
        mSecondCategoryRv.adapter = secondCategoryAdapter

        secondCategoryAdapter.setOnItemClickListener(object : BaseRecyclerViewAdapter.OnItemClickListener<Category> {
            override fun onItemClick(item: Category, position: Int) {
                toast("click")
            }

        })
    }

    private fun loadData(parentId: Int = 0) {
        mPresenter.getCategory(parentId)
    }

    override fun onGetCategoryResult(result: MutableList<Category>?) {
        result?.let {
            if (result[0].parentId == 0) {
                result[0].isSelected = true
                topCategoryAdapter.setData(result)
                mPresenter.getCategory(result[0].id)
            } else {
                secondCategoryAdapter.setData(result)
                mMultiStateView.viewState = MultiStateView.VIEW_STATE_CONTENT
            }
        }
    }
}