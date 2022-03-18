package com.oreyo.foodie.presentation.auth.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.viewbinding.library.fragment.viewBinding
import androidx.activity.addCallback
import androidx.navigation.findNavController
import com.oreyo.foodie.R
import com.oreyo.foodie.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private val binding by viewBinding<FragmentLoginBinding>()
    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogin.setOnClickListener {
            view.findNavController().navigate(
                LoginFragmentDirections.actionLoginDestinationToMainDestination()
            )
        }

        activity?.onBackPressedDispatcher?.addCallback {
            view.findNavController().navigate(
                LoginFragmentDirections.actionLoginDestinationToOnBoardingDestination("Login")
            )
        }
    }

}