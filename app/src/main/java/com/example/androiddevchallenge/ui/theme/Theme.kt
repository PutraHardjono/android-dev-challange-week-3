/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val Pink100 = Color(0xFFFFF1F1)
private val Pink900 = Color (0xFF3F2C2C)
private val White850 = Color (0xD9FFFFFF)
private val Gray = Color(0xFF232323)

private val Green900 = Color (0xFF2D3B2D)
private val Green300 = Color (0xFFB8C9B8)
private val White150 = Color (0x26FFFFFF)

private val DarkColorPalette = darkColors(
    primary = Green900,
    secondary = Green300,
    background = Gray,
    surface = White150,
    onPrimary = Color.White,
    onSecondary = Gray,
    onBackground = Color.White,
    onSurface = White850
)

private val LightColorPalette = lightColors(
    primary = Pink100,
    secondary = Pink900,
    background = Color.White,
    surface = White850,
    onPrimary = Gray,
    onSecondary = Color.White,
    onBackground = Gray,
    onSurface = Gray
)

@Composable
fun MyTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}
