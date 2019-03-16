package com.madukubah.rumahaku.model.response

import com.google.gson.annotations.SerializedName
import com.madukubah.rumahaku.model.Ad

data class AdsResponse (
        @field:SerializedName("value")
        val Ads : List<Ad>
)