package com.oreyo.foodie.presentation.onboard.screen.third

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.viewbinding.library.fragment.viewBinding
import androidx.activity.OnBackPressedCallback
import androidx.viewpager2.widget.ViewPager2
import com.oreyo.foodie.R
import com.oreyo.foodie.databinding.FragmentThirdScreenBinding

class ThirdScreenFragment : Fragment() {

    private val binding by viewBinding<FragmentThirdScreenBinding>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager)
        binding.btnNext.setOnClickListener {
            viewPager?.currentItem = 3
        }
    }
}