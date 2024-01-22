package com.home.belajartesting.latihanviewmodelapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.home.belajartesting.R
import com.home.belajartesting.databinding.ActivityMainLatihanViewmodelBinding

class MainActivityLatihanViewmodel : AppCompatActivity() {

    private lateinit var activityMainLatihanViewmodelBinding: ActivityMainLatihanViewmodelBinding
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityMainLatihanViewmodelBinding = ActivityMainLatihanViewmodelBinding.inflate(layoutInflater)
        setContentView(activityMainLatihanViewmodelBinding.root)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        displayResult()

        activityMainLatihanViewmodelBinding.btnCalculate.setOnClickListener {

            val width = activityMainLatihanViewmodelBinding.edtWidth.text.toString()
            val height = activityMainLatihanViewmodelBinding.edtHeight.text.toString()
            val length = activityMainLatihanViewmodelBinding.edtLength.text.toString()

            when {
                width.isEmpty() -> {
                    activityMainLatihanViewmodelBinding.edtWidth.error = "Masih kosong"
                }
                height.isEmpty() -> {
                    activityMainLatihanViewmodelBinding.edtHeight.error = "Masih kosong"
                }
                length.isEmpty() -> {
                    activityMainLatihanViewmodelBinding.edtLength.error = "Masih kosong"
                }
                else -> {

                    viewModel.calculate(width, height, length)

                    displayResult()
                }
            }
        }
    }

    private fun displayResult() {
        activityMainLatihanViewmodelBinding.tvResult.text = viewModel.result.toString()
    }
}