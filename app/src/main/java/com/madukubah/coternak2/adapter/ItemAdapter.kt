package com.madukubah.coternak2.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.madukubah.coternak2.BuildConfig
import com.madukubah.coternak2.R
import com.madukubah.coternak2.config.Config
import com.madukubah.coternak2.model.Item
import com.madukubah.coternak2.view.activity.detail.DetailItemActivity
import com.madukubah.coternak2.view.activity.detail.DetailItemActivity.Companion.ITEM
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_cardview_item.view.*
import kotlinx.android.synthetic.main.item_list_item.view.*
import org.jetbrains.anko.startActivity

class ItemAdapter
(
        private val context: Context,
        private val items: List<Item>
) : RecyclerView.Adapter<ItemAdapter.ViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = ViewHolder( LayoutInflater.from(context).inflate(R.layout.item_cardview_item, parent, false) )

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem( items[ position ] )
    }

    class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {
        fun bindItem(item: Item ) {
            containerView.item_name.text = item.item_name
            containerView.item_price.text = "Rp. "+Config.priceFormat( ""+item.item_price )
            containerView.item_desc.text = item.item_description


            val ctx = containerView.context
            val images = item.item_images.split(";")

            Glide.with(containerView).load(BuildConfig.ITEM_IMAGE + images[0] ).into(containerView.img_item_photo)
            containerView.setOnClickListener {
                ctx.let {
                    it.startActivity<DetailItemActivity>(
                            DetailItemActivity.ITEM to item
                    )
                }
            }
        }
    }
}