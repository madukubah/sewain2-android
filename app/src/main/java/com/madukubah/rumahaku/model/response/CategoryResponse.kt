package com.madukubah.rumahaku.model.response

import com.google.gson.annotations.SerializedName
import com.madukubah.rumahaku.model.Category


data class CategoryResponse (
        @field:SerializedName("data")
        val categories : List<Category>
)