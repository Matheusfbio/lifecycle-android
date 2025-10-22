package com.br.lifecycle

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
     private val _counter = MutableLiveData(0)
     val counter: LiveData<Int> = _counter


     fun increment(){
          val number = _counter.value ?: 0
          _counter.value = number + 1

     }
}