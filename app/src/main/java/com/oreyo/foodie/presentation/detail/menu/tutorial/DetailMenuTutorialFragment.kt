package com.oreyo.foodie.presentation.detail.menu.tutorial

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.oreyo.foodie.R

class DetailMenuTutorialFragment : Fragment() {

    companion object {
        fun newInstance() = DetailMenuTutorialFragment()
    }

    private lateinit var viewModel: DetailMenuTutorialViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail_menu_tutorial, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailMenuTutorialViewModel::class.java)
        // TODO: Use the ViewModel
    }

}