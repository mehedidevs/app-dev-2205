package com.mehedi.esappdev2205.class21CustomRCV

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Image(var imageName: String, var imageUrl: String) : Parcelable


//nnn