package com.kawsar.meditatekotlin.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.kawsar.meditatekotlin.R

// Set of Material typography styles to start with
val Typography by lazy {
    Typography(
        body1 = TextStyle(
            fontFamily = MONTSERRAT,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        )
        /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
    )
}
val KODCHASAN = FontFamily(
    Font(
        R.font.kodchasan_regular,
        style = FontStyle.Normal,
        weight = FontWeight.Normal
    ),
    Font(
        R.font.kotchasan_italic,
        style = FontStyle.Italic,
        weight = FontWeight.Normal
    ),
    Font(
        R.font.kodchasan_light,
        style = FontStyle.Normal,
        weight = FontWeight.Light
    ),
    Font(
        R.font.kodchasan_medium,
        style = FontStyle.Normal,
        weight = FontWeight.Medium
    ),
    Font(
        R.font.kodchasan_semibold,
        style = FontStyle.Normal,
        weight = FontWeight.SemiBold
    ),
    Font(
        R.font.kodchasan_bold,
        style = FontStyle.Normal,
        weight = FontWeight.Bold
    ),

)
val MONTSERRAT = FontFamily(
    Font(
        R.font.montserrat_regular,
        style = FontStyle.Normal,
        weight = FontWeight.Normal
    ),
    Font(
        R.font.montserrat_italic,
        style = FontStyle.Italic,
        weight = FontWeight.Normal
    ),
    Font(
        R.font.montserrat_light,
        style = FontStyle.Normal,
        weight = FontWeight.Light
    ),
    Font(
        R.font.montserrat_medium,
        style = FontStyle.Normal,
        weight = FontWeight.Medium
    ),
    Font(
        R.font.montserrat_sermibold,
        style = FontStyle.Normal,
        weight = FontWeight.SemiBold
    ),
    Font(
        R.font.montserrat_bold,
        style = FontStyle.Normal,
        weight = FontWeight.Bold
    ),

)