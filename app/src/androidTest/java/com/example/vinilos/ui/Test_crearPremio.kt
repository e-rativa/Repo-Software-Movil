package com.example.vinilos.ui


import androidx.test.espresso.DataInteraction
import androidx.test.espresso.ViewInteraction
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent

import androidx.test.InstrumentationRegistry.getInstrumentation
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*

import com.example.vinilos.R

import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher
import org.hamcrest.core.IsInstanceOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.anything
import org.hamcrest.Matchers.`is`

@LargeTest
@RunWith(AndroidJUnit4::class)
class Test_crearPremio {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun test_crearPremio() {
        val materialButton = onView(
allOf(withId(R.id.button_collector_rol), withText("COLECCIONISTA"),
childAtPosition(
childAtPosition(
withClassName(`is`("android.widget.ScrollView")),
0),
1)))
        materialButton.perform(scrollTo(), click())
        
         // Added a sleep statement to match the app's execution delay.
 // The recommended way to handle such scenarios is to use Espresso idling resources:
  // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
Thread.sleep(700)
        
        val materialButton2 = onView(
allOf(withId(R.id.button_prizes_menu), withText("PREMIOS"),
childAtPosition(
childAtPosition(
withClassName(`is`("android.widget.RelativeLayout")),
0),
1),
isDisplayed()))
        materialButton2.perform(click())
        
         // Added a sleep statement to match the app's execution delay.
 // The recommended way to handle such scenarios is to use Espresso idling resources:
  // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
Thread.sleep(700)
        
        val floatingActionButton = onView(
allOf(withId(R.id.fab_prizes), withContentDescription("Crear Premio"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
1),
isDisplayed()))
        floatingActionButton.perform(click())
        
         // Added a sleep statement to match the app's execution delay.
 // The recommended way to handle such scenarios is to use Espresso idling resources:
  // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
Thread.sleep(700)
        
        val appCompatEditText = onView(
allOf(withId(R.id.editTextTextOrganizacion),
childAtPosition(
childAtPosition(
withClassName(`is`("androidx.constraintlayout.widget.ConstraintLayout")),
0),
2),
isDisplayed()))
        appCompatEditText.perform(replaceText("prueba"), closeSoftKeyboard())
        
        val appCompatEditText2 = onView(
allOf(withId(R.id.editTextTextNombre),
childAtPosition(
childAtPosition(
withClassName(`is`("androidx.constraintlayout.widget.ConstraintLayout")),
0),
4),
isDisplayed()))
        appCompatEditText2.perform(replaceText("nombreprueba"), closeSoftKeyboard())
        
        val appCompatEditText3 = onView(
allOf(withId(R.id.editTextTextDescripcion),
childAtPosition(
childAtPosition(
withClassName(`is`("androidx.constraintlayout.widget.ConstraintLayout")),
0),
6),
isDisplayed()))
        appCompatEditText3.perform(replaceText("descripcion de prueba"), closeSoftKeyboard())
        
        val materialButton3 = onView(
allOf(withId(R.id.button_create_prize), withText("CREAR"),
childAtPosition(
childAtPosition(
withClassName(`is`("androidx.constraintlayout.widget.ConstraintLayout")),
0),
7),
isDisplayed()))
        materialButton3.perform(click())
        
        val materialButton4 = onView(
allOf(withId(android.R.id.button1), withText("OK"),
childAtPosition(
childAtPosition(
withId(R.id.buttonPanel),
0),
3)))
        materialButton4.perform(scrollTo(), click())
        
        val appCompatEditText4 = onView(
allOf(withId(R.id.editTextTextDescripcion),
childAtPosition(
childAtPosition(
withClassName(`is`("androidx.constraintlayout.widget.ConstraintLayout")),
0),
6),
isDisplayed()))
        appCompatEditText4.perform(click())
        }
    
    private fun childAtPosition(
            parentMatcher: Matcher<View>, position: Int): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
    }
