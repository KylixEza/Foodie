package com.oreyo.foodie.presentation.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.oreyo.foodie.R
import org.koin.android.viewmodel.ext.android.viewModel

class SplashFragment : Fragment() {

    private val viewModel: SplashViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        requireActivity().window.statusBarColor = View.GONE
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            observeHaveRunAppBefore(view)
        }, 2000L)
    }

    private fun observeUsername(view: View) {
        viewModel.readPrefEmail().observe(viewLifecycleOwner) { isLogin ->
            if (isLogin) {
                view.findNavController().navigate(R.id.action_splashFragment_to_baseActivity)
                activity?.finish()
            } else {
                view.findNavController().navigate(R.id.action_splash_destination_to_loginFragment)
            }
        }
    }

    private fun observeHaveRunAppBefore(view: View) {
        viewModel.readPrefHaveRunAppBefore().observe(viewLifecycleOwner) { haveRun ->
            if (haveRun) {
                observeUsername(view)
            } else {
                view.findNavController().navigate(
                    SplashFragmentDirections.actionSplashFragmentToOnBoardingFragment("Splash")
                )
            }
        }
    }

}