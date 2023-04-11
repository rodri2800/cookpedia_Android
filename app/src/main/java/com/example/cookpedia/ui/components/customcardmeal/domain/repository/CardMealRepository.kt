package com.example.cookpedia.ui.components.customcardmeal.domain.repository

import com.example.cookpedia.ui.meal.data.Meal
import com.example.cookpedia.ui.meal.data.MealDao
import javax.inject.Inject


interface CardMealRepository{
    suspend fun insertMeal(meal:Meal)
    suspend fun deleteMeal(meal:Meal)
    suspend fun existMeal(idMeal:String):Int
}


class CardMealRepositoryImp @Inject constructor(
    private val mealDao: MealDao
):CardMealRepository {
    override suspend fun insertMeal(meal:Meal) {
        mealDao.insert(meal)
    }


    override suspend fun deleteMeal(meal: Meal) {
        mealDao.delete(meal)
    }

    override suspend fun existMeal(idMeal: String):Int {
        return mealDao.countMeal(idMeal)
    }


}