package com.oreyo.foodie.presentation.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.oreyo.foodie.presentation.challenge.ChallengeFragment

class NotePagerAdapter(
    fm: FragmentManager,
    lifeCycle: Lifecycle,
): FragmentStateAdapter(fm, lifeCycle) {
    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when(position) {
            0 -> fragment = ChallengeFragment()
            1 -> fragment = ChallengeFragment()
            2 -> fragment = ChallengeFragment()
            3 -> fragment = ChallengeFragment()
        }
        return fragment as Fragment
    }
}