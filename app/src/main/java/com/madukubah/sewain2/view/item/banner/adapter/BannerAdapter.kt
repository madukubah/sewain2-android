package com.madukubah.sewain2.view.item.banner.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.app.FragmentStatePagerAdapter
import com.madukubah.sewain2.model.BannerPromo
import com.madukubah.sewain2.view.item.banner.BannerFragment


class BannerAdapter(
        fragmentManager: FragmentManager
)
    : FragmentStatePagerAdapter(fragmentManager)
{
    private  val fragments = ArrayList<Fragment>()
    override fun getItem(pos: Int): Fragment {
        return fragments[pos]
    }
    override fun getCount(): Int = fragments.size
    fun addFragment( fragment: Fragment )
    {
        fragments.add( fragment )
    }
}