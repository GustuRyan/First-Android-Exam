package com.example.myapplication

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Furnitures(
    val name: String?,
    val description: String?,
    val category: String?,
    val price: String?,
    val photo: Int?,
) : Parcelable

