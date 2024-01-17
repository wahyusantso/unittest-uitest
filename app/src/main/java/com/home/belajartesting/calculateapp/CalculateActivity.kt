package com.home.belajartesting.calculateapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import com.home.belajartesting.R
import com.home.belajartesting.databinding.ActivityCalculateBinding

class CalculateActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var activityCalculateBinding: ActivityCalculateBinding
    private lateinit var calculateAppViewModel: CalculateAppViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityCalculateBinding = ActivityCalculateBinding.inflate(layoutInflater)
        setContentView(activityCalculateBinding.root)

        calculateAppViewModel = CalculateAppViewModel(CuboidModel())

        activityCalculateBinding.btnSave.setOnClickListener(this)
        activityCalculateBinding.btnCalculateSurfaceArea.setOnClickListener(this)
        activityCalculateBinding.btnCalculateCircumference.setOnClickListener(this)
        activityCalculateBinding.btnCalculateVolume.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val length = activityCalculateBinding.edtLength.text.toString().trim()
        val width = activityCalculateBinding.edtWidth.text.toString().trim()
        val height = activityCalculateBinding.edtHeight.text.toString().trim()
        when {
            TextUtils.isEmpty(length) -> {
                activityCalculateBinding.edtLength.error = "Field ini tidak boleh kosong"
            }
            TextUtils.isEmpty(width) -> {
                activityCalculateBinding.edtWidth.error = "Field ini tidak boleh kosong"
            }
            TextUtils.isEmpty(height) -> {
                activityCalculateBinding.edtHeight.error = "Field ini tidak boleh kosong"
            }
            else -> {
                val valueLength = length.toDouble()
                val valueWidth = width.toDouble()
                val valueHeight = height.toDouble()
                when (v?.id) {
                    R.id.btn_save -> {
                        calculateAppViewModel.save(valueLength, valueWidth, valueHeight)
                        visible()
                    }
                    R.id.btn_calculate_circumference -> {
                        activityCalculateBinding.tvResult.text = calculateAppViewModel.getCircumference().toString()
                        gone()
                    }
                    R.id.btn_calculate_surface_area -> {
                        activityCalculateBinding.tvResult.text = calculateAppViewModel.getSurfaceArea().toString()
                        gone()
                    }
                    R.id.btn_calculate_volume -> {
                        activityCalculateBinding.tvResult.text = calculateAppViewModel.getVolume().toString()
                        gone()
                    }
                }
            }

        }
    }

    private fun visible() {
        activityCalculateBinding.btnCalculateVolume.visibility = View.VISIBLE
        activityCalculateBinding.btnCalculateCircumference.visibility = View.VISIBLE
        activityCalculateBinding.btnCalculateSurfaceArea.visibility = View.VISIBLE
        activityCalculateBinding.btnSave.visibility = View.GONE
    }
    private fun gone() {
        activityCalculateBinding.btnCalculateVolume.visibility = View.GONE
        activityCalculateBinding.btnCalculateCircumference.visibility = View.GONE
        activityCalculateBinding.btnCalculateSurfaceArea.visibility = View.GONE
        activityCalculateBinding.btnSave.visibility = View.VISIBLE
    }
}