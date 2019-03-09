package com.madukubah.coternak2.view.activity.item

import android.content.Context
import com.madukubah.coternak2.api.BaseApi
import com.madukubah.coternak2.config.Config
import com.madukubah.coternak2.model.response.ItemResponse
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.coroutines.experimental.bg
import org.jetbrains.anko.info

class ItemPresenterAnko
(
        view : ItemView.MView,
        ctx : Context
) : ItemPresenter( view,ctx  ) , AnkoLogger
{
    fun loadDataAnko( categoryPlaceId : Long )
    {
        super.loadData()
        val req = BaseApi.getItemByCategoryId( categoryPlaceId, items.size )
        info { "req = "+ req }
        async(UI)
        {
            val data = bg {
                Config.gson.fromJson(
                        BaseApi.doRequest( req ),
                        ItemResponse::class.java
                )
            }
            data.await()
            loadItems( data.getCompleted() )
        }
    }
    fun loadMoreAnko( categoryPlaceId : Long )
    {
        view.status(false)
        view.showLoading()
        val req = BaseApi.getItemByCategoryId( categoryPlaceId, items.size )
        info { "req = "+ req }
        async(UI)
        {
            val data = bg {
                Config.gson.fromJson(
                        BaseApi.doRequest( req ),
                        ItemResponse::class.java
                )
            }
            data.await()
            loadMore( data.getCompleted() )
        }
    }

    fun loadAnkoSearch(  query : String)
    {
        super.loadData()
        val _query = query.replace(" ","%20")
        val req = BaseApi.seachItem( _query , items.size )
        info { "req = "+ req }
        async(UI)
        {
            val data = bg {
                Config.gson.fromJson(
                        BaseApi.doRequest( req ),
                        ItemResponse::class.java
                )
            }
            data.await()
            loadItems( data.getCompleted() )
        }
    }
    fun loadMoreAnkoSearch(  query : String)
    {
        view.status(false)
        view.showLoading()
        val _query = query.replace(" ","%20")
        val req = BaseApi.seachItem( _query , items.size )
        info { "req = "+ req }
        async(UI)
        {
            val data = bg {
                Config.gson.fromJson(
                        BaseApi.doRequest( req ),
                        ItemResponse::class.java
                )
            }
            data.await()
            loadMore( data.getCompleted() )
        }
    }
}