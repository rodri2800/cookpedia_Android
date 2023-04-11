package com.example.cookpedia.ui.principal.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cookpedia.navigation.AppScreens
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PrincipalViewModel @Inject constructor() :ViewModel(){

    private val _selectedPage: MutableLiveData<AppScreens> by lazy{
        MutableLiveData<AppScreens>(AppScreens.HomeScreen)
    }

    var selectedPage:MutableLiveData<AppScreens>
        get() {
            return _selectedPage
        }
        set(value) {
            _selectedPage.value = value.value
        }

}