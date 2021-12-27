package com.example.healm.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.healm.R


val HeadlineText = FontFamily(
    listOf(
        Font(R.font.amerigo)
    )
)

val DescriptionText = FontFamily(
    listOf(
        Font(R.font.avenir_book)
    )
)

val BodyFont = FontFamily(
    listOf(
        Font(R.font.avenir_std_45)
    )
)

val TitleText = FontFamily(
    listOf(
        Font(R.font.janna_bold)
    )
)
// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = BodyFont,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        color = LightGrey
    ),
    h2 = TextStyle(
        fontFamily = TitleText,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    ),
    h1 = TextStyle(
        fontFamily = HeadlineText,
        fontWeight = FontWeight.Bold,
        fontSize = 34.sp
    ),
    body2 = TextStyle(
        fontFamily = DescriptionText,
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