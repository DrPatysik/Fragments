package com.example.fragments

import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null){
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.carNamesContainer,FragmentCarNames())
                .commit()
        }

        /*if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.carNamesContainer, FragmentCarNames())
                        .replace(R.id.landCarImage, FragmentCarImages())
                        .commit()
                }
            else {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.carNamesContainer,FragmentCarNames())
                .commit()
            }*/
    }

}
