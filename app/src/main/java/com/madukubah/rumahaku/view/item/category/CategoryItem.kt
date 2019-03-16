package com.madukubah.rumahaku.view.item.category

import android.content.Context
import android.graphics.ColorFilter
import android.support.v4.content.ContextCompat
import com.madukubah.rumahaku.R
import com.madukubah.rumahaku.model.Category
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.item_category.view.*


interface CategoryListener {
    fun onCategoryClicked(category: Category)
}

class CategoryItem(private val category: Category,
                   private val ctx: Context?,
                   private val listener: CategoryListener) : Item() {

    override fun bind(viewHolder: ViewHolder, position: Int) {
        val icons = listOf(
                R.drawable.rumah
        )

        viewHolder.itemView.productName.text = category.category_name.toLowerCase().capitalize()
        viewHolder.itemView.productImage.setImageDrawable(
                ctx?.let {
                    ContextCompat.getDrawable(
                            it, // Context
                            icons[ position % icons.size ] // Drawable
                    )
                }
        )
        ctx?.let {
            viewHolder.itemView.productImage.setColorFilter(
                ContextCompat.getColor(
                        it,
                        R.color.colorPrimary
                )
            )
        }
        viewHolder.itemView.setOnClickListener {
            listener.onCategoryClicked(category)
        }
    }
    override fun getLayout(): Int = R.layout.item_category
}