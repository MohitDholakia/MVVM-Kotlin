package com.md.demo.view.fragment.listdetail

import androidx.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.md.demo.R
import com.md.demo.data.model.ResponseBean
import com.md.demo.databinding.FragmentDetailBinding
import com.md.demo.view.BaseFragment
import com.md.demo.view.activity.main.MainViewModel
import kotlinx.android.synthetic.main.fragment_detail.*
import org.koin.android.architecture.ext.viewModel

class ListDetailFragment : BaseFragment() {
    private val viewModel: ListDetailViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentDetailBinding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_detail, container, false)
        binding.viewmodel = viewModel//attach your viewModel to xml
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val model : ResponseBean? = arguments?.getParcelable("modelClass")
        viewModel.model.set(model)
        Glide.with(requireActivity())
                .load(viewModel.model.get()?.img?.get(0)?.image)
                .into(imgDetail)


        val action = ListDetailFragmentDirections.actionDetailFragmentToImageActivity()
        findNavController().navigate(action)
    }
}