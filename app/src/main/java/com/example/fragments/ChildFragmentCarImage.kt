package com.example.fragments

import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

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

        val viewImageCar = (view.findViewById<View>(R.id.imageCar) as ImageView)
        val argument = arguments
        argument?.let {
            val car = it.getParcelable<Car>(CHILD_KEY_CAR)
            val images = resources.obtainTypedArray(R.array.cars_imgs)

            if (car != null){
                viewImageCar.setImageResource(images.getResourceId(car.imageIndex,0))
                images.recycle()
            }
            else{
                viewImageCar.setImageResource(images.getResourceId(0,0))
                images.recycle()
            }

            if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){
                viewImageCar.setBackgroundColor(-1)
            }
            else{
                viewImageCar.setBackgroundColor(-16777216)
                }

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