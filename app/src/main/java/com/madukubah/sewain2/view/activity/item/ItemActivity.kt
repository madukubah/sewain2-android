package com.madukubah.sewain2.view.activity.item

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.madukubah.sewain2.R
import com.madukubah.sewain2.config.invisible
import com.madukubah.sewain2.config.visible
import com.madukubah.sewain2.model.Category
import kotlinx.android.synthetic.main.activity_item.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.support.v4.onRefresh

class ItemActivity
    :
        AppCompatActivity(),
        ItemView.MView ,
        AnkoLogger
{
    override fun statusMore(isEmpty: Boolean) {
        if( isEmpty )
            btn_load_more.invisible()
        else
            btn_load_more.visible()
    }

    override fun status(isEmpty: Boolean) {
        if( isEmpty )
            item_empty.visible()
        else
            item_empty.invisible()
    }

    override fun setPresenter(presenter: ItemView.Presenter) {
        this.presenter = presenter as ItemPresenter
    }

    override fun showLoading() {
        item_progressBar.visible()
        swipeRefreshLayout_places.isRefreshing = false
    }

    override fun hideLoading() {
        item_progressBar.invisible()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)

        presenter = ItemPresenterAnko(this, this)
        presenter.start()

        rv_items.layoutManager = LinearLayoutManager(this)
        rv_items.adapter = presenter.adapter
        rv_items.isNestedScrollingEnabled = false

        category = intent.getParcelableExtra( CATEGORY )
        if( category != null )
        {
            ( presenter as ItemPresenterAnko ).loadDataAnko( category.category_id )
        }

        swipeRefreshLayout_places.onRefresh {
            ( presenter as ItemPresenterAnko ).loadDataAnko( category.category_id )
        }
        btn_load_more.onClick {
            ( presenter as ItemPresenterAnko ).loadMoreAnko( category.category_id )
        }
    }

    companion object {
        const val CATEGORY = "CATEGORY"
    }

    lateinit var presenter : ItemPresenter
    internal lateinit var category : Category
}
