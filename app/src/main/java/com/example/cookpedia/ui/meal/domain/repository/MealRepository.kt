package com.example.cookpedia.ui.meal.domain.repository

import com.example.cookpedia.ui.meal.data.DetailsMeal
import com.example.cookpedia.ui.meal.domain.datasource.RestDataSourceMeal
import javax.inject.Inject

interface MealRepository {
    suspend fun getMealInfo(id:String): DetailsMeal
}

class MealRepositoryImp @Inject constructor(
    private val dataSource: RestDataSourceMeal,
): MealRepository {
    override suspend fun getMealInfo(id: String): DetailsMeal {
        return dataSource.getMeal(id).meals[0]
    }
}