package com.arafat1419.mealzapp.model

import com.arafat1419.mealzapp.model.api.MealsWebService
import com.arafat1419.mealzapp.model.response.MealsCategoriesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MealsRepository(private val webService: MealsWebService = MealsWebService()) {
    suspend fun getMeals() : MealsCategoriesResponse =
        webService.getMeals()
}