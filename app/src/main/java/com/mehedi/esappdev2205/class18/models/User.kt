package com.mehedi.esappdev2205.class18.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(var name: String, var id: Int, var email: String) : Parcelable
