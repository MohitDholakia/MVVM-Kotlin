package com.md.demo.view.fragment.listdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.md.demo.data.model.UserResult
import com.md.demo.databinding.FragmentDetailBinding
import com.md.demo.misc.util.ViewConstants.Companion.ModelClass
import com.md.demo.view.BaseFragment
import org.koin.android.architecture.ext.viewModel

class ListDetailFragment : BaseFragment() {
        private val viewModel : ListDetailViewModel by viewModel()
        private lateinit var binding : FragmentDetailBinding

        override fun onCreateView(
                inflater : LayoutInflater,
                container : ViewGroup?,
                savedInstanceState : Bundle?
        ) : View {
                binding = FragmentDetailBinding.inflate(inflater, container, false)
                binding.viewmodel = viewModel //attach your viewModel to xml
                return binding.root
        }

        override fun onViewCreated(view : View, savedInstanceState : Bundle?) {
                super.onViewCreated(view, savedInstanceState)
                val model : UserResult? = arguments?.getParcelable(ModelClass)
                viewModel.model.set(model)

        }

        companion object {
                fun newInstance(data: UserResult): ListDetailFragment? {
                        val fragment = ListDetailFragment()
                        val bundle = Bundle()
                        bundle.putParcelable(ModelClass, data)
                        fragment.arguments = bundle
                        return fragment
                }
        }
}