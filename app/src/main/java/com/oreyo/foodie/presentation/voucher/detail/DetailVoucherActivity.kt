package com.oreyo.foodie.presentation.voucher.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.oreyo.foodie.R

class DetailVoucherActivity : AppCompatActivity() {
    companion object {
        const val DETAIL_VOUCHER = "DETAIL_VOUCHER"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_voucher)
    }
}