package com.arafat1419.mealzapp.ui.meals

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.arafat1419.mealzapp.model.response.MealResponse
import com.arafat1419.mealzapp.ui.theme.MealzAppTheme
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MealzAppTheme {
                MealsCategoriesScreen()
            }
        }
    }
}

@Composable
fun MealsCategoriesScreen() {
    val viewModel: MealsCategoriesViewModel = viewModel()
    val rememberMeals = remember {
        mutableStateOf(emptyList<MealResponse>())
    }

    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(key1 = "GET_MEALS") {
        coroutineScope.launch(IO) {
            val meals = viewModel.getMeals()
            rememberMeals.value = meals
        }
    }

    LazyColumn() {
        items(rememberMeals.value) { meal ->
            Text(text = meal.name)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MealzAppTheme {
        MealsCategoriesScreen()
    }
}