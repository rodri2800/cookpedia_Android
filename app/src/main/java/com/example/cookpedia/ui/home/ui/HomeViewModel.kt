package com.example.cookpedia.ui.home.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cookpedia.repository.MealListRepository
import com.example.cookpedia.ui.meal.data.Meal
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val mealRespositoryImp: MealListRepository
):ViewModel() {


    private val _mealsListRecentRecipes: MutableLiveData<List<Meal>> by lazy {
        MutableLiveData<List<Meal>>(emptyList())
    }

    private val _mealsListYourRecipes: MutableLiveData<List<Meal>> by lazy {
        MutableLiveData<List<Meal>>(emptyList())
    }

    private val _mealsListBookmark: MutableLiveData<List<Meal>> by lazy {
        MutableLiveData<List<Meal>>(emptyList())
    }



    fun getMeals() {
        if(_mealsListRecentRecipes.value?.isEmpty()==true){
            viewModelScope.launch(Dispatchers.IO) {
                _mealsListRecentRecipes.postValue(mealRespositoryImp.getMealInfo())
            }
        }
        if(_mealsListYourRecipes.value?.isEmpty()==true){
            viewModelScope.launch(Dispatchers.IO) {
                _mealsListYourRecipes.postValue(mealRespositoryImp.getMealInfo())
            }
        }

        if(_mealsListBookmark.value?.isEmpty()==true){
            viewModelScope.launch(Dispatchers.IO) {
                _mealsListBookmark.postValue(mealRespositoryImp.getMealInfo())
            }
        }

    }



    val mealsListRecentRecipes: LiveData<List<Meal>> get() = _mealsListRecentRecipes
    val mealsListYourRecipes: LiveData<List<Meal>> get() = _mealsListYourRecipes
    val mealsListBookmark: LiveData<List<Meal>> get() = _mealsListBookmark
}