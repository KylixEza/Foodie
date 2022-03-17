package com.oreyo.foodie.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.viewbinding.library.activity.viewBinding
import com.oreyo.foodie.R
import com.oreyo.foodie.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by viewBinding<ActivityMainBinding>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}