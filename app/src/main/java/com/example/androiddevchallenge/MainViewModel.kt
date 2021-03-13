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
package com.example.androiddevchallenge

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.model.Plant

class MainViewModel : ViewModel() {

    var search by mutableStateOf("")
        private set

    fun setSearchValue(text: String) {
        search = text
    }

    var plants by mutableStateOf(
        listOf(
            Plant(
                "Desert chic",
                "https://images.pexels.com/photos/2132227/pexels-photo-2132227.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260",
                "This is a description"
            ),
            Plant(
                "Tiny terrariums",
                "https://images.pexels.com/photos/1400375/pexels-photo-1400375.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260",
                "This is a description"
            ),
            Plant(
                "Jungle vibe",
                "https://images.pexels.com/photos/5699665/pexels-photo-5699665.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                "This is a description"
            ),
            Plant(
                "Easy care",
                "https://images.pexels.com/photos/6208086/pexels-photo-6208086.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                "This is a description"
            ),
            Plant(
                "Statements",
                "https://images.pexels.com/photos/3511755/pexels-photo-3511755.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                "This is a description"
            ),
            Plant(
                "Monstera",
                "https://images.pexels.com/photos/3097770/pexels-photo-3097770.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                "This is a description"
            ),
            Plant(
                "Aglaonema",
                "https://images.pexels.com/photos/4751978/pexels-photo-4751978.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                "This is a description"
            ),
            Plant(
                "Peace lily",
                "https://images.pexels.com/photos/4425201/pexels-photo-4425201.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                "This is a description"
            ),
            Plant(
                "Fiddle leaf",
                "https://images.pexels.com/photos/6208087/pexels-photo-6208087.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                "This is a description"
            ),
            Plant(
                "Snake plant",
                "https://images.pexels.com/photos/2123482/pexels-photo-2123482.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                "This is a description"
            ),
            Plant(
                "Pothos",
                "https://images.pexels.com/photos/1084199/pexels-photo-1084199.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                "This is a description"
            )
        )
    )
        private set

    var favorites by mutableStateOf(mutableListOf<Plant>())
        private set

    fun addFavorite(plant: Plant) {
        favorites.add(plant)
        Log.d("MainViewModel", "favorites size: ${favorites.size}, list: $favorites")
    }

    fun removeFavorite(plant: Plant) {
        favorites.remove(plant)
        Log.d("MainViewModel", "favorites size: ${favorites.size}, list: $favorites")
    }
}
