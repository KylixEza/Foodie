package com.oreyo.foodie.presentation.onboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.navigation.fragment.navArgs
import com.oreyo.foodie.databinding.FragmentOnBoardingBinding
import com.oreyo.foodie.adapter.OnBoardingViewPagerAdapter
import com.oreyo.foodie.presentation.onboard.screen.first.FirstScreenFragment
import com.oreyo.foodie.presentation.onboard.screen.fourth.FourthScreenFragment
import com.oreyo.foodie.presentation.onboard.screen.second.SecondScreenFragment
import com.oreyo.foodie.presentation.onboard.screen.third.ThirdScreenFragment

class OnBoardingFragment : Fragment() {

    private var _binding: FragmentOnBoardingBinding? = null
    private val binding: FragmentOnBoardingBinding? get() = _binding
    private val args by navArgs<OnBoardingFragmentArgs>()
    lateinit var argSource: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        requireActivity().window.statusBarColor = View.GONE
        _binding = FragmentOnBoardingBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        argSource = args.source

        val listOfFragment = listOf(
            FirstScreenFragment(),
            SecondScreenFragment(),
            ThirdScreenFragment(),
            FourthScreenFragment()
        )

        val adapter = OnBoardingViewPagerAdapter(
            requireActivity().supportFragmentManager,
            lifecycle
        )

        adapter.apply {
            setAllFragments(listOfFragment)
            binding?.viewPager?.adapter = this
        }

        binding?.apply {
            pageIndicatorView.setViewPager2(viewPager)
        }

        activity?.onBackPressedDispatcher?.addCallback {
            if (argSource == "Login" || argSource == "Register") {
                binding?.viewPager?.currentItem = 3
            } else {
                when(binding?.viewPager?.currentItem) {
                    0 -> activity?.finish()
                    1 -> binding?.viewPager?.currentItem = 0
                    2 -> binding?.viewPager?.currentItem = 1
                    3 -> binding?.viewPager?.currentItem = 2
                }
            }

        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}