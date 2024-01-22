package com.home.belajartesting.latihanviewmodelapp

import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    // Membuat variable penampung, untuk dipertahankan datanya
    var result = 0

    // Metode calculate untuk menghitung volume
    fun calculate(width: String, height: String, length: String) {
        // Mengubah hasil result dari hasil perkalian lebar, tinggi dan panjang.
        result = width.toInt() * height.toInt() * length.toInt()
    }
}