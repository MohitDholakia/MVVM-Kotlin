package com.md.demo.view.fragment.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.md.demo.R
import com.md.demo.adapter.ListAdapter
import com.md.demo.databinding.FragmentListBinding
import com.md.demo.misc.ext.gone
import com.md.demo.misc.ext.observe
import com.md.demo.misc.ext.visible
import com.md.demo.view.BaseFragment
import kotlinx.android.synthetic.main.fragment_list.*
import org.koin.android.architecture.ext.viewModel

class ListFragment : BaseFragment() {
        private val viewModel : ListViewModel by viewModel()
        private lateinit var binding : FragmentListBinding
        private lateinit var adapter : ListAdapter

        override fun onCreateView(
                inflater : LayoutInflater,
                container : ViewGroup?,
                savedInstanceState : Bundle?
        ) : View? {
                binding = FragmentListBinding.inflate(inflater, container, false)
                return binding.root
        }

        override fun onViewCreated(view : View, savedInstanceState : Bundle?) {
                super.onViewCreated(view, savedInstanceState)
                viewModel.getList()
                adapter = ListAdapter()
                setupRecyclerView()
                setupObservers()
        }

        private fun setupObservers() {
                //List
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

        private fun showErrorMessage(message : String?) {
                message?.let {
                        viewModel.exception.value = null
                }
        }

        private fun showNoDataFound(show : Boolean) {
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