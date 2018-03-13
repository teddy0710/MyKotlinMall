package com.kotlin.goods.ui.fragment

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.eightbitlab.rxbus.Bus
import com.kotlin.base.ext.onClick
import com.kotlin.base.ui.activity.BaseActivity
import com.kotlin.base.ui.fragment.BaseMvpFragment
import com.kotlin.base.utils.YuanFenConverter
import com.kotlin.base.widgets.BannerImageLoader
import com.kotlin.goods.R
import com.kotlin.goods.common.GoodsConstant
import com.kotlin.goods.data.protocol.Goods
import com.kotlin.goods.event.GoodsDetailImageEvent
import com.kotlin.goods.injection.component.DaggerGoodsComponent
import com.kotlin.goods.injection.module.GoodsModule
import com.kotlin.goods.presenter.GoodsDetailPresenter
import com.kotlin.goods.presenter.view.GoodsDetailView
import com.kotlin.goods.ui.activity.GoodsDetailActivity
import com.kotlin.goods.widget.GoodsSkuPopView
import com.youth.banner.BannerConfig
import com.youth.banner.Transformer
import kotlinx.android.synthetic.main.fragment_goods_detail_tab_one.*

/**
 * 商品详情Tab一
 * Created by TEDDY on 2018/3/12.
 */
class GoodsDetailTypeOneFragment : BaseMvpFragment<GoodsDetailPresenter>(), GoodsDetailView {

    private lateinit var mSukPop: GoodsSkuPopView
    override fun injectComponent() {
        DaggerGoodsComponent.builder()
                .activityComponent(activityComponent)
                .goodsModule(GoodsModule())
                .build().inject(this)
        mPresenter.mView = this
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_goods_detail_tab_one, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initSkuPop()
        loadData()
    }


    private fun initView() {
        mGoodsDetailBanner.setImageLoader(BannerImageLoader())
        mGoodsDetailBanner.setBannerAnimation(Transformer.Accordion)
        mGoodsDetailBanner.setDelayTime(2000)
        mGoodsDetailBanner.setIndicatorGravity(BannerConfig.RIGHT)
        mSkuView.onClick {
            mSukPop.showAtLocation((activity as GoodsDetailActivity).getRootView(),
                    Gravity.BOTTOM and Gravity.CENTER_HORIZONTAL,
                    0, 0)
        }
    }

    private fun initSkuPop() {
        mSukPop = activity?.let { GoodsSkuPopView(it) }!!

    }

    private fun loadData() {
        activity?.intent?.getIntExtra(GoodsConstant.KEY_GOODS_ID, -1)?.let { mPresenter.getGoodsDetail(it) }

    }

    override fun onGetGoodsDetailResult(result: Goods) {
        mGoodsDetailBanner.setImages(result.goodsBanner.split(","))
        mGoodsDetailBanner.start()

        mGoodsDescTv.text = result.goodsDesc
        mGoodsPriceTv.text = YuanFenConverter.changeF2YWithUnit(result.goodsDefaultPrice)
        mSkuSelectedTv.text = result.goodsDefaultSku
        Bus.send(GoodsDetailImageEvent(result.goodsDetailOne, result.goodsDetailTwo))

        loadPopData(result)
    }

    private fun loadPopData(result: Goods) {
        mSukPop.setGoodsIcon(result.goodsDefaultIcon)
        mSukPop.setGoodsCode(result.goodsCode)
        mSukPop.setGoodsPrice(result.goodsDefaultPrice)

    }


}