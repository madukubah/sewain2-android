package com.madukubah.sewain2.view.activity.item

import android.content.Context
import com.madukubah.sewain2.adapter.ItemAdapter
import com.madukubah.sewain2.model.Item
import com.madukubah.sewain2.model.response.ItemResponse

open class ItemPresenter
(
        val view : ItemView.MView,
        val ctx : Context
) : ItemView.Presenter
{
    override fun loadMore(itemResponse: ItemResponse) {
        view.hideLoading()
        if( itemResponse.items.size <= 0 )
        {
            view.statusMore( true)
            return
        }

        items.addAll( itemResponse.items )
        adapter.notifyDataSetChanged()

        view.status( false )
        view.statusMore( false)
    }

    override fun loadItems(itemResponse: ItemResponse) {
        view.hideLoading()
        if( itemResponse.items.size<=0 )
        {
            view.status( true )
            view.statusMore( true)
            return
        }
        view.status( false )
        view.statusMore( false)
        items.addAll( itemResponse.items )
        adapter.notifyDataSetChanged()
    }

    override fun loadData() {
        view.showLoading()
        view.status( false )
        items.clear()
        adapter.notifyDataSetChanged()
    }

    override fun start() {

        adapter = ItemAdapter(ctx, items)
        adapter.notifyDataSetChanged()
    }
    internal lateinit var adapter  : ItemAdapter
    internal var items : MutableList<Item> = mutableListOf()
}