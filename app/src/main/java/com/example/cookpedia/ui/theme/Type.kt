package com.example.cookpedia.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.cookpedia.R


val OceanwideFont = FontFamily(
    Font(R.font.oceanwide_semibold, FontWeight.Normal),
    Font(R.font.oceanwide_semibold, FontWeight.Bold),
)

val UrbanistFont = FontFamily(
    Font(R.font.urbanist_regular, FontWeight.Normal),
    Font(R.font.urbanist_bold, FontWeight.Bold),
    Font(R.font.urbanist_thin, FontWeight.W100),
    Font(R.font.urbanist_extralight, FontWeight.W200),
    Font(R.font.urbanist_light, FontWeight.W300),
    Font(R.font.urbanist_regular, FontWeight.W400),
    Font(R.font.urbanist_medium, FontWeight.W500),
    Font(R.font.urbanist_semibold, FontWeight.W600),
    Font(R.font.urbanist_bold, FontWeight.W700),
    Font(R.font.urbanist_extrabold, FontWeight.W800),
    Font(R.font.urbanist_black, FontWeight.W900)
)

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = UrbanistFont,
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