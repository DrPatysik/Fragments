package com.example.fragments

import android.content.res.Configuration
import android.os.Bundle
import android.text.Layout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.landCarNames, FragmentCarNames())
                .replace(R.id.landCarImage, FragmentCarImages())
                .commit()
        } else {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.mainLayout,FragmentCarNames())
                .commit()
        }
    }

}
