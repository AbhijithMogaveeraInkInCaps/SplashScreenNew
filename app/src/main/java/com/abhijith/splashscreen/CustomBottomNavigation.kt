package com.abhijith.splashscreen

import android.content.Context
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView

class CustomBottomNavigation(context: Context, attrs: AttributeSet?) :
    BottomNavigationView(context, attrs) {
    init {
        makeCreateIconLarge()
    }

    fun setUpWithNavController(fragmentManager: FragmentManager, callback: Callback) {
        val navHostFragment =
            fragmentManager.findFragmentById(R.id.nav_host_fragm) as NavHostFragment?
        NavigationUI.setupWithNavController(this, navHostFragment!!.navController)
        setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.homeFragment -> {
                    callback.onHome()
                }
                R.id.exploreFragment -> {
                    callback.onExplore()
                }
                R.id.createFragment -> {
                    callback.onCreate()
                }
                R.id.subscriptionFragment2 -> {
                    callback.onSubscription()
                }
                R.id.libraryFragment -> {
                    callback.library()
                }
            }
            true
        }
    }

    interface Callback {
        fun onExplore()
        fun onHome()
        fun onCreate()
        fun onSubscription()
        fun library()
    }
    private fun makeCreateIconLarge() {
        val menuView = this.getChildAt(0) as BottomNavigationMenuView
        val i = 2;
        val iconView = menuView.getChildAt(i).findViewById<View>(R.id.icon)
        val layoutParams = iconView.layoutParams
        val displayMetrics = resources.displayMetrics
        layoutParams.height = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 50f, displayMetrics).toInt()
        layoutParams.width = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 50f, displayMetrics).toInt()
        iconView.layoutParams = layoutParams
    }
}