package com.oreyo.foodie.presentation.detail.verification

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.oreyo.foodie.R

class DetailVerificationFragment : Fragment() {

    companion object {
        fun newInstance() = DetailVerificationFragment()
    }

    private lateinit var viewModel: DetailVerificationViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail_verification, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailVerificationViewModel::class.java)
        // TODO: Use the ViewModel
    }

}