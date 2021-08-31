package com.md.demo.view.fragment.listdetail

import androidx.lifecycle.MutableLiveData
import androidx.databinding.ObservableField
import com.md.demo.data.ResponseRepository
import com.md.demo.data.model.ResponseBean
import com.md.demo.view.AbstractViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ListDetailViewModel(private val repository: ResponseRepository) : AbstractViewModel() {
    val model = ObservableField<ResponseBean>()

}