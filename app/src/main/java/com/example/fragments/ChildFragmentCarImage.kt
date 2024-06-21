package com.example.fragments

import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

private const val CHILD_KEY_CAR = "child key car"
class ChildFragmentCarImage : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_child_car_image, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewImageCar = view.findViewById<ImageView>(R.id.imageCar)
        val images = resources.obtainTypedArray(R.array.cars_imgs)
        val textView = view.findViewById<TextView>(R.id.tvCarName)
        val argument = arguments

        if (argument != null) {
            val car = argument.getParcelable<Car>(CHILD_KEY_CAR)

            if (car != null) {
                viewImageCar.setImageResource(images.getResourceId(car.imageIndex, 0))
                textView.text = car.carName
                images.recycle()
            }
            else {
        //TODO если картинку не выбрали,то дефолтная картинка не появляется
                viewImageCar.setImageResource(images.getResourceId(images.getIndex(0),0))
                images.recycle()
            }
        }

        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            viewImageCar.setBackgroundColor(-1)
        } else {
            viewImageCar.setBackgroundColor(-16777216)
            textView.setBackgroundColor(-16777216)
            textView.setTextColor(-1)
            textView.textSize = 35f
        }



    }

    companion object {
        @JvmStatic
        fun newInstance(car:Car?): ChildFragmentCarImage {
            val fragment = ChildFragmentCarImage()
            val bundle = Bundle()
            bundle.putParcelable(CHILD_KEY_CAR,car)

            fragment.arguments = bundle
            return fragment
        }
    }
}