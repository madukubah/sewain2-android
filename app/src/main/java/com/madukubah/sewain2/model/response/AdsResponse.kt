package com.madukubah.sewain2.model.response

import com.google.gson.annotations.SerializedName
import com.madukubah.sewain2.model.Ad

data class AdsResponse (
        @field:SerializedName("value")
        val Ads : List<Ad>
)