package com.md.demo.view.main

import android.arch.lifecycle.MutableLiveData
import android.databinding.ObservableField
import com.md.demo.data.ResponseRepository
import com.md.demo.data.model.ResponseBean
import com.md.demo.view.AbstractViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainViewModel(private val repository: ResponseRepository) : AbstractViewModel() {
    val list = MutableLiveData<List<ResponseBean>>()
    val model = ObservableField<ResponseBean>()

    fun getList() {
         GlobalScope.launch(Dispatchers.IO) {
            try {
                //The data is loading
                launch (Dispatchers.Main) {
                    setLoading()
                }
                //Request with a suspended repository funcion
                val dtoRes = repository.getRecords()
                launch (Dispatchers.Main) {
                    list.value = dtoRes
                }
            } catch (t: Throwable) {
                //An error was throw
                launch (Dispatchers.Main) {
                    setError(t)
                    list.value = emptyList()
                }
            } finally {
                //Isn't loading anymore
                launch (Dispatchers.Main) {
                    setLoading(false)
                }
            }
        }

    }

    fun start() {
        list.value = emptyList()
    }
}