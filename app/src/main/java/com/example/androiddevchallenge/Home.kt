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

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androiddevchallenge.model.Plant
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.utils.Screen
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun Home(
    modifier: Modifier = Modifier,
    navigateTo: (Screen) -> Unit,
    viewModel: MainViewModel,
    scaffoldState: ScaffoldState = rememberScaffoldState()
) {
    var selectedScreen by remember { mutableStateOf(Screen.Home) }
    val screens = Screen.values()

    Scaffold(
        scaffoldState = scaffoldState,
        bottomBar = {
            BottomNavigation(
                elevation = 16.dp,
                backgroundColor = MaterialTheme.colors.primary
            ) {
                screens.forEachIndexed { index, item ->
                    BottomNavigationItem(
                        icon = { Icon(item.icon, contentDescription = null) },
                        label = { Text(stringResource(id = item.stringResourceId)) },
                        selected = selectedScreen.ordinal == index,
                        onClick = { selectedScreen = item }
                    )
                }
            }
        }
    ) {
        when (selectedScreen) {
            Screen.Home -> HomeScreen(viewModel = viewModel)
            Screen.Favorites -> FavoritesScreen()
            Screen.Profile -> ProfileScreen()
            Screen.Cart -> CartScreen()
        }
    }
}

@Composable
fun HomeScreen(viewModel: MainViewModel = viewModel()) {

    LazyColumn(Modifier.padding(bottom = 56.dp)) { // Padding bottom the same as the height of navigation
        item {
            Column(
                modifier = Modifier
                    .padding(top = 40.dp, start = 16.dp)
            ) {
                OutlinedTextField(
                    value = viewModel.search,
                    onValueChange = viewModel::setSearchValue,
                    placeholder = {
                        Row {
                            Icon(Icons.Filled.Search, contentDescription = null)
                            Text(
                                modifier = Modifier.padding(start = 8.dp),
                                text = stringResource(id = R.string.search),
                                style = MaterialTheme.typography.body1
                            )
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 16.dp)
                )

                Text(
                    text = stringResource(id = R.string.browse_theme),
                    style = MaterialTheme.typography.h1,
                    modifier = Modifier.paddingFromBaseline(32.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                LazyRow(modifier = Modifier.height(144.dp)) {
                    items(viewModel.plants) { plant ->
                        BrowseThemeCard(plant = plant)
                        Spacer(modifier = Modifier.width(8.dp))
                    }
                }

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = stringResource(id = R.string.list_title),
                        modifier = Modifier.paddingFromBaseline(32.dp),
                        style = MaterialTheme.typography.h1
                    )

                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Filled.FilterList, contentDescription = stringResource(id = R.string.content_description_filter_list))
                    }
                }
            }
        }

        items(viewModel.plants) { plant ->
            ItemRow(plant = plant, viewModel = viewModel)
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(2.dp)
                    .padding(start = 96.dp, end = 16.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun BrowseThemeCard(plant: Plant) {
    Card(
        elevation = 2.dp,
        modifier = Modifier.size(136.dp, 136.dp),
        shape = MaterialTheme.shapes.small
    ) {
        Column {
            CoilImage(
                data = plant.image,
                contentScale = ContentScale.Crop,
                contentDescription = plant.name,
                modifier = Modifier.size(136.dp, 96.dp)
            )
            Text(
                text = plant.name,
                modifier = Modifier
                    .paddingFromBaseline(top = 24.dp)
                    .padding(start = 16.dp),
                style = MaterialTheme.typography.h2
            )
        }
    }
}

@Composable
fun ItemRow(
    plant: Plant,
    viewModel: MainViewModel
) {
    val checkedState = remember { mutableStateOf(viewModel.favorites.contains(plant)) }
    Row(
        modifier = Modifier
            .height(64.dp)
            .padding(horizontal = 16.dp)
    ) {
        CoilImage(
            data = plant.image,
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(64.dp),
            contentDescription = plant.name
        )

        Column(Modifier.padding(start = 16.dp)) {
            Text(
                text = plant.name,
                style = MaterialTheme.typography.h2,
                modifier = Modifier.paddingFromBaseline(top = 24.dp)
            )
            Text(
                text = plant.description,
                style = MaterialTheme.typography.body1,
                modifier = Modifier.paddingFromBaseline(top = 16.dp)
            )

        }

        Spacer(modifier = Modifier.weight(1f))

        Checkbox(
            checked = checkedState.value,
            onCheckedChange = { isChecked ->
                checkedState.value = isChecked
                if (isChecked) viewModel.addFavorite(plant)
                else viewModel.removeFavorite(plant)
            },
            colors = CheckboxDefaults.colors(checkmarkColor = MaterialTheme.colors.background),
            modifier = Modifier.padding(top = 16.dp)
        )
    }
}

@Preview
@Composable
fun HomePreview() {
    MyTheme {
        HomeScreen()
    }
}


