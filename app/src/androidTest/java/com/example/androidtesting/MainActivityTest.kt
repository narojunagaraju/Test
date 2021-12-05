package com.example.androidtesting

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Assert.*

import org.junit.Before
import org.junit.Test
import org.junit.Rule
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    val mainActivityRule: ActivityTestRule<MainActivity> =
        ActivityTestRule<MainActivity>(MainActivity::class.java)



    //simple ui test
    @Test
    fun mainActivityTest_emptyName_returnsFalse() {
        onView(ViewMatchers.withId(R.id.editTextTextPersonName2)).perform(typeText(""))
        onView(ViewMatchers.withId(R.id.editTextTextEmailAddress)).perform(typeText("abc@gmail.com"))
        onView(ViewMatchers.withId(R.id.editTextTextPassword)).perform(typeText("abcde123"))
        onView(ViewMatchers.withId(R.id.editTextTextPassword2)).perform(typeText("abcde123"))

        onView(ViewMatchers.withId(R.id.button)).perform(click())


    }

}
