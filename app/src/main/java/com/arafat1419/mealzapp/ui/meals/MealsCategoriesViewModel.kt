package com.arafat1419.mealzapp.ui.meals

import androidx.lifecycle.ViewModel
import com.arafat1419.mealzapp.model.MealsRepository
import com.arafat1419.mealzapp.model.response.MealResponse
import com.arafat1419.mealzapp.model.response.MealsCategoriesResponse

class MealsCategoriesViewModel(private val mealsRepository: MealsRepository = MealsRepository()) : ViewModel() {
    suspend fun getMeals() : List<MealResponse> = mealsRepository.getMeals().categories
}