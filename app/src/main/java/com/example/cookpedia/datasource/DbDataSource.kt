package com.example.cookpedia.datasource

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cookpedia.ui.meal.data.Meal
import com.example.cookpedia.ui.meal.data.MealDao


@Database(entities = [Meal::class], version = 1)
abstract class DbDataSource : RoomDatabase(){

    abstract fun mealDao():MealDao
}