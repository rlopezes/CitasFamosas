package com.example.citasfamosas.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Cita (
    @StringRes val frase: Int,
    @StringRes val autor: Int,
    @DrawableRes val imagen: Int
)