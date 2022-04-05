package com.oreyo.foodie.presentation.auth.login

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.viewbinding.library.fragment.viewBinding
import androidx.activity.addCallback
import androidx.fragment.app.commit
import androidx.navigation.findNavController
import com.google.android.material.snackbar.Snackbar
import com.oreyo.foodie.R
import com.oreyo.foodie.data.util.Resource
import com.oreyo.foodie.databinding.FragmentLoginBinding
import com.oreyo.foodie.presentation.MainActivity
import com.oreyo.foodie.presentation.auth.register.RegisterFragment
import com.oreyo.foodie.util.Constanta
import org.koin.android.viewmodel.ext.android.viewModel

class LoginFragment : Fragment() {

    private val binding by viewBinding<FragmentLoginBinding>()
    private val viewModel: LoginViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            btnLogin.setOnClickListener {
                val email = edtEmail.editText?.text.toString()
                val password = edtPassword.editText?.text.toString()
                viewModel.signIn(email, password).observe(viewLifecycleOwner) { resource ->
                    when(resource) {
                        is Resource.Success -> {
                            if (Constanta.SOURCE == Constanta.SOURCE_LOGOUT)
                                startActivity(Intent(requireContext(), MainActivity::class.java))
                            else
                                view.findNavController().navigate(LoginFragmentDirections.actionLoginDestinationToMainDestination())
                            viewModel.savePrefEmail(email)
                            viewModel.savePrefHaveRunAppBefore(true)
                            activity?.finish()
                        }
                        is Resource.Loading -> {
                            progressBar.visibility = View.VISIBLE
                        }
                        is Resource.Error -> {
                            progressBar.visibility = View.INVISIBLE
                            Snackbar.make(binding.root,resource.message.toString(), Snackbar.LENGTH_LONG).show()
                        }
                        else -> {

                        }
                    }
                }
            }
            tvRegister.setOnClickListener {
                if (Constanta.SOURCE == Constanta.SOURCE_LOGOUT) {
                    parentFragmentManager.commit {
                        replace(R.id.auth_container, RegisterFragment())
                    }
                } else {
                    view.findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToRegisterFragment())
                }
            }
        }

        activity?.onBackPressedDispatcher?.addCallback {
            if (Constanta.SOURCE == Constanta.SOURCE_LOGOUT) {
               activity?.finish()
            } else {
                view.findNavController().navigate(
                    LoginFragmentDirections.actionLoginDestinationToOnBoardingDestination("Login")
                )
            }

        }
    }
}