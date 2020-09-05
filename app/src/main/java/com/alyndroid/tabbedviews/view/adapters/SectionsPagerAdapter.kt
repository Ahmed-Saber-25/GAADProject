package com.alyndroid.tabbedviews.view.adapters

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.alyndroid.tabbedviews.R
import com.alyndroid.tabbedviews.view.LearningLeadersFragment
import com.alyndroid.tabbedviews.view.SkillIQLeadersFragment

private val TAB_TITLES = arrayOf(
    R.string.learning_leaders,
    R.string.skill_iq_leaders
)

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                LearningLeadersFragment()
            }
            1 -> {
                SkillIQLeadersFragment()
            }
            else -> LearningLeadersFragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        // Show 2 total pages.
        return 2
    }
}