package com.madukubah.coternak2.view.activity.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.view.MenuItem
import com.madukubah.coternak2.R
import com.madukubah.coternak2.view.fragment.search.SearchFragment
import com.madukubah.coternak2.view.fragment.menu.MenuFragment
import com.madukubah.coternak2.view.fragment.profile.ProfileFragment
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info

class MainActivity
    :
        AppCompatActivity(),
        BottomNavigationView.OnNavigationItemSelectedListener,
        AnkoLogger
{
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        info("nav id : " + item.itemId)
        val manager = supportFragmentManager.beginTransaction()
        var fragment : Fragment?= null
        val id = item.itemId
        when(id){
            R.id.navigation_menu->{
                fragment = MenuFragment.newInstance()
            }
            R.id.navigation_cari->{
                fragment = SearchFragment.newInstance()
            }
            R.id.navigation_profile ->{
                fragment = ProfileFragment.newInstance()
            }
        }
        val ft = supportFragmentManager.beginTransaction()
        ft.replace( R.id.frame, fragment )
        ft.commit()
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(this)

        if( savedInstanceState == null )
            navigation.selectedItemId = R.id.navigation_menu
    }
}
