package com.md.demo.view.fragment.listdetail

import androidx.databinding.ObservableField
import com.md.demo.data.ResponseRepository
import com.md.demo.data.model.UserResult
import com.md.demo.view.AbstractViewModel

class ListDetailViewModel(private val repository : ResponseRepository) : AbstractViewModel() {
        val model = ObservableField<UserResult>()

}