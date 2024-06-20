package com.mohmmed.mosa.eg.news.presention.common

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Stable
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp


fun Modifier.animatedGradient(
    primaryColor: Color,
    containerColor: Color
): Modifier = composed {
    var size by remember { mutableStateOf(IntSize.Zero) }
    val transition = rememberInfiniteTransition(label = "")
    val colors = listOf(
        primaryColor,
        containerColor,
        primaryColor
    )
    val offsetXAnimation by transition.animateFloat(
        initialValue = -size.width.toFloat(),
        targetValue = size.width.toFloat(),
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1500, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ), label = "gradientAnimation"
    )
    background(
        brush = Brush.linearGradient(
            colors = colors,
            start = Offset(x = offsetXAnimation, y = 0f),
            end = Offset(x = offsetXAnimation + size.width.toFloat(), y = size.height.toFloat())
        ),
        shape = RoundedCornerShape(24.dp)
    )
        .onGloballyPositioned {
            size = it.size
        }
}


