package com.madukubah.coternak2.model.response

import com.google.gson.annotations.SerializedName
import com.madukubah.coternak2.model.Item

data class ItemResponse(
        @field:SerializedName("data")
        val items : List<Item>
)