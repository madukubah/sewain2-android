package com.madukubah.sewain2.config.base

interface BaseView<T>
{
    fun setPresenter( presenter : T )
    fun showLoading()
    fun hideLoading()
}