package com.oreyo.foodie.presentation.voucher.my_voucher

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.oreyo.foodie.R

class MyVoucherFragment : Fragment() {

    companion object {
        fun newInstance() = MyVoucherFragment()
    }

    private lateinit var viewModel: MyVoucherViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_my_voucher, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MyVoucherViewModel::class.java)
        // TODO: Use the ViewModel
    }

}