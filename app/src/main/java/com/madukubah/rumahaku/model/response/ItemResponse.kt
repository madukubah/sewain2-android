package com.madukubah.rumahaku.model.response

import com.google.gson.annotations.SerializedName
import com.madukubah.rumahaku.model.Item

data class ItemResponse(
        @field:SerializedName("data")
        val items : List<Item>
)