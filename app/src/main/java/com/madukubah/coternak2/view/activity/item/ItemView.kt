package com.madukubah.coternak2.view.activity.item

import com.madukubah.coternak2.config.base.BasePresenter
import com.madukubah.coternak2.config.base.BaseView
import com.madukubah.coternak2.model.response.ItemResponse

interface ItemView
{
    interface Presenter : BasePresenter
    {
        fun loadData()
        fun loadItems( itemResponse: ItemResponse)
        fun loadMore( itemResponse: ItemResponse)
    }

    interface MView : BaseView<Presenter>
    {
        fun status(isEmpty : Boolean)
        fun statusMore(isEmpty : Boolean)

    }
}