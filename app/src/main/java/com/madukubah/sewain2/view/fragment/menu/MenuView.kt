package com.madukubah.sewain2.view.fragment.menu

import com.madukubah.sewain2.config.base.BasePresenter
import com.madukubah.sewain2.config.base.BaseView
import com.madukubah.sewain2.model.Ad
import com.madukubah.sewain2.model.BannerPromo
import com.madukubah.sewain2.model.Category
import com.madukubah.sewain2.model.response.AdsResponse
import com.madukubah.sewain2.model.response.CategoryResponse

interface MenuView {
    interface Presenter : BasePresenter
    {
        fun loadData()
        fun loadCategory( response : CategoryResponse)
        fun loadAds( response : AdsResponse)
    }

    interface MView : BaseView<Presenter>
    {
        fun onLoadCategory( response : List<Category>)
        fun onLoadAds( banners : List<Ad>)
        fun status(isEmpty : Boolean)
    }
}