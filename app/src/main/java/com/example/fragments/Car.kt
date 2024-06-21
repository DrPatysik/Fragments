package com.example.fragments

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Car(val imageIndex:Int, val carName:String):Parcelable {
}