package com.harnet69.letsexploreit.util

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.bumptech.glide.RequestManager
import com.harnet69.letsexploreit.features.exploringMap.ExploringMapFragment
import com.harnet69.letsexploreit.features.group.GroupFragment
import com.harnet69.letsexploreit.features.history.HistoryFragment
import javax.inject.Inject

class LetsExploreItFragmentFactory @Inject constructor(
//    private val artRecyclerAdapter: ArtRecyclerAdapter,
//    private val searchRecyclerAdapter: SearchAdapter,
    private val glide: RequestManager
) : FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        // check what class it is and add an appropriate dependency
        return when (className) {
//            ArtsFragment::class.java.name -> ArtsFragment(artRecyclerAdapter)
//            SearchFragment::class.java.name -> SearchFragment(searchRecyclerAdapter)
//            ArtAddingFragment::class.java.name -> ArtAddingFragment(glide)
            ExploringMapFragment::class.java.name -> ExploringMapFragment()
            GroupFragment::class.java.name -> GroupFragment()
            HistoryFragment::class.java.name -> HistoryFragment()
            else -> super.instantiate(classLoader, className)
        }
    }
}