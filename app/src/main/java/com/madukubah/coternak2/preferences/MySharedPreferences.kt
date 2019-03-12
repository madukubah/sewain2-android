package com.madukubah.coternak2.preferences

import android.annotation.SuppressLint
import android.content.Context
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info

class MySharedPreferences
(
        ctx : Context
): AnkoLogger
{
    val FILENAME = "USER"

    val IS_LOGIN = "IS_LOGIN"

    val USER_ID = "USER_ID"
    val USER_NAME = "USER_NAME"
    val USER_PASS = "USER_PASS"
    val USER_FULLNAME = "USER_FULLNAME"
    val USER_ADDRESS = "USER_ADDRESS"
    val USER_EMAIL = "USER_EMAIL"
    val USER_PHONE = "USER_PHONE"

    val preferences = ctx.getSharedPreferences(FILENAME, Context.MODE_PRIVATE)

    fun isLogin() = preferences.getBoolean( IS_LOGIN, false )
    @SuppressLint("CommitPrefEdits")
    fun setIsLogin( isLogin : Boolean )
    {
        val editor = preferences.edit()
        editor.putBoolean( IS_LOGIN, isLogin )
        editor.apply()
    }
    fun getUserPass() = preferences.getString( USER_PASS, "" )
    @SuppressLint("CommitPrefEdits")
    fun setUserPass(UserPass : String )
    {
        val editor = preferences.edit()
        editor.putString( USER_PASS, UserPass )
        editor.apply()
    }

    fun getUserId() = preferences.getLong( USER_ID, 0 )
    @SuppressLint("CommitPrefEdits")
    fun setUserId(id: Long?)
    {
        info { "id = " + id }
        val editor = preferences.edit()
        if (id != null) {
            editor.putLong( USER_ID, id)
            editor.apply()
        }

    }
    fun getUsername() = preferences.getString( USER_NAME, "" )
    @SuppressLint("CommitPrefEdits")
    fun setUsername(Username : String )
    {
        val editor = preferences.edit()
        editor.putString( USER_NAME, Username )
        editor.apply()
    }
    fun getUserFullname() = preferences.getString( USER_FULLNAME, "" )
    @SuppressLint("CommitPrefEdits")
    fun setUserFullname(Fullname: String )
    {
        val editor = preferences.edit()
        editor.putString( USER_FULLNAME, Fullname )
        editor.apply()
    }
    fun getUserAddress() = preferences.getString( USER_ADDRESS, "" )
    @SuppressLint("CommitPrefEdits")
    fun setUserAddress(Address : String )
    {
        val editor = preferences.edit()
        editor.putString( USER_ADDRESS, Address )
        editor.apply()
    }
    fun getUserEmail() = preferences.getString( USER_EMAIL, "" )
    @SuppressLint("CommitPrefEdits")
    fun setUserEmail(Email: String )
    {
        val editor = preferences.edit()
        editor.putString( USER_EMAIL, Email )
        editor.apply()
    }
    fun getUserPhone() = preferences.getString( USER_PHONE, "" )
    @SuppressLint("CommitPrefEdits")
    fun setUserPhone(Phone: String )
    {
        val editor = preferences.edit()
        editor.putString( USER_PHONE, Phone )
        editor.apply()
    }
}