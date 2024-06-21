package com.example.fragments

import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

private const val CURRENT_CAR = "currentCar"

class FragmentCarImages : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_car_images, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val argument = arguments
        argument?.let {
            val car = it.getParcelable<Car>(CURRENT_CAR)

            /*val textView = view.findViewById<TextView>(R.id.tvCarName_placeForChild)
            textView.text = car?.carName*/

//TODO надо ли делить на две ориентации?
            if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
                /*textView.setBackgroundColor(-16777216)
                textView.setTextColor(-1)
                textView.textSize = 35f*/
                // }

                childFragmentManager
                    .beginTransaction()
                    .addToBackStack("")
                    .replace(
                        R.id.imageCar_placeForChildFr,
                        ChildFragmentCarImage.newInstance(car)
                    )
                    .commit()
            }
            else{
                requireActivity().supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.landCarImage,
                        ChildFragmentCarImage.newInstance(car))
                    .replace(R.id.carNamesContainer,FragmentCarNames())
                    .commit()
            }

            /*val viewImageCar = view.findViewById<ImageView>(R.id.imageCar_placeForChild)
            val images = resources.obtainTypedArray(R.array.cars_imgs)
            viewImageCar.setImageResource(images.getResourceId(car?.imageIndex?:0,0))
            images.recycle()*/


            /*if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){
                viewImageCar.setBackgroundColor(-1)
            }
            else{
                viewImageCar.setBackgroundColor(-16777216)
                textView.setBackgroundColor(-16777216)
                textView.setTextColor(-1)
                textView.textSize = 35f
            }*/
        }

    }

    companion object {
        @JvmStatic
        fun newInstance(car: Car?): FragmentCarImages {
            val fragment = FragmentCarImages()
            val bundle = Bundle()
            bundle.putParcelable(CURRENT_CAR, car)

            fragment.arguments = bundle
            return fragment
        }
    }
}