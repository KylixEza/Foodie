package com.oreyo.foodie.presentation.note

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.viewbinding.library.fragment.viewBinding
import com.google.android.material.tabs.TabLayoutMediator
import com.oreyo.foodie.R
import com.oreyo.foodie.databinding.FragmentNoteBinding
import com.oreyo.foodie.presentation.adapter.NotePagerAdapter

class NoteFragment : Fragment() {

    private val binding by viewBinding<FragmentNoteBinding>()


    private lateinit var viewModel: NoteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_note, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tabTitles = arrayListOf<String>("Cemilan", "Sarapan", "Makan Siang", "Makan Malam")

        val pagerAdapter = NotePagerAdapter(
            requireActivity().supportFragmentManager,
            lifecycle
        )

        binding.apply {
            fakeViewPager.adapter = pagerAdapter
            TabLayoutMediator(tabNote, fakeViewPager) { tab, position ->
                tab.text = tabTitles[position]
            }.attach()

        }
    }

}