package com.madukubah.rumahaku.config.base

interface BaseView<T>
{
    fun setPresenter( presenter : T )
    fun showLoading()
    fun hideLoading()
}