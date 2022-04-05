package com.oreyo.foodie.presentation.auth.register

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.navigation.findNavController
import com.google.android.material.snackbar.Snackbar
import com.oreyo.foodie.data.util.Resource
import com.oreyo.foodie.databinding.FragmentRegisterBinding
import com.oreyo.foodie.model.User
import com.oreyo.foodie.presentation.MainActivity
import com.oreyo.foodie.util.Constanta
import com.oreyo.foodie.util.toUserBody
import org.koin.android.viewmodel.ext.android.viewModel

class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding
    private var email = ""
    private val viewModel: RegisterViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        requireActivity().window.statusBarColor = View.GONE
        _binding = FragmentRegisterBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            activity?.apply {
                btnRegister.setOnClickListener {
                    val email = edtEmail.editText?.text.toString()
                    this@RegisterFragment.email = email
                    val password = edtPassword.editText?.text.toString()
                    val username = edtName.editText?.text.toString()
                    val address = edtAddress.editText?.text.toString()
                    val phoneNumber = edtPhoneNumber.editText?.text.toString()

                    val user = User(
                        address = address, email = email, name = username, phoneNumber = phoneNumber
                    )

                    viewModel.postNewUser(
                        email,
                        password,
                        user.toUserBody()
                    ).observe(viewLifecycleOwner) { resource ->
                        when(resource) {
                            is Resource.Success ->{
                                if (Constanta.SOURCE == Constanta.SOURCE_LOGOUT)
                                    startActivity(Intent(requireContext(), MainActivity::class.java))
                                else
                                    view.findNavController().navigate(RegisterFragmentDirections.actionRegisterDestinationToMainDestination())
                                viewModel.savePrefEmail(email)
                                viewModel.savePrefHaveRunAppBefore(true)
                                activity?.finish()
                            }
                            is Resource.Loading -> {
                                progressBar.visibility = View.VISIBLE
                            }
                            is Resource.Error -> {
                                progressBar.visibility = View.INVISIBLE
                                Snackbar.make(root,resource.message.toString(), Snackbar.LENGTH_LONG).show()
                                Log.e("Register Fragment", resource.message.toString())
                            }
                            else -> {

                            }
                        }
                    }
                }
                onBackPressedDispatcher.addCallback {
                    view.findNavController().navigate(
                        RegisterFragmentDirections.actionRegisterDestinationToOnBoardingDestination("Register")
                    )
                }
            }
        }
    }
}