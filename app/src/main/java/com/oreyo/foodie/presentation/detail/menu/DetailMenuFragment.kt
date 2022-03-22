package com.oreyo.foodie.presentation.detail.menu

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.oreyo.foodie.R

class DetailMenuFragment : Fragment() {

    companion object {
        fun newInstance() = DetailMenuFragment()
    }

    private lateinit var viewModel: DetailMenuViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail_menu, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailMenuViewModel::class.java)
        // TODO: Use the ViewModel
    }

}