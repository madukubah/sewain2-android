package com.madukubah.rumahaku.view.fragment.profile


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.madukubah.rumahaku.R
import com.madukubah.rumahaku.config.invisible
import com.madukubah.rumahaku.config.visible
import com.madukubah.rumahaku.preferences.MySharedPreferences
import kotlinx.android.synthetic.main.fragment_profile.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class ProfileFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val ctx = checkNotNull(  context )
        ctx.let {
            val mySharedPreferences = MySharedPreferences(it )

            if( mySharedPreferences.isLogin() ){
                login.visible()
                not_login.invisible()
            }
        }


    }
    companion object {
        fun newInstance() : ProfileFragment
        {
            val fragment = ProfileFragment()
            return fragment
        }
    }

}
