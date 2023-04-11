package com.example.cookpedia.datasource

import com.example.cookpedia.ui.meal.data.Meals
import retrofit2.http.GET
import retrofit2.http.Query

interface RestDataSourceMealsList {

    @GET("random.php")
    suspend fun getAMeal() : Meals

}