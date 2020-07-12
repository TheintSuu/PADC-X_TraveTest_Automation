package com.example.travelapp.uitests

import android.content.Intent
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.NavigationViewActions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.example.travelapp.R
import com.example.travelapp.activities.MainActivity
import com.example.travelapp.fragment.HomeFragment
import com.example.travelapp.view.viewholder.PopularTourViewHolder
import junit.framework.TestCase.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class NavigationBottomTest {

    private val activityTestRule = ActivityTestRule<MainActivity>(MainActivity::class.java)


    @Before
    open  fun setUp(){
        activityTestRule.launchActivity(Intent())
    }

    @Test
    fun tapNavigationBottom_navigateToFragment(){
        Thread.sleep(5000)
        Espresso.onView(ViewMatchers.withId(R.id.BottomNav))
            .perform(
              click()
            )


//        onView(withId(R.id.BottomNav))
//            .perform(NavigationViewActions.navigateTo(R.id.nav_star))
//
//
//        onView(withId(R.id.horizontalRecycler))
//            .check(matches(isDisplayed()))
    }
}