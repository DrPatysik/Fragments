package com.example.fragments

import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.FragmentTransaction

class FragmentCarNames : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_car_names, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initArray()
    }

    private fun initArray() {
        val viewLayout = view as LinearLayout
        val carNames = resources.getStringArray(R.array.retro_cars_name)

        for (i in carNames.indices) {
            val carName = carNames[i]
            val txtView = TextView(context)
            txtView.text = carName
            txtView.textSize = 30f
            viewLayout.addView(txtView)

            txtView.setOnClickListener {
                if (isLandscape()) {
                    showImageInLandscape(i)
                } else {
                    showImageInPortrait(i)
                }
            }
        }
    }

    private fun showImageInLandscape(index: Int) {

        val fragmentCarImages = FragmentCarImages.newInstance(index)
        val fragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        with(fragmentTransaction) {
            replace(R.id.landCarImage, fragmentCarImages)
            setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            commit()
        }
    }

    private fun showImageInPortrait(index: Int) {
        val fragmentCarImages = FragmentCarImages.newInstance(index)
        val fragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        with(fragmentTransaction) {
            add(R.id.carNamesContainer, fragmentCarImages)
            addToBackStack("")
            setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            commit()
        }
    }


    private fun isLandscape(): Boolean {
        return resources.configuration.orientation ==
                Configuration.ORIENTATION_LANDSCAPE
    }


}