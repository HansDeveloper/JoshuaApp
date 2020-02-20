package com.example.joshuaapp.screens.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.joshuaapp.R
import com.example.joshuaapp.fragments.EmployeeFragment
import com.example.joshuaapp.fragments.UbicationFragment
import kotlinx.android.synthetic.main.fragment_ubication.*

private val TAB_TITLES = arrayOf(
    R.string.tab_text_1,
    R.string.tab_text_2
)

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        var frag : Fragment? = null

        when(position){
            0 -> {
                return EmployeeFragment()
            }
            1 -> {
                return UbicationFragment()
            }
            else -> return frag!!
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