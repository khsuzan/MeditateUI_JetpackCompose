package com.kawsar.meditatekotlin.models

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color

data class FeaturedInfo(
    val backgroundColor:Color,
    val title:String,
    @DrawableRes val icon:Int
)
