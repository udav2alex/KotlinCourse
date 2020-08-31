package ru.gressor.kotlincourse.homework1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val counterText = MutableLiveData<String>()
    private val counterModel = MutableLiveData<Int>()

    init {
        counterModel.observeForever {
            counterText.value = "Button clicked $it times"
        }
        counterModel.value = 0
    }

    fun value() : LiveData<String> = counterText

    fun onClick() {
        counterModel.value = (1 + counterModel.value!!)
    }
}