package com.madukubah.rumahaku.view.fragment.search

import com.madukubah.rumahaku.config.base.BasePresenter
import com.madukubah.rumahaku.config.base.BaseView
import com.madukubah.rumahaku.model.response.ItemResponse

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