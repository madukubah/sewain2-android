package com.madukubah.sewain2.view.fragment.search

import android.support.v4.app.Fragment
import com.madukubah.sewain2.adapter.ItemAdapter
import com.madukubah.sewain2.model.Item
import com.madukubah.sewain2.model.response.ItemResponse

class SearchPresenter
(
        val view : SearchView.MView
): SearchView.Presenter
{
    override fun loadPLace(itemResponse: ItemResponse) {

    }

    override fun loadData() {

    }

    override fun start() {
//        items = listOf(
//                Item(1, "Sapi Super", 15000000, "ini deskripsi" ),
//                Item(1, "Sapi Super", 15000000, "ini deskripsi" ),
//                Item(1, "Sapi Super", 15000000, "ini deskripsi" ),
//                Item(1, "Sapi Super", 15000000, "ini deskripsi" ),
//                Item(1, "Sapi Super", 15000000, "ini deskripsi" )
//
//        ).toMutableList()

        val ctx = checkNotNull((view as Fragment).context)
        adapter = ItemAdapter( ctx  , items)
        adapter.notifyDataSetChanged()
    }
    internal lateinit var adapter  : ItemAdapter
    internal var items : MutableList<Item> = mutableListOf()
}