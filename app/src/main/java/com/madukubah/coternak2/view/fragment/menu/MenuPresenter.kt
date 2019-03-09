package com.madukubah.coternak2.view.fragment.menu

import com.madukubah.coternak2.model.response.CategoryResponse
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info

open class MenuPresenter
(
        val view : MenuView.MView
) : MenuView.Presenter, AnkoLogger
{
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