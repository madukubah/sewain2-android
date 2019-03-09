package com.madukubah.coternak2.view.item.category

import android.support.v7.widget.GridLayoutManager
import com.madukubah.coternak2.R
import com.madukubah.coternak2.config.GridItemDecoration
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.item_categories.view.*

class ItemCategories(private val groupAdapter: GroupAdapter<ViewHolder>) : Item() {

    override fun bind(viewHolder: ViewHolder, position: Int) {
        val dimenDp = viewHolder.itemView.context.resources.getDimensionPixelSize(R.dimen._2sdp)
        val column = 3

        viewHolder.itemView.rvProductCategory.apply {
            adapter = groupAdapter
            layoutManager = GridLayoutManager(viewHolder.itemView.context, column)
            addItemDecoration(GridItemDecoration(dimenDp, column))
        }
    }

    override fun getLayout(): Int = R.layout.item_categories
}