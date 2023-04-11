package com.example.cookpedia.di

import com.example.cookpedia.repository.MealListRepository
import com.example.cookpedia.repository.MealListRepositoryImp
import com.example.cookpedia.ui.bookmark.domain.repository.BookmarkRespository
import com.example.cookpedia.ui.bookmark.domain.repository.BookmarkRespositoryImp
import com.example.cookpedia.ui.components.customcardmeal.domain.repository.CardMealRepository
import com.example.cookpedia.ui.components.customcardmeal.domain.repository.CardMealRepositoryImp
import com.example.cookpedia.ui.meal.domain.repository.MealRepository
import com.example.cookpedia.ui.meal.domain.repository.MealRepositoryImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract  fun mealRepository(repo: MealRepositoryImp) : MealRepository

    @Singleton
    @Binds
    abstract  fun mealListRepository(repo: MealListRepositoryImp) : MealListRepository

    @Singleton
    @Binds
    abstract fun cardMealRepository(repo: CardMealRepositoryImp) : CardMealRepository

    @Singleton
    @Binds
    abstract fun bookMarkRepository(repo: BookmarkRespositoryImp) : BookmarkRespository

}