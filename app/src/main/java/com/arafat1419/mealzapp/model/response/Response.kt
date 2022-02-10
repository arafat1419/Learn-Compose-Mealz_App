package com.arafat1419.mealzapp.model.response

import com.google.gson.annotations.SerializedName

data class MealsCategoriesResponse(

    @field:SerializedName("categories")
    val categories: List<MealResponse>
)

data class MealResponse(
    @field:SerializedName("idCategory")
    val id: String,

    @field:SerializedName("strCategory")
    val name: String,

    @field:SerializedName("strCategoryDescription")
    val description: String,

    @field:SerializedName("strCategoryThumb")
    val imageUrl: String
)
