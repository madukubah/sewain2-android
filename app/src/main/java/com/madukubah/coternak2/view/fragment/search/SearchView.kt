package com.madukubah.coternak2.view.fragment.search

import com.madukubah.coternak2.config.base.BasePresenter
import com.madukubah.coternak2.config.base.BaseView
import com.madukubah.coternak2.model.response.ItemResponse

interface SearchView {
    interface Presenter : BasePresenter
    {
        fun loadData()
        fun loadPLace( itemResponse: ItemResponse)
    }

    interface MView : BaseView<Presenter>
    {

    }
}