package com.madukubah.sewain2.view.fragment.search


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.madukubah.sewain2.R
import com.madukubah.sewain2.config.invisible
import com.madukubah.sewain2.config.visible
import com.madukubah.sewain2.view.activity.item.ItemPresenter
import com.madukubah.sewain2.view.activity.item.ItemPresenterAnko
import com.madukubah.sewain2.view.activity.item.ItemView
import kotlinx.android.synthetic.main.fragment_search.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.support.v4.onRefresh

class SearchFragment
    :
        Fragment(),
        ItemView.MView
{


    override fun setPresenter(presenter: ItemView.Presenter) {
        this.presenter = presenter as ItemPresenter
    }
    override fun statusMore(isEmpty: Boolean) {
        if( isEmpty )
            btn_load_more_cari.invisible()
        else
            btn_load_more_cari.visible()
    }

    override fun status(isEmpty: Boolean) {
        if( isEmpty )
            cari_empty.visible()
        else
            cari_empty.invisible()
    }
    override fun showLoading() {
        cari_progressBar.visible()
        swipeRefreshLayout_cari.isRefreshing = false
    }

    override fun hideLoading() {
        cari_progressBar.invisible()
    }



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val ctx = checkNotNull(  context )
        ctx.let {
            presenter  =  ItemPresenterAnko(this, it)
            presenter.start()
        }

        rv_cari_items.layoutManager = LinearLayoutManager(context)
        rv_cari_items.adapter = presenter.adapter
        rv_cari_items.isNestedScrollingEnabled = false

        var query = editTextCari.text.toString().trim()
        ( presenter as ItemPresenterAnko ).loadAnkoSearch( query )

        swipeRefreshLayout_cari.onRefresh {
            var query = editTextCari.text.toString().trim()
            ( presenter as ItemPresenterAnko ).loadAnkoSearch( query )
        }
        btn_load_more_cari.onClick {
            var query = editTextCari.text.toString().trim()
            ( presenter as ItemPresenterAnko ).loadMoreAnkoSearch( query )
        }
        buttonCari.onClick {
            var query = editTextCari.text.toString().trim()
            ( presenter as ItemPresenterAnko ).loadAnkoSearch( query )
        }
    }

    companion object {
        fun newInstance() : SearchFragment
        {
            val fragment = SearchFragment()
            return fragment
        }
    }

    lateinit var presenter : ItemPresenter
}
