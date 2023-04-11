package com.example.cookpedia.ui.meal.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Entity(tableName = "meal")
data class Meal(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "idMeal")
    var idMeal: String,
    @ColumnInfo(name = "strMeal")
    var strMeal: String,
    @ColumnInfo(name = "strMealThumb")
    var strMealThumb: String,
    var saved:Boolean = false
)




@Dao
interface MealDao{
    @Insert(entity = Meal::class,onConflict = OnConflictStrategy.REPLACE)
    fun insert(meal:Meal)

    @Query("SELECT * FROM meal")
    fun getAll():LiveData<List<Meal>>

    @Delete
    fun delete(meal:Meal)

    @Query("SELECT COUNT(idMeal) FROM meal WHERE idMeal=:idMeal")
    fun countMeal(idMeal:String):Int

}