package dev.decagon.godday.registrationform

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)

class ProfileActivityUITest{

    @get:Rule
    val activityRule = ActivityScenarioRule(ProfileActivity::class.java)

    @Test
    fun testViewVisibility() {
        onView(withId(R.id.profileImage)).check(matches(isDisplayed()))
        onView(withId(R.id.fullName)).check(matches(isDisplayed()))
        onView(withId(R.id.phoneNumber)).check(matches(isDisplayed()))
        onView(withId(R.id.userEmail)).check(matches(isDisplayed()))
        onView(withId(R.id.gender)).check(matches(isDisplayed()))
    }
}