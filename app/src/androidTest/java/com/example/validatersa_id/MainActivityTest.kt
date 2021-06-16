package com.example.validatersa_id

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import kotlinx.android.synthetic.main.activity_main.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {

    @get: Rule
    val activity: ActivityScenarioRule<MainActivity> = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testIsMainActivityInView() {
        // Given

        // When

        //Then
        onView(withId(R.id.main)).check(matches(isDisplayed()))
    }

    @Test
    fun testIsInstructionTextInView() {
        // Given

        //When

        //Then
        onView(withId(R.id.instruction_text)).check(matches(isDisplayed()))
        onView(withId(R.id.instruction_text)).check(matches(withText(R.string.instruction)))
    }

    @Test
    fun testIsInputPaneInView() {
        // Given

        //When

        //Then
        onView(withId(R.id.input_id)).check(matches(isDisplayed()))
        onView(withId(R.id.input_id)).check(matches(withHint(R.string.inputText)))
    }

    @Test
    fun testIsVerifyButtonInView() {
        // Given

        //When

        //Then
        onView(withId(R.id.verify_button)).check(matches(isDisplayed()))
    }

    @Test
    fun testTextOutputAfterButtonClicked() {
        //Given
        activity.scenario.onActivity {
            it.input_id.setText("9211305050082")
        }

        //When

        //Then
        onView(withId(R.id.verify_button)).perform(click())
        onView(withId(R.id.validated_output)).check(matches(withText(R.string.invalid_id)))
    }
}