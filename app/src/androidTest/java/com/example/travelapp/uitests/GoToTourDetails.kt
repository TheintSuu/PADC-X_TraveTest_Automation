package com.example.travelapp.uitests

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.example.travelapp.R
import com.example.travelapp.activities.MainActivity
import com.example.travelapp.view.viewholder.CountryViewHolder
import com.example.travelapp.view.viewholder.PopularTourViewHolder
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class GoToTourDetails {

    private val activityTestRule = ActivityTestRule<MainActivity>(MainActivity::class.java)


    @Before
    open  fun setUp(){
        activityTestRule.launchActivity(Intent())
    }

    @Test
    fun tapOnCountry_navigateToCountryDetail(){
        Thread.sleep(2000)
        onView(withId(R.id.horizontalRecycler))
            .perform(RecyclerViewActions.actionOnItemAtPosition<CountryViewHolder>(0, click()))

        onView(withId(R.id.tvRating))
            .check(matches(isDisplayed()))
    }

    @Test
    fun tapOnCountry_navigateToPopularTourDetail(){
        Thread.sleep(2000)
        onView(withId(R.id.verticalRecyclerView))
            .perform(RecyclerViewActions.actionOnItemAtPosition<PopularTourViewHolder>(0, click()))

        onView(withId(R.id.tvRating))
            .check(matches(isDisplayed()))
    }
}