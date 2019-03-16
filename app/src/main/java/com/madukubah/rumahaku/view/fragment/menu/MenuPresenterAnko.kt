package com.madukubah.rumahaku.view.fragment.menu

import com.madukubah.rumahaku.api.BaseApi
import com.madukubah.rumahaku.config.Config
import com.madukubah.rumahaku.model.response.AdsResponse
import com.madukubah.rumahaku.model.response.CategoryResponse
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.coroutines.experimental.bg
import org.jetbrains.anko.info

class MenuPresenterAnko
(
        view : MenuView.MView
): MenuPresenter( view ), AnkoLogger
{
    override fun loadData()
    {
        super.loadData()
        val req = BaseApi.getSubCategory( 0 )
        info { "req = "+ req }
        async(UI)
        {
            val data = bg {
                Config.gson.fromJson(
                        BaseApi.doRequest( req ),
                        CategoryResponse::class.java
                )
            }
            data.await()
            loadCategory( data.getCompleted() )
            info { "selesai" }
        }
    }
    fun getAds()
    {
        val req = BaseApi.getAds(  )
        info { "req = "+ req }
        async(UI)
        {
            val data = bg {
                Config.gson.fromJson(
                        BaseApi.doRequest( req ),
                        AdsResponse::class.java
                )
            }
            data.await()
            loadAds( data.getCompleted() )
            info { "selesai" }
        }
    }
}