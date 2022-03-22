package com.oreyo.foodie.presentation.detail.order

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.oreyo.foodie.R

class DetailOrderFragment : Fragment() {

    companion object {
        fun newInstance() = DetailOrderFragment()
    }

    private lateinit var viewModel: DetailOrderViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail_order, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailOrderViewModel::class.java)
        // TODO: Use the ViewModel
    }

}