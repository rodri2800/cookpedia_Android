package com.example.cookpedia.ui.bookmark.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.cookpedia.ui.bookmark.domain.repository.BookmarkRespository
import com.example.cookpedia.ui.meal.data.Meal
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BookmarkViewModel @Inject constructor(
    private val bookmarkRespository: BookmarkRespository
):ViewModel(){
    val meals:LiveData<List<Meal>> by lazy {
        bookmarkRespository.getAllMeals()
    }
}