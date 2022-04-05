package com.oreyo.foodie.presentation.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.viewbinding.library.fragment.viewBinding
import androidx.recyclerview.widget.GridLayoutManager
import com.oreyo.foodie.R
import com.oreyo.foodie.adapter.CategoryAdapter
import com.oreyo.foodie.data.source.dummy.Dummy
import com.oreyo.foodie.databinding.FragmentHomeBinding
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private val binding by viewBinding<FragmentHomeBinding>()
    private val viewModel by viewModel<HomeViewModel>()
    private val categoryAdapter by inject<CategoryAdapter>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            rvCategory.apply {
                categoryAdapter.setAllData(Dummy.setCategories())
                adapter = categoryAdapter
                layoutManager = GridLayoutManager(requireContext(), 2, GridLayoutManager.HORIZONTAL, false)
            }
        }
    }

}