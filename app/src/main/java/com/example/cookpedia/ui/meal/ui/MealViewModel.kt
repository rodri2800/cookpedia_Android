package com.example.cookpedia.ui.meal.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cookpedia.ui.meal.data.DetailsMeal
import com.example.cookpedia.ui.meal.domain.repository.MealRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MealViewModel @Inject constructor(
    private val mealRepositoryImp: MealRepository
) : ViewModel(){

    private val _mealInfo: MutableLiveData<DetailsMeal> by lazy{
        MutableLiveData<DetailsMeal>(null)
    }

    private val _isLoading: MutableLiveData<Boolean> by lazy{
        MutableLiveData<Boolean>(true)
    }

    val isLoading: LiveData<Boolean> get() = _isLoading

    fun getMeal(id:String){
        viewModelScope.launch() {
            _isLoading.postValue(true)
            val meal = mealRepositoryImp.getMealInfo(id)
            Log.d("MealViewModel", meal.toString())
            mealInfo.value = meal
            _isLoading.postValue(false)
        }
    }

    val mealInfo:MutableLiveData<DetailsMeal> get() = _mealInfo


}