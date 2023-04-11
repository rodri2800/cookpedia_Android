package com.example.cookpedia.ui.recipes.ui

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
class RecipesViewModel @Inject constructor(
    private val mealRespositoryImp: MealListRepository
): ViewModel() {


    private val _isLoading: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>(true)
    }

    val isLoading : LiveData<Boolean> get() = _isLoading


    private val _mealsListYourRecipes: MutableLiveData<List<Meal>> by lazy {
        MutableLiveData<List<Meal>>(emptyList())
    }



    fun getMeals() {
        if(_mealsListYourRecipes.value?.isEmpty()==true){
            viewModelScope.launch(Dispatchers.IO) {
                _mealsListYourRecipes.postValue(mealRespositoryImp.getMealInfo())
                _isLoading.postValue(false)
            }

        }
    }



    val mealsListYourRecipes: LiveData<List<Meal>> get() = _mealsListYourRecipes
}