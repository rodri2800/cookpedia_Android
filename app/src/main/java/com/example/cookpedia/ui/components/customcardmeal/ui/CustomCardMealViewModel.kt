package com.example.cookpedia.ui.components.customcardmeal.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cookpedia.ui.components.customcardmeal.domain.repository.CardMealRepository
import com.example.cookpedia.ui.meal.data.Meal
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CustomCardMealViewModel @Inject constructor(
    private val cardMealRepository: CardMealRepository
):ViewModel() {

    private val _saved: MutableLiveData<Map<Int, Boolean>> by lazy {
        MutableLiveData<Map<Int, Boolean>>(mutableMapOf())
    }

    val saved:LiveData<Map<Int, Boolean>> get() = _saved

    fun consultAddOnBD(idMeal: String){
        val mealId:Int = Integer.parseInt(idMeal)
        viewModelScope.launch(Dispatchers.IO) {
            val exist = cardMealRepository.existMeal(idMeal)
            Log.d("Existe: $idMeal", exist.toString())
            if(exist==1){
                _saved.postValue(_saved.value.orEmpty() + (mealId to true))
            }
        }
    }

    fun buttonSaveMeal(meal: Meal) {
        val mealId:Int = Integer.parseInt(meal.idMeal)

        if (_saved.value?.get(mealId) == null || _saved.value?.get(mealId) == false) {
            viewModelScope.launch(Dispatchers.IO) {
                cardMealRepository.insertMeal(meal = meal)
                _saved.postValue(_saved.value.orEmpty() + (mealId to true))
            }
        } else {
            viewModelScope.launch(Dispatchers.IO) {
                cardMealRepository.deleteMeal(meal = meal)
                _saved.postValue(_saved.value.orEmpty() - mealId)
            }
        }
    }
}
