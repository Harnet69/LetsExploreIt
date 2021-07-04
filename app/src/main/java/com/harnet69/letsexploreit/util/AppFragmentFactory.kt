package com.harnet69.letsexploreit.util

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.bumptech.glide.RequestManager
import com.harnet69.letsexploreit.features.exploringMap.ExploringMapFragment
import com.harnet69.letsexploreit.features.group.GroupFragment
import com.harnet69.letsexploreit.features.group.GroupRecyclerAdapter
import com.harnet69.letsexploreit.features.history.HistoryFragment
import javax.inject.Inject

class AppFragmentFactory @Inject constructor(
    private val groupRecyclerAdapter: GroupRecyclerAdapter,
    private val glide: RequestManager
) : FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        // check what class it is and add an appropriate dependency
        return when (className) {
            ExploringMapFragment::class.java.name -> ExploringMapFragment()
            GroupFragment::class.java.name -> GroupFragment(groupRecyclerAdapter)
            HistoryFragment::class.java.name -> HistoryFragment()
            else -> super.instantiate(classLoader, className)
        }
    }
}