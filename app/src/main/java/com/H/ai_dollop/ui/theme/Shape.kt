package com.H.ai_dollop.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

val Shapes = Shapes(
//    许多形状都是使用 RoundedCornerShape 定义的，它所描述的是圆角矩形。
//    传入的数字会定义角的圆角程度。如果使用 RoundedCornerShape(0.dp)，
//    则矩形没有圆角；如果使用 RoundedCornerShape(50.dp)，
//    角将变为完全圆形。
    small = RoundedCornerShape(50.dp),
    medium = RoundedCornerShape(bottomStart = 32.dp, topEnd = 32.dp)
)