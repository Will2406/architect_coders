package com.ac.pokemonapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.ac.pokemonapp.R

val NeuePlak = FontFamily(
    Font(R.font.neue_plak_extra_black, FontWeight.ExtraBold),
    Font(R.font.neue_plak_regular, FontWeight.Normal),
    Font(R.font.neue_plak_text_light, FontWeight.Light),
    Font(R.font.neue_plak_text_semi_bold, FontWeight.SemiBold),
)

val Typography = Typography(
    titleMedium = TextStyle(
        fontFamily = NeuePlak,
        fontWeight = FontWeight.ExtraBold
    ),
    bodyMedium = TextStyle(
        fontFamily = NeuePlak,
        fontWeight = FontWeight.Normal
    ),
    bodyLarge = TextStyle(
        fontFamily = NeuePlak,
        fontWeight = FontWeight.Light
    ),
    displayMedium = TextStyle(
        fontFamily = NeuePlak,
        fontWeight = FontWeight.SemiBold
    ),
)

// Set of Material typography styles to start with
/* val Typography = Typography(
   bodyLarge = TextStyle(
       fontFamily = FontFamily.Default,
       fontWeight = FontWeight.Normal,
       fontSize = 16.sp,
       lineHeight = 24.sp,
       letterSpacing = 0.5.sp
   )
  Other default text styles to override
   titleLarge = TextStyle(
       fontFamily = FontFamily.Default,
       fontWeight = FontWeight.Normal,
       fontSize = 22.sp,
       lineHeight = 28.sp,
       letterSpacing = 0.sp
   ),
   labelSmall = TextStyle(
       fontFamily = FontFamily.Default,
       fontWeight = FontWeight.Medium,
       fontSize = 11.sp,
       lineHeight = 16.sp,
       letterSpacing = 0.5.sp
   )

)*/