package com.oreyo.foodie.presentation.onboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.viewbinding.library.fragment.viewBinding
import androidx.viewpager2.widget.ViewPager2
import com.oreyo.foodie.R
import com.oreyo.foodie.databinding.FragmentOnBoardingBinding
import com.oreyo.foodie.presentation.adapter.OnBoardingViewPagerAdapter
import com.oreyo.foodie.presentation.onboard.screen.first.FirstScreenFragment
import com.oreyo.foodie.presentation.onboard.screen.fourth.FourthScreenFragment
import com.oreyo.foodie.presentation.onboard.screen.second.SecondScreenFragment
import com.oreyo.foodie.presentation.onboard.screen.third.ThirdScreenFragment

class OnBoardingFragment : Fragment() {

    private val binding by viewBinding<FragmentOnBoardingBinding>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        requireActivity().window.statusBarColor = View.GONE
        return inflater.inflate(R.layout.fragment_on_boarding, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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
            binding.viewPager.adapter = this
        }

        binding.apply {
            pageIndicatorView.setViewPager2(binding.viewPager)
            /*viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    pageIndicatorView.setSelected(position)
                }
            })*/
        }
    }
}