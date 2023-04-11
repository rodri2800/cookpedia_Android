package com.example.cookpedia.ui.bookmark.domain.repository

import androidx.lifecycle.LiveData
import com.example.cookpedia.ui.meal.data.Meal
import com.example.cookpedia.ui.meal.data.MealDao
import javax.inject.Inject


interface BookmarkRespository{
    fun getAllMeals():LiveData<List<Meal>>
}

class BookmarkRespositoryImp @Inject constructor(
    private val mealDao: MealDao
) : BookmarkRespository {
    override fun getAllMeals(): LiveData<List<Meal>> = mealDao.getAll()
}