package com.example.citasfamosas.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.citasfamosas.R

val DancingScript = FontFamily(
    Font(R.font.dancing_script_regular),
    Font(R.font.dancing_script_bold, FontWeight.Bold)
)

val PlayFairDisplay = FontFamily(
    Font(R.font.playfair_display_regular),
    Font(R.font.playfair_display_bold, FontWeight.Bold)
)

// Set of Material typography styles to start with
val Typography = Typography(

    displayLarge = TextStyle(
        fontFamily = DancingScript,
        fontWeight = FontWeight.Bold,
        fontSize = 40.sp
    ),
    displayMedium = TextStyle(
        fontFamily = DancingScript,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp
    ),
    labelSmall = TextStyle(
        fontFamily = PlayFairDisplay,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = PlayFairDisplay,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    )

    /* Other default text styles to override
     bodyLarge = TextStyle(
         fontFamily = FontFamily.Default,
         fontWeight = FontWeight.Normal,
         fontSize = 16.sp,
         lineHeight = 24.sp,
         letterSpacing = 0.5.sp
     ),
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
     */
)