package com.madukubah.sewain2.model.response

import com.google.gson.annotations.SerializedName
import com.madukubah.sewain2.model.Category


data class CategoryResponse (
        @field:SerializedName("data")
        val categories : List<Category>
)