package com.example.cookpedia.repository

import com.example.cookpedia.datasource.RestDataSourceMealsList
import com.example.cookpedia.ui.meal.data.DetailsMeal
import com.example.cookpedia.ui.meal.data.Meal
import com.example.cookpedia.ui.meal.data.Meals
import com.example.cookpedia.ui.meal.domain.datasource.RestDataSourceMeal
import javax.inject.Inject

interface MealListRepository {
    suspend fun getMealInfo(): List<Meal>
}

class MealListRepositoryImp @Inject constructor(
    private val dataSource: RestDataSourceMealsList
): MealListRepository {
    override suspend fun getMealInfo(): List<Meal> {
        var meals:MutableList<Meal> = emptyList<Meal>().toMutableList()

        for (i in 1..15){
            val meal:DetailsMeal = dataSource.getAMeal().meals[0]
            meal.let {
                meals.add(
                    Meal(
                        idMeal = meal.idMeal!!,
                        strMeal = meal.strMeal!!,
                        strMealThumb = meal.strMealThumb!!
                    )
                )
            }
        }

        return meals
    }
}