package com.example.hbou

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Film(
    val title: String,
    val genre: String,
    val year: Int,
    val rating: Double,
    val description: String,
    val imageUrl: String
) : Parcelable