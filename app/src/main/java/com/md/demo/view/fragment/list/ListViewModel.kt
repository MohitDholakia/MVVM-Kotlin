package com.md.demo.view.fragment.list

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.md.demo.data.ResponseRepository
import com.md.demo.data.model.UserResult
import com.md.demo.view.AbstractViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ListViewModel(private val repository : ResponseRepository) : AbstractViewModel() {
        val list = MutableLiveData<List<UserResult>>()
        val model = ObservableField<UserResult>()

        fun getList() {
                GlobalScope.launch(Dispatchers.IO) {
                        try {
                                //The data is loading
                                launch(Dispatchers.Main) {
                                        //setLoading()
                                }
                                //Request with a suspended repository funcion

                                var dtoRes = repository.getOfflineRecords()
                                launch(Dispatchers.Main) {
                                        list.value = dtoRes
                                }
                                val apiResponse = repository.getRecords()
                                launch(Dispatchers.Main) {
                                        list.value = apiResponse
                                }
                        } catch (t : Throwable) {
                                //An error was throw
                                launch(Dispatchers.Main) {
                                        setError(t)
                                        list.value = emptyList()
                                }
                        } finally {
                                //Isn't loading anymore
                                launch(Dispatchers.Main) {
                                        setLoading(false)
                                }
                        }
                }

        }

        fun start() {
                list.value = emptyList()
        }
}