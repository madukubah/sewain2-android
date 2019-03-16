package com.madukubah.sewain2.view.item.banner

import android.support.v4.app.FragmentManager
import com.madukubah.sewain2.R
import com.madukubah.sewain2.model.Ad
import com.madukubah.sewain2.model.BannerPromo
import com.madukubah.sewain2.view.item.banner.adapter.BannerAdapter

import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.item_carousel_banner.view.*

interface BannerListener {
    fun onSeeAllPromoClick(  )
    fun onBannerClick(promo: Ad)
}

class BannerCarouselItem(private val banners: List<Ad>,
                         private val supportFragmentManager: FragmentManager?,
                         private val listener: BannerListener) : Item() {

    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewPagerAdapter = supportFragmentManager?.let { BannerAdapter(it) }!!
        banners.map {
            viewPagerAdapter?.addFragment( BannerFragment.newInstance(it.advertise_photo) )
        }
        viewHolder.itemView.viewPagerBanner.adapter = viewPagerAdapter
        viewHolder.itemView.indicator.setViewPager(viewHolder.itemView.viewPagerBanner)

        viewHolder.itemView.btnSemuaPromo.setOnClickListener {
            listener.onSeeAllPromoClick()
        }
    }

    fun updatePromos( banners: List<Ad> ){
        banners.map {
            viewPagerAdapter?.addFragment( BannerFragment.newInstance(it.advertise_photo) )
        }
        viewPagerAdapter?.notifyDataSetChanged()
    }
    override fun getLayout(): Int = R.layout.item_carousel_banner
    lateinit var viewPagerAdapter : BannerAdapter
}