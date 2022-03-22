package com.oreyo.foodie.presentation.detail.variant

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.oreyo.foodie.R

class DetailVariantFragment : Fragment() {

    companion object {
        fun newInstance() = DetailVariantFragment()
    }

    private lateinit var viewModel: DetailVariantViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail_variant, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailVariantViewModel::class.java)
        // TODO: Use the ViewModel
    }

}