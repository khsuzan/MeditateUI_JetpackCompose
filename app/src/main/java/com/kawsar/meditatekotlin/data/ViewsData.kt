package com.kawsar.meditatekotlin.data

import androidx.compose.ui.graphics.Color
import com.kawsar.meditatekotlin.R
import com.kawsar.meditatekotlin.models.FeaturedInfo
import com.kawsar.meditatekotlin.models.NavIndex
import com.kawsar.meditatekotlin.models.NavItemInfo

object ViewsData{
    val bottomNavs:List<NavItemInfo> = listOf(
        NavItemInfo(NavIndex.HOME, R.drawable.ic_home,"Home"),
        NavItemInfo(NavIndex.MEDITATE, R.drawable.ic_meditate,"Meditate"),
        NavItemInfo(NavIndex.SLEEP, R.drawable.ic_sleep,"Sleep"),
        NavItemInfo(NavIndex.MUSIC, R.drawable.ic_music,"Music"),
        NavItemInfo(NavIndex.PROFILE, R.drawable.ic_profile,"Profile"),
    )
    val chips:List<String> = listOf(
        "Sweet sleep",
        "Insomnia",
        "Depression",
        "Sound Sleep"
    )
    val featuredItems:List<FeaturedInfo> = listOf(
        FeaturedInfo(Color(0xFF11D79B),"Sleep\nmediation",R.drawable.ic_headphone),
        FeaturedInfo(Color(0xFF8F98FD),"Tips for\nsleeping",R.drawable.ic_video),
        FeaturedInfo(Color(0xFFF0BD28),"Nice\nisland",R.drawable.ic_video),
        FeaturedInfo(Color(0xFFF9A27B),"Calming\nsound",R.drawable.ic_headphone),
    )
}