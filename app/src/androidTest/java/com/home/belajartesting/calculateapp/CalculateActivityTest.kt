package com.home.belajartesting.calculateapp

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import com.home.belajartesting.R

@RunWith(AndroidJUnit4ClassRunner::class)
class CalculateActivityTest {
    private val dummyVolume = "504.0"
    private val dummyCircumference = "100.0"
    private val dummySurfaceArea = "396.0"
    private val dummyLength = "12.0"
    private val dummyWidth = "7.0"
    private val dummyHeight = "6.0"
    private val emptyInput = ""
    private val fieldEmpty = "Field ini tidak boleh kosong"

    @Before
    fun setup() {
        //digunakan untuk menentukan Activity mana yang akan dijalankan.
        ActivityScenario.launch(CalculateActivity::class.java)
    }

    @Test
    fun assertGetCircumference() {
        //jika kode di bawah dibaca maka jadi seperti ini: Sebuah view dengan id edt_length diberi tindakan input dengan sebuah teks dummyLength dan menutup secara berlahan keyboard Android.
        onView(withId(R.id.edt_width)).perform(typeText(dummyLength), closeSoftKeyboard())
        onView(withId(R.id.edt_width)).perform(typeText(dummyWidht), closeSoftKeyboard())
        onView(withId(R.id.edt_height)).perform(typeText(dummyHeight), closeSoftKeyboard())

        //Jika kode di bawah dibaca akan menjadi seperti ini: Memastikan sebuah view dengan id btn_save dalam keadaan tampil.
        onView(withId(R.id.btn_save)).check(matches(isDisplayed()))

        //Jika kode di bawah dibaca, akan menjadi seperti ini: Sebuah view dengan id btn_save diberi aksi klik.
        onView(withId(R.id.btn_save)).perform(click())

        onView(withId(R.id.btn_calculate_circumference)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_calculate_circumference)).perform(click())

        onView(withId(R.id.tv_result)).check(matches(isDisplayed()))

        //Jika kode di bawah dibaca, akan menjadi seperti berikut: Memastikan sebuah view dengan id tv_result mempunyai teks yang sama dengan dummyCircumference.
        onView(withId(R.id.tv_result)).check(matches(withText(dummyCircumference)))
    }

    //Pengecekan untuk empty input
    @Test
    fun assertEmptyInput() {
        // pengecekan input untuk length
        onView(withId(R.id.edt_length)).perform(typeText(emptyInput), closeSoftKeyboard())
        onView(withId(R.id.btn_save)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_save)).perform(click())
        onView(withId(R.id.edt_length)).check(matches(hasErrorText(fieldEmpty)))
        onView(withId(R.id.edt_length)).perform(typeText(dummyLength), closeSoftKeyboard())
        // pengecekan input untuk width
        onView(withId(R.id.edt_width)).perform(typeText(emptyInput), closeSoftKeyboard())
        onView(withId(R.id.btn_save)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_save)).perform(click())
        onView(withId(R.id.edt_width)).check(matches(hasErrorText(fieldEmpty)))
        onView(withId(R.id.edt_width)).perform(typeText(dummyWidth), closeSoftKeyboard())
        // pengecekan input untuk height
        onView(withId(R.id.edt_height)).perform(typeText(emptyInput), closeSoftKeyboard())
        onView(withId(R.id.btn_save)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_save)).perform(click())
        onView(withId(R.id.edt_height)).check(matches(hasErrorText(fieldEmpty)))
        onView(withId(R.id.edt_height)).perform(typeText(dummyHeight), closeSoftKeyboard())
        onView(withId(R.id.btn_save)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_save)).perform(click())
    }

    /*
    onView(withId(R.id.edt_length)).check(matches(hasErrorText(fieldEmpty)))
    Jika kode di atas dibaca akan menjadi seperti berikut: Memastikan sebuah view dengan id edt_length mempunyai pesan eror yang sama dengan fieldEmpty.
     */
}