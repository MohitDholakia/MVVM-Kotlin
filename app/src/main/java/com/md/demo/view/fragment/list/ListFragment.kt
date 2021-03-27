package com.md.demo.view.fragment.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.md.demo.R
import com.md.demo.adapter.ListAdapter
import com.md.demo.misc.ext.gone
import com.md.demo.misc.ext.observe
import com.md.demo.misc.ext.visible
import com.md.demo.view.BaseFragment
import com.md.demo.view.activity.main.MainViewModel
import kotlinx.android.synthetic.main.fragment_list.*
import org.jetbrains.anko.support.v4.alert
import org.jetbrains.anko.yesButton
import org.koin.android.architecture.ext.viewModel

class ListFragment : BaseFragment() {
    private val viewModel: MainViewModel by viewModel()

    private var adapter: ListAdapter = ListAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setupRecyclerView()
        setupObservers()
    }

    private fun setupObservers() {
        //Current currency
        observe(viewModel.list) {
            it?.let {
                adapter.dataList = it
            }
            showNoDataFound(adapter.dataList.isEmpty())
        }

        //ProgressBar
        observe(viewModel.isDataLoading) {
            if (it == true) {
                viewProgressBar.visible()
            } else {
                viewProgressBar.gone()
            }
        }

        observe(viewModel.exception) {
            showErrorMessage(it?.message)
        }
    }

    private fun showErrorMessage(message: String?) {
        message?.let {
            alert(message, getString(R.string.error)) {
                yesButton { }
            }.show()
            viewModel.exception.value = null
        }
    }

    private fun showNoDataFound(show: Boolean) {
        if (show) {
            viewError.visible()
            textViewError.text = getString(R.string.no_data_found)
        } else {
            viewError.gone()
        }
    }

    private fun setupRecyclerView() {
        recyclerView.adapter = adapter
    }
}