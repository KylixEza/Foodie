package com.oreyo.foodie.presentation.onboard.screen.first

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.viewbinding.library.fragment.viewBinding
import androidx.activity.OnBackPressedCallback
import androidx.viewpager2.widget.ViewPager2
import com.oreyo.foodie.R
import com.oreyo.foodie.databinding.FragmentFirstScreenBinding

class FirstScreenFragment : Fragment() {

    private val binding by viewBinding<FragmentFirstScreenBinding>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        requireActivity().window.statusBarColor = View.GONE
        return inflater.inflate(R.layout.fragment_first_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager)
        binding.btnNext.setOnClickListener {
            viewPager?.currentItem = 1
        }
    }
}