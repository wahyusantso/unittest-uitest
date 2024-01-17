package com.home.belajartesting.calculateapp

import org.junit.Assert.*
import org.junit.Before

import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`

//pengujian viewmodel CalculateAppViewModel
class CalculateAppViewModelTest {

    private lateinit var calculateAppViewModel: CalculateAppViewModel
    private lateinit var cuboidModel: CuboidModel

    //sample input
    private val dummyLength = 12.0
    private val dummyWidth = 7.0
    private val dummyHeight = 6.0

    private val dummyVolume = 504.0
    private val dummyCircumference = 100.0
    private val dummySurfaceArea = 396.0

    //inisialisasi class yang dibutuhkan selama pengujian
    @Before
    fun before() {
        cuboidModel = mock(CuboidModel::class.java)
        calculateAppViewModel = CalculateAppViewModel(cuboidModel)
    }

//    pengujian fungsi volume
    @Test
    fun testVolume() {
        cuboidModel = CuboidModel()
        calculateAppViewModel = CalculateAppViewModel(cuboidModel)
        calculateAppViewModel.save(dummyWidth, dummyLength, dummyHeight)
//        panggil fungsi getcolumn() untuk mendapatkan nilai volume
        val volume = calculateAppViewModel.getVolume()
        assertEquals(dummyVolume, volume, 0.0001) //parameter ke 3 adalah angka delta yang merupakan selisih range di belakang koma bilangan double.
    }

    @Test
    fun testCircumference() {
        cuboidModel = CuboidModel()
        calculateAppViewModel = CalculateAppViewModel(cuboidModel)
        calculateAppViewModel.save(dummyWidth, dummyLength, dummyHeight)
        val circumference = calculateAppViewModel.getCircumference()
        assertEquals(dummyCircumference, circumference, 0.0001)
    }

    @Test
    fun testSurfaceArea() {
        cuboidModel = CuboidModel()
        calculateAppViewModel = CalculateAppViewModel(cuboidModel)
        calculateAppViewModel.save(dummyWidth, dummyLength, dummyHeight)
        val surfaceArea = calculateAppViewModel.getSurfaceArea()
        assertEquals(dummySurfaceArea, surfaceArea, 0.0001)
    }

    @Test
    fun testMockVolume() {
        /*melakukan mocking dengan when pada metode calculateAppViewModel.getVolume(),
          ketika metode dipanggil akan mengembalikan nilai dummy dengan menggunakan thenReturn
          dengan begitu kita tidak perlu memanggil metode calculateAppViewModel.save untuk menyimpan nilai.
         */
        `when`(calculateAppViewModel.getVolume()).thenReturn(dummyVolume)
        val volume = calculateAppViewModel.getVolume()
        verify(cuboidModel).getVolume()
        /*
        verify().Memverifikasi bahwa method getVolume() pada objek cuboidModel dipanggil tepat satu kali.
        Jika pemanggilan tidak sesuai dengan yang diharapkan, maka pengujian akan gagal.
         */
        assertEquals(dummyVolume,  volume, 0.0001)
    }

    @Test
    fun testMockCircumference() {
        `when`(calculateAppViewModel.getCircumference()).thenReturn(dummyCircumference)
        val circumference = calculateAppViewModel.getCircumference()
        verify(cuboidModel).getCircumference()
        assertEquals(dummyCircumference, circumference, 0.0001)
    }

    @Test
    fun testMockSurfaceArea() {
        `when`(calculateAppViewModel.getSurfaceArea()).thenReturn(dummySurfaceArea)
        val surfaceArea = calculateAppViewModel.getSurfaceArea()
        verify(cuboidModel).getSurfaceArea()
        assertEquals(dummySurfaceArea, surfaceArea, 0.0001)
    }

    @Test
    fun getCircumference() {
    }

    @Test
    fun getSurfaceArea() {
    }

    @Test
    fun getVolume() {
    }

    @Test
    fun save() {
    }
}