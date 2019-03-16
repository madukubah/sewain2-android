package com.madukubah.sewain2.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Item (
        @SerializedName("item_id") val item_id : Long,
        @SerializedName("item_name") val item_name : String,
        @SerializedName("item_price") val item_price : Long,
        @SerializedName("item_description") val item_description : String,
        @SerializedName("item_images") val item_images : String,
        @SerializedName("item_author") val item_author : String,
        @SerializedName("item_release_date") val item_release_date : String,
        @SerializedName("item_ISBN") val item_ISBN : String,
        @SerializedName("item_language") val item_language : String,
        @SerializedName("item_penerbit") val item_penerbit : String,
        @SerializedName("item_page_count") val item_page_count : String,

        @SerializedName("user_profile_fullname") val user_profile_fullname : String,
        @SerializedName("user_profile_image_path") val user_profile_image_path : String,
        @SerializedName("user_profile_phone") val user_profile_phone : String,

        @SerializedName("category_id") val category_id : Long,
        @SerializedName("category_name") val category_name : String,
        @SerializedName("create_date") val create_date : String
):Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readLong(),
            parcel.readString(),
            parcel.readLong(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readLong(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(item_id)
        parcel.writeString(item_name)
        parcel.writeLong(item_price)
        parcel.writeString(item_description)
        parcel.writeString(item_images)
        parcel.writeString(item_author)
        parcel.writeString(item_release_date)
        parcel.writeString(item_ISBN)
        parcel.writeString(item_language)
        parcel.writeString(item_penerbit)
        parcel.writeString(item_page_count)
        parcel.writeString(user_profile_fullname)
        parcel.writeString(user_profile_image_path)
        parcel.writeString(user_profile_phone)
        parcel.writeLong(category_id)
        parcel.writeString(category_name)
        parcel.writeString(create_date)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Item> {
        override fun createFromParcel(parcel: Parcel): Item {
            return Item(parcel)
        }

        override fun newArray(size: Int): Array<Item?> {
            return arrayOfNulls(size)
        }
    }
}