package com.md.demo.view.fragment.listdetail

import androidx.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.md.demo.R
import com.md.demo.databinding.FragmentDetailBinding
import com.md.demo.view.BaseFragment
import com.md.demo.view.activity.main.MainViewModel
import kotlinx.android.synthetic.main.fragment_detail.*
import org.koin.android.architecture.ext.viewModel

class ListDetailFragment : BaseFragment() {
    private val viewModel: MainViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentDetailBinding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_detail, container, false)
        binding.viewmodel = viewModel//attach your viewModel to xml
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val index = arguments?.getInt("pos")
        viewModel.model.set(index?.let { viewModel.list.value?.get(it) })
        Glide.with(activity!!)
                .load(viewModel.model.get()?.img?.get(0)?.image)
                .into(imgDetail)
    }

}