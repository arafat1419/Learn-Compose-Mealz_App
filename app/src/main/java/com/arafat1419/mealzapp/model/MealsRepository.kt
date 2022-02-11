package com.arafat1419.mealzapp.model

import com.arafat1419.mealzapp.model.api.MealsWebService
import com.arafat1419.mealzapp.model.response.MealResponse
import com.arafat1419.mealzapp.model.response.MealsCategoriesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MealsRepository(private val webService: MealsWebService = MealsWebService()) {
    private var chacedMeals = listOf<MealResponse>()
    suspend fun getMeals() : MealsCategoriesResponse {
        val response = webService.getMeals()
        chacedMeals = response.categories
        return response
    }


    fun getMeal(id: String): MealResponse? {
        return chacedMeals.firstOrNull {
            it.id == id
        }
    }

    companion object {
        @Volatile
        private var instance: MealsRepository? = null
        fun getInstance() = instance?: synchronized(this) {
            instance ?: MealsRepository().also { instance = it }
        }
    }
}