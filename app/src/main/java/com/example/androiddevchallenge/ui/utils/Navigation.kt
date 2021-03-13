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
package com.example.androiddevchallenge.ui.utils

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.androiddevchallenge.R

/*enum class Route {
    Home,
    Favorites,
    Profile,
    Cart
}

sealed class Screen(
    val route: Route,
    @StringRes val stringResourceId: Int,
    val icon: ImageVector
) {
    object Home : Screen(Route.Home, R.string.home, Icons.Filled.Home)
    object Favorites : Screen(Route.Favorites, R.string.Favorite, Icons.Outlined.Favorite)
    object Profile : Screen(Route.Profile, R.string.Profile, Icons.Filled.AccountCircle)
    object Cart : Screen(Route.Cart, R.string.Cart, Icons.Filled.ShoppingCart)
}*/

enum class Screen(@StringRes val stringResourceId: Int, val icon: ImageVector) {
    Home(R.string.home, Icons.Filled.Home),
    Favorites(R.string.favorite, Icons.Outlined.Favorite),
    Profile(R.string.profile, Icons.Filled.AccountCircle),
    Cart(R.string.cart, Icons.Filled.ShoppingCart)
}
