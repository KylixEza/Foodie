package com.oreyo.foodie.presentation.profile

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.viewbinding.library.fragment.viewBinding
import com.oreyo.foodie.R
import com.oreyo.foodie.databinding.FragmentProfileBinding
import com.oreyo.foodie.presentation.auth.AuthActivity
import com.oreyo.foodie.util.Constanta
import org.koin.android.viewmodel.ext.android.viewModel

class ProfileFragment : Fragment() {

    private val binding by viewBinding<FragmentProfileBinding>()
    private val viewModel by viewModel<ProfileViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.includeOtherProfile.btnLogout.setOnClickListener {
            viewModel.savePrefEmail()
            val intent = Intent(activity, AuthActivity::class.java)
            Constanta.SOURCE = Constanta.SOURCE_LOGOUT
            startActivity(intent)
            activity?.finish()
        }
    }

}