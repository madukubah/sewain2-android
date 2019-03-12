package com.madukubah.rumahaku.view.activity.item

import com.madukubah.rumahaku.config.base.BasePresenter
import com.madukubah.rumahaku.config.base.BaseView
import com.madukubah.rumahaku.model.response.ItemResponse

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