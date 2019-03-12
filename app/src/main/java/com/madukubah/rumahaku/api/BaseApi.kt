package com.madukubah.rumahaku.api

import com.madukubah.rumahaku.BuildConfig
import java.net.URL

object BaseApi {
    private const val search :String = "item/search/"
    private const val category_tree :String = "category/category_tree"
    private const val sub_category :String = "category/sub_category/"
    private const val items_by_category :String = "item/items/"

    fun doRequest(url: String): String {
        return URL(url).readText()
    }
    fun seachItem( query :String , start : Int) : String
    {
        return BuildConfig.END_POINT + search + ""+query + "/?start=" + start
    }
    fun getSubCategory(categoryId: Long) : String
    {
        return BuildConfig.END_POINT + sub_category + ""+categoryId
    }
    fun getItemByCategoryId(categoryId: Long , start : Int) : String
    {
        return BuildConfig.END_POINT + items_by_category + ""+categoryId + "/?start="+ start
    }
}