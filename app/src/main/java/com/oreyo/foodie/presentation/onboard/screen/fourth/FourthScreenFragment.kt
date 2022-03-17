package com.oreyo.foodie.presentation.onboard.screen.fourth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.viewbinding.library.fragment.viewBinding
import androidx.navigation.findNavController
import com.oreyo.foodie.R
import com.oreyo.foodie.databinding.FragmentFourthScreenBinding
import com.oreyo.foodie.presentation.onboard.OnBoardingFragmentDirections

class FourthScreenFragment : Fragment() {

    private val binding by viewBinding<FragmentFourthScreenBinding>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fourth_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            btnLogin.setOnClickListener {
                view.findNavController().navigate(
                    OnBoardingFragmentDirections.actionOnBoardingDestinationToLoginFragment()
                )
            }
            btnRegister.setOnClickListener {
                view.findNavController().navigate(
                    OnBoardingFragmentDirections.actionOnBoardingDestinationToRegisterFragment()
                )
            }
        }
    }
}