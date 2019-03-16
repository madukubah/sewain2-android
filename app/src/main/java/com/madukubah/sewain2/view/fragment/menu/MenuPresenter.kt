package com.madukubah.sewain2.view.fragment.menu

import com.madukubah.sewain2.model.response.AdsResponse
import com.madukubah.sewain2.model.response.CategoryResponse
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info

open class MenuPresenter
(
        val view : MenuView.MView
) : MenuView.Presenter, AnkoLogger
{
    override fun loadAds(response: AdsResponse) {
        if( response.Ads.size <=0 )
        {
            return
        }
        view.onLoadAds( response.Ads )
    }

    override fun loadData() {
        view.showLoading()
        view.status( false )
    }

    override fun loadCategory(response: CategoryResponse) {
        view.hideLoading()
        info { "response = "+ response }
        if( response.categories.size <=0 )
        {
            view.status( true )
            return
        }
        view.status( false )
        view.onLoadCategory( response.categories)
    }

    override fun start() {

    }
}