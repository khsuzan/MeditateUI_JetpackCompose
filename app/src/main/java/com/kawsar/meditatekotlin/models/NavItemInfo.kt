package com.kawsar.meditatekotlin.models

import androidx.annotation.DrawableRes

data class NavItemInfo(
    val navIndex: NavIndex,
    @DrawableRes val icon:Int,
    val label:String
)
