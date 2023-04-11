package com.example.cookpedia.di

import android.content.Context
import androidx.room.Room
import com.example.cookpedia.datasource.DbDataSource
import com.example.cookpedia.datasource.RestDataSourceMealsList
import com.example.cookpedia.ui.meal.data.MealDao
import com.example.cookpedia.ui.meal.domain.datasource.RestDataSourceMeal
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {

    @Singleton
    @Provides
    @Named("BaseUrl")
    fun provideBaseUrl() = "https://www.themealdb.com/api/json/v1/1/"


    @Singleton
    @Provides
    fun provideRetrofit(@Named("BaseUrl") baseUrl:String) : Retrofit{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
    }


    @Singleton
    @Provides
    fun restDataSourcesMeal(retrofit: Retrofit):RestDataSourceMeal =
        retrofit.create(RestDataSourceMeal::class.java)


    @Singleton
    @Provides
    fun restDataSourcesListMeal(retrofit: Retrofit):RestDataSourceMealsList =
        retrofit.create(RestDataSourceMealsList::class.java)


    @Singleton
    @Provides
    fun dbDataSource(@ApplicationContext context: Context):DbDataSource{
        return Room.databaseBuilder(context, DbDataSource::class.java, "meal_database")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun mealDao(db:DbDataSource):MealDao = db.mealDao()

}