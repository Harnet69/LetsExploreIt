package com.example.letsexploreit.ui.exploringMap

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ExploringMapViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Exploring map Fragment"
    }
    val text: LiveData<String> = _text
}