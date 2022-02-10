package com.arafat1419.mealzapp.ui.meals

import android.util.Log
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arafat1419.mealzapp.model.MealsRepository
import com.arafat1419.mealzapp.model.response.MealResponse
import com.arafat1419.mealzapp.model.response.MealsCategoriesResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MealsCategoriesViewModel(private val mealsRepository: MealsRepository = MealsRepository()) : ViewModel() {

//    private val mealsJob = Job()

    init {
        Log.d("Lihat Coroutines", "launch a coroutine") // 1
//        val scope = CoroutineScope(mealsJob + IO)
        viewModelScope.launch(IO) {
            Log.d("Lihat Coroutines", "launched a coroutine") // 3
            val meals = getMeals()
            Log.d("Lihat Coroutines", "received async data") // 4
            mealsState.value = meals
        }
        Log.d("Lihat Coroutines", "other work") //
    }

    val mealsState: MutableState<List<MealResponse>> = mutableStateOf(emptyList<MealResponse>())

    /*override fun onCleared() {
        super.onCleared()
        mealsJob.cancel()
    }*/

    private suspend fun getMeals() : List<MealResponse> = mealsRepository.getMeals().categories
}