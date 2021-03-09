package dev.decagon.godday.registrationform

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.instanceOf
import org.hamcrest.core.AllOf.allOf
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityUITest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testViewsHints() {
        onView(withId(R.id.firstName)).check(matches(withHint("First name")))
        onView(withId(R.id.lastName)).check(matches(withHint("Last name")))
        onView(withId(R.id.phone)).check(matches(withHint("Nigerian phone number")))
        onView(withId(R.id.email)).check(matches(withHint("Email")))
    }

    @Test
    fun viewsVisibility() {
        //val activityMock = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.header)).check(matches(isDisplayed()))
        onView(withId(R.id.firstName)).check(matches(isDisplayed()))
        onView(withId(R.id.lastName)).check(matches(isDisplayed()))
        onView(withId(R.id.phone)).check(matches(isDisplayed()))
        onView(withId(R.id.email)).check(matches(isDisplayed()))
        onView(withId(R.id.spinner)).check(matches(isDisplayed()))
        onView(withId(R.id.spinner)).check(matches(isClickable()))
        onView(withId(R.id.button)).check(matches(isDisplayed()))
        onView(withId(R.id.button)).check(matches(isClickable()))
        onView(withId(R.id.sex)).check(matches(isDisplayed()))
    }

    @Test
    fun setUpProfile() {
        val firstName = "John"
        val lastName = "smith"
        val invalidPhoneNumber = "01057093458"
        val validPhoneNumber = "2348057084902"
        val email = "johnsmith@gmail.com"
        val sex = "male"

        onView(withId(R.id.firstName)).perform(typeText(firstName))
        onView(withId(R.id.lastName)).perform(typeText(lastName))
        onView(withId(R.id.phone)).perform(typeText(invalidPhoneNumber), closeSoftKeyboard())
        onView(withId(R.id.email)).perform(typeText(email), closeSoftKeyboard())
        onView(withId(R.id.spinner)).perform(click())
        onData(allOf(`is`(instanceOf(String::class.java)), `is`(sex))).perform(click())
        onView(withId(R.id.button)).perform(click())
        onView(withId(R.id.phone)).perform(clearText(), typeText(validPhoneNumber), closeSoftKeyboard())

        // Navigate to the second activity and verify the views
        onView(withId(R.id.button)).perform(click())
        onView(withId(R.id.fullName)).check(matches(withText("Name: John Smith")))
        onView(withId(R.id.phoneNumber)).check(matches(withText("Phone number: $validPhoneNumber")))
        onView(withId(R.id.userEmail)).check(matches(withText("Email: $email")))
        onView(withId(R.id.gender)).check(matches(withText("Gender: $sex"))).perform(pressBack())
    }

}