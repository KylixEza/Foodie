package com.oreyo.foodie.presentation.auth.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.viewbinding.library.fragment.viewBinding
import androidx.activity.addCallback
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.oreyo.foodie.R
import com.oreyo.foodie.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {

    private val binding: FragmentRegisterBinding by viewBinding()

    private lateinit var viewModel: RegisterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.onBackPressedDispatcher?.addCallback {
            view.findNavController().navigate(
                RegisterFragmentDirections.actionRegisterDestinationToOnBoardingDestination("Register")
            )
        }
    }

}