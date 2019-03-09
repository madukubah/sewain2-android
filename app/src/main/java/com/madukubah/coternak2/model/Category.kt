package com.madukubah.coternak2.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Category (
        @SerializedName("category_relation_id") val category_relation_id : Long,
        @SerializedName("category_relation_parent") val category_relation_parent : Long,
        @SerializedName("category_relation_child") val category_relation_child : Long,
        @SerializedName("category_id") val category_id : Long,
        @SerializedName("category_name") val category_name : String,
        @SerializedName("category_description") val category_description : String,
        @SerializedName("child") val child : Long
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readLong(),
            parcel.readLong(),
            parcel.readLong(),
            parcel.readLong(),
            parcel.readString(),
            parcel.readString(),
            parcel.readLong()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(category_relation_id)
        parcel.writeLong(category_relation_parent)
        parcel.writeLong(category_relation_child)
        parcel.writeLong(category_id)
        parcel.writeString(category_name)
        parcel.writeString(category_description)
        parcel.writeLong(child)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Category> {
        override fun createFromParcel(parcel: Parcel): Category {
            return Category(parcel)
        }

        override fun newArray(size: Int): Array<Category?> {
            return arrayOfNulls(size)
        }
    }
}