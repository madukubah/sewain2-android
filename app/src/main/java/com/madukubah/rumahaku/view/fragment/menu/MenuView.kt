package com.madukubah.rumahaku.view.fragment.menu

import com.madukubah.rumahaku.config.base.BasePresenter
import com.madukubah.rumahaku.config.base.BaseView
import com.madukubah.rumahaku.model.Ad
import com.madukubah.rumahaku.model.BannerPromo
import com.madukubah.rumahaku.model.Category
import com.madukubah.rumahaku.model.response.AdsResponse
import com.madukubah.rumahaku.model.response.CategoryResponse

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