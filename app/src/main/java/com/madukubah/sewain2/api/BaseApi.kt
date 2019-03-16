package com.madukubah.sewain2.api

import com.madukubah.sewain2.BuildConfig
import java.net.URL

object BaseApi {
    private const val search :String = "item/search/"
    private const val category_tree :String = "category/category_tree"
    private const val sub_category :String = "category/sub_category/"
    private const val items_by_category :String = "item/items/"
    private const val MobileADS :String = "ads/"

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
    fun getAds( ) : String
    {
        return BuildConfig.END_POINT + MobileADS + "get_ads"
    }
}