package com.example.travelapp.activities

import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.travelapp.R
import com.example.travelapp.fragment.BlankFragment
import com.example.travelapp.fragment.HomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        callFragment(HomeFragment.newInstance("a","b"))
        setUpBottomNavigation()

    }

    fun setUpBottomNavigation(){
        BottomNav.setOnNavigationItemSelectedListener(object : BottomNavigationView.OnNavigationItemSelectedListener{
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when(item.itemId){
                    R.id.nav_home ->{
                        callFragment(HomeFragment.newInstance("a","b"))
                        return true
                    }
                    R.id.nav_star ->{
                        callFragment(BlankFragment.newInstance("I am Star Fragment"))
                        return true
                    }
                    R.id.nav_favorite ->{
                        callFragment(BlankFragment.newInstance("I am Favourite Fragment"))
                        return true
                    }
                    R.id.nav_money ->{
                        callFragment(BlankFragment.newInstance("I am Price Fragment"))
                        return true
                    }
                    R.id.nav_search ->{
                        callFragment(BlankFragment.newInstance("I am Search Fragment"))
                        return true
                    }

                }
                return false
            }
        })
    }

    fun callFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.container,fragment).commit()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}