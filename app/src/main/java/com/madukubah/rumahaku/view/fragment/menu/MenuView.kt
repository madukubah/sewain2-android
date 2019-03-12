package com.madukubah.rumahaku.view.fragment.menu

import com.madukubah.rumahaku.config.base.BasePresenter
import com.madukubah.rumahaku.config.base.BaseView
import com.madukubah.rumahaku.model.Category
import com.madukubah.rumahaku.model.response.CategoryResponse

interface MenuView {
    interface Presenter : BasePresenter
    {
        fun loadData()
        fun loadCategory( response : CategoryResponse)
    }

    interface MView : BaseView<Presenter>
    {
        fun onLoadCategory( response : List<Category>)
        fun status(isEmpty : Boolean)
    }
}