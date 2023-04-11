package com.example.cookpedia.ui.meal.domain.datasource

import com.example.cookpedia.ui.meal.data.Meals
import retrofit2.http.GET
import retrofit2.http.Query

interface RestDataSourceMeal {

    @GET("lookup.php")
    suspend fun getMeal(@Query("i") id :String ) : Meals

}