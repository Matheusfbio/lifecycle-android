package com.br.lifecycle.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.br.lifecycle.domain.CounterRepository

class CounterRepositoryImpl: CounterRepository {
    private val counter = MutableLiveData(0)

    override fun getCounter(): LiveData<Int> = counter

    override fun incrementCounterBy(increment: Int) {
        val number = counter.value ?: 0
        counter.value = number + increment
    }
}
