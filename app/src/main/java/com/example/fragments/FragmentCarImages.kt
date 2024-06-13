package com.example.fragments

import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.view.VelocityTrackerCompat.recycle


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
            val indexImageCar = it.getInt(KEY_INDEX)
            val viewImageCar = view.findViewById<ImageView>(R.id.imageCar)
            val images = resources.obtainTypedArray(R.array.cars_imgs)
            viewImageCar.setImageResource(images.getResourceId(indexImageCar,0))
            images.recycle()

            if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){
                viewImageCar.setBackgroundColor(-1)
            }
        }

    }

    companion object {
        const val KEY_INDEX = "index"
        @JvmStatic
        fun newInstance(index:Int): FragmentCarImages {
            val fragment = FragmentCarImages()
            val bundle = Bundle()
                bundle.putInt(KEY_INDEX,index)

            fragment.arguments = bundle
            return fragment
            }
    }
}