package com.madukubah.sewain2.view.fragment.menu


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.madukubah.sewain2.R
import com.madukubah.sewain2.config.invisible
import com.madukubah.sewain2.config.visible
import com.madukubah.sewain2.model.Ad
import com.madukubah.sewain2.model.BannerPromo
import com.madukubah.sewain2.model.Category
import com.madukubah.sewain2.view.activity.item.ItemActivity
import com.madukubah.sewain2.view.item.banner.BannerCarouselItem
import com.madukubah.sewain2.view.item.banner.BannerListener
import com.madukubah.sewain2.view.item.category.CategoryItem
import com.madukubah.sewain2.view.item.category.CategoryListener
import com.madukubah.sewain2.view.item.category.ItemCategories
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.fragment_menu.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.jetbrains.anko.support.v4.startActivity

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class MenuFragment
    :
        Fragment(),
        BannerListener,
        CategoryListener,
        AnkoLogger,
        MenuView.MView
{
    override fun onLoadAds(banners: List<Ad>) {
        info{"banners = "+ banners }
        bannerCarouselItem.updatePromos( banners )
    }

    override fun onLoadCategory(response: List<Category>) {
        if( response.size >0  ){
            Section().apply {
                add( makeCategories( response ) )
                groupAdapter.add(this)
                val a = groupAdapter.getItem(0)

                info{"aa = "+ a }
            }
        }
    }

    override fun status(isEmpty: Boolean) {
        if( isEmpty )
            menu_empty.visible()
        else
            menu_empty.invisible()
    }

    override fun setPresenter(presenter: MenuView.Presenter) {
        this.presenter = presenter as MenuPresenter
    }

    override fun showLoading() {
        menu_progressBar.visible()
    }

    override fun hideLoading() {
        menu_progressBar.invisible()
    }

    override fun onSeeAllPromoClick() {

    }

    override fun onBannerClick(promo: Ad) {

    }

    override fun onCategoryClicked(category: Category) {
        startActivity<ItemActivity>(
                ItemActivity.CATEGORY to category
        )
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        info { "CREATE" }
        rvMain.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = groupAdapter
        }

        groupAdapter.clear()
        val promos :MutableList<Ad> = mutableListOf()

        val fm = getFragmentManager()
        bannerCarouselItem = BannerCarouselItem(promos, fm, this)
        groupAdapter.add(bannerCarouselItem)

        presenter = MenuPresenterAnko(this)
        ( presenter as MenuPresenterAnko ).loadData()
        ( presenter as MenuPresenterAnko ).getAds()
    }

    private fun makeCategories( categories : List<Category> ) : ItemCategories
    {

        val categoryAdapter = GroupAdapter<ViewHolder>()
        val ctx = context
        categories.map {
            categoryAdapter.add( CategoryItem( it, ctx , this  ) )
        }
        return ItemCategories( categoryAdapter )
    }

    companion object {
        fun newInstance() : MenuFragment
        {
            val fragment = MenuFragment()
            return fragment
        }
    }

    private var groupAdapter = GroupAdapter<ViewHolder>()
    lateinit var presenter: MenuPresenter
    lateinit var bannerCarouselItem : BannerCarouselItem
}
