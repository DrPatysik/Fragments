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

    private var car :Car? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_car_names, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        car = savedInstanceState?.getParcelable(CURRENT_CAR) as Car?
        initArray(view)
    }

    private fun initArray(view: View) {
        val viewLayout = view as LinearLayout
        val carNames = resources.getStringArray(R.array.retro_cars_name)

        for (i in carNames.indices) {
            val carName = carNames[i]
            val txtView = TextView(context)
            txtView.text = carName
            txtView.textSize = 30f
            viewLayout.addView(txtView)

            txtView.setOnClickListener {
                car = Car(i , carName)
               // chooseOrientation(car)
               // Bundle().putParcelable(CURRENT_CAR,car)
              // private fun chooseOrientation(car1:Car?){
                   if (isLandscape()) {
                       showImageInLandscape(car)
                   } else {
                       showImageInPortrait(car)
                   }
               }

            }
        }
    //}



    private fun showImageInLandscape(car1:Car?) {

        val fragmentCarImages = FragmentCarImages.newInstance(car)
        val fragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        with(fragmentTransaction) {
            replace(R.id.landCarImage, fragmentCarImages)
            setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            commit()
        }
    }

    private fun showImageInPortrait(car1: Car?) {
        val fragmentCarImages = FragmentCarImages.newInstance(car)
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

    companion object{
        private const val CURRENT_CAR = "currentCar"
    }

}