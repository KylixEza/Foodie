package com.oreyo.foodie.presentation.voucher.available_voucher

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.oreyo.foodie.R

class AvailableVoucherFragment : Fragment() {

    companion object {
        fun newInstance() = AvailableVoucherFragment()
    }

    private lateinit var viewModel: AvailableVoucherViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_available_voucher, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AvailableVoucherViewModel::class.java)
        // TODO: Use the ViewModel
    }

}