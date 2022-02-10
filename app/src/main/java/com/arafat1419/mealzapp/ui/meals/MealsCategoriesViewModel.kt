package com.arafat1419.mealzapp.ui.meals

import androidx.lifecycle.ViewModel
import com.arafat1419.mealzapp.model.MealsRepository
import com.arafat1419.mealzapp.model.response.MealsCategoriesResponse

class MealsCategoriesViewModel(private val mealsRepository: MealsRepository = MealsRepository()) : ViewModel() {
    fun getMeals(successCallback: (response: MealsCategoriesResponse?) -> Unit) {
        mealsRepository.getMeals { response ->
            successCallback(response)
        }
    }
}