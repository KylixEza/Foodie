package com.oreyo.foodie.presentation.detail.menu.about

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.oreyo.foodie.R

class DetailMenuAboutFragment : Fragment() {

    companion object {
        fun newInstance() = DetailMenuAboutFragment()
    }

    private lateinit var viewModel: DetailMenuAboutViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail_menu_about, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailMenuAboutViewModel::class.java)
        // TODO: Use the ViewModel
    }

}