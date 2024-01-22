package com.home.belajartesting.latihanviewmodelapp

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

import org.junit.Test
import org.junit.rules.ExpectedException

class MainViewModelTest {

    private lateinit var mainViewModel: MainViewModel

    @get:Rule
    var thrown = ExpectedException.none()
    /*
    Annotation @Rule digunakan untuk menjalankan kode sebelum pengujian dilakukan.
    Jadi jika tidak diberi anotasi  @Rule pada thrown, maka kode tersebut tidak akan berjalan.
     */

    @Before
    fun init() {
        //inisialisasi viewmodel
        mainViewModel = MainViewModel()
    }
    @Test
    fun calculate() {
        val width = "1"
        val length = "2"
        val height = "3"

        mainViewModel.calculate(width, height, length)
        //membandingkan ekspektasi dengan hasil dari variabel result yang berada di viewmodel
        assertEquals(6, mainViewModel.result)
    }

    @Test
    @Throws(NumberFormatException::class)
    fun doubleInputcalculateTest() {
        val width = "1"
        val length = "2.4"
        val height = "3"

        /*
        memastikan pesan error apakah sesuai ekspektasi dengan menggunakan expectedException yang sebelumnya disiapkan di annotasi @get:rule
        dengan begitu kita bisa tahu apa yang menjadi penyebab erorr pada pengujian.

        NumberFormatException akan terjadi saat Anda mencoba mengubah String menjadi nilai angka namun String tersebut tidak terformat dengan benar.
        Misalnya dalam kasus tersebut ekspektasi Anda adalah Integer, namun aktualnya adalah String.
         */
        thrown.expect(NumberFormatException::class.java)
        thrown.expectMessage("For input string: \"2.4\"")
        mainViewModel.calculate(width, height, length)
    }

    @Test
    @Throws(java.lang.NumberFormatException::class)
    fun characterInputcalculateTest() {
        val width = "1"
        val length = "A"
        val height = "3"

        thrown.expect(java.lang.NumberFormatException::class.java)
        thrown.expectMessage("For input string: \"A\"")
        mainViewModel.calculate(width, height, length)
    }

    @Test
    @Throws(java.lang.NumberFormatException::class)
    fun emptyInputcalculateTest() {
        val width = "1"
        val length = ""
        val height = "3"

        thrown.expect(java.lang.NumberFormatException::class.java)
        thrown.expectMessage("For input string: \"\"")
        mainViewModel.calculate(width, height, length)
    }
}