/*
 * Copyright (c) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.mycity.ui

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mycity.R
import com.example.mycity.data.DataProvider
import com.example.mycity.model.CoffeeInfo
import com.example.mycity.model.District
import com.example.mycity.ui.theme.MyCityTheme
import com.example.mycity.utils.CoffeeContentType

/**
 * Main composable that serves as container
 * which displays content according to [uiState] and [windowSize]
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCityApp(
    windowSize: WindowWidthSizeClass,
) {
    val viewModel: CoffeeViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsState()
    val contentType = when (windowSize) {
        WindowWidthSizeClass.Compact,
        WindowWidthSizeClass.Medium -> CoffeeContentType.ListOnly
        WindowWidthSizeClass.Expanded -> CoffeeContentType.ListAndDetail
        else -> CoffeeContentType.ListOnly
    }

    Scaffold(
        topBar = {
            MyCityAppBar(
                isShowingListPage = uiState.isShowingListPage,
                onBackButtonClick = { viewModel.navigateToListPage() },
                windowSize = windowSize
            )
        }
    ) { innerPadding ->
        if (contentType == MyCityContentType.ListAndDetail) {
            MyCityListAndDetail(
                sports = uiState.sportsList,
                selectedSport = uiState.currentSport,
                onClick = {
                    viewModel.updateCurrentSport(it)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding((innerPadding))
            )
        } else {
            if (uiState.isShowingListPage) {
                MyCityList(
                    sports = uiState.sportsList,
                    onClick = {
                        viewModel.updateCurrentSport(it)
                        viewModel.navigateToDetailPage()
                    },
                    modifier = Modifier.padding((innerPadding))
                )
            } else {
                MyCityDetail(
                    selectedSport = uiState.currentSport,
                    modifier = Modifier.padding((innerPadding)),
                    onBackPressed = {
                        viewModel.navigateToListPage()
                    }
                )
            }
        }
    }
}


/**
 * Composable that displays the topBar and displays back button if back navigation is possible.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCityAppBar(
    onBackButtonClick: () -> Unit,
    isShowingDistrictListPage: Boolean,
    isShowingCoffeeListPage: Boolean,
    isShowingCoffeeDetailPage: Boolean,
    windowSize: WindowWidthSizeClass,
    modifier: Modifier = Modifier
) {
    val showDetailPageFlag = windowSize != WindowWidthSizeClass.Expanded && !isShowingCoffeeDetailPage
    val showCoffeeListPageFlag = if(windowSize != WindowWidthSizeClass.Expanded) isShowingCoffeeListPage else !isShowingCoffeeListPage
    TopAppBar(
        title = {
            Text(text =
            if (showDetailPageFlag) {
                stringResource(R.string.detail_fragment_label)
            } else if (showCoffeeListPageFlag) {
                stringResource(R.string.list_coffee_fragment_label)
            } else {
                stringResource(R.string.list_district_fragment_label)
            },
                fontWeight = FontWeight.Bold
            )
        },
        navigationIcon = if (showDetailPageFlag || showCoffeeListPageFlag ) {
            {
                IconButton(onClick = onBackButtonClick) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        } else {
            { Box() {} }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary,
            navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
            actionIconContentColor = MaterialTheme.colorScheme.onPrimary
        ),
        modifier = modifier
    )
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
private fun MyCityListItem(
    sport: Sport,
    onItemClick: (Sport) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        elevation = CardDefaults.cardElevation(),
        modifier = modifier,
        shape = RoundedCornerShape(dimensionResource(R.dimen.card_corner_radius)),
        onClick = { onItemClick(sport) }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .size(dimensionResource(R.dimen.card_image_height))
        ) {
            MyCityListImageItem(
                sport = sport,
                modifier = Modifier.size(dimensionResource(R.dimen.card_image_height))
            )
            Column(
                modifier = Modifier
                    .padding(
                        vertical = dimensionResource(R.dimen.padding_small),
                        horizontal = dimensionResource(R.dimen.padding_medium)
                    )
                    .weight(1f)
            ) {
                Text(
                    text =  stringResource(sport.titleResourceId),
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(bottom = dimensionResource(R.dimen.card_text_vertical_space))
                )
                Text(
                    text = stringResource(sport.subtitleResourceId),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.secondary,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 3
                )
                Spacer(Modifier.weight(1f))
                Row {
                    Text(
                        text = pluralStringResource(R.plurals.player_count_caption, sport.playerCount, sport.playerCount),
                        style = MaterialTheme.typography.bodySmall
                    )
                    Spacer(Modifier.weight(1f))
                    if (sport.olympic) {
                        Text(
                            text = stringResource(R.string.olympic_caption),
                            style = MaterialTheme.typography.labelMedium
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun MyCityListImageItem(sport: Sport, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
    ) {
        Image(
            painter = painterResource(sport.imageResourceId),
            contentDescription = null,
            alignment = Alignment.Center,
            contentScale = ContentScale.FillWidth,
        )
    }
}

@Composable
private fun MyCityList(
    sports: List<Sport>,
    onClick: (Sport) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        contentPadding = PaddingValues(dimensionResource(R.dimen.padding_medium)),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium)),
        modifier = modifier
    ) {
        items(sports, key = { sport -> sport.id }) { sport ->
            MyCityListItem(
                sport = sport,
                onItemClick = onClick
            )
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
private fun MyCityDetail(
    selectedSport: Sport,
    onBackPressed: () -> Unit,
    modifier: Modifier = Modifier
) {
    BackHandler {
        onBackPressed()
    }
    val scrollState = rememberScrollState()

    Box(
        modifier = modifier
            .verticalScroll(state = scrollState)
    ) {
        Column {
            Box {
                Box() {
                    Image(
                        painter = painterResource(selectedSport.sportsImageBanner),
                        contentDescription = null,
                        alignment = Alignment.TopCenter,
                        contentScale = ContentScale.FillWidth,
                    )
                }
                Column(
                    Modifier
                        .align(Alignment.BottomStart)
                        .fillMaxWidth()
                        .background(
                            Brush.verticalGradient(
                                listOf(Color.Transparent, MaterialTheme.colorScheme.scrim),
                                0f,
                                400f
                            )
                        )
                ) {

                    Text(
                        text = stringResource(selectedSport.titleResourceId),
                        style = MaterialTheme.typography.headlineLarge,
                        color = MaterialTheme.colorScheme.inverseOnSurface,
                        modifier = Modifier
                            .padding(horizontal = dimensionResource(R.dimen.padding_small))
                    )
                    Row(
                        modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
                    ) {
                        Text(
                            text = pluralStringResource(R.plurals.player_count_caption, selectedSport.playerCount, selectedSport.playerCount),
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.inverseOnSurface,
                        )
                        Spacer(Modifier.weight(1f))
                        Text(
                            text = stringResource(R.string.olympic_caption),
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.inverseOnSurface,
                        )
                    }
                }
            }
            Text(
                text = stringResource(selectedSport.sportDetails),
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(
                    vertical = dimensionResource(R.dimen.padding_detail_content_vertical),
                    horizontal = dimensionResource(R.dimen.padding_detail_content_horizontal)
                )
            )
        }
    }
}

@Composable
private fun MyCityListAndDetail(
    sports: List<Sport>,
    selectedSport: Sport,
    onClick: (Sport) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
    ) {
        MyCityList(
            sports = sports,
            modifier = Modifier.weight(2f),
            onClick = onClick
        )
        val activity = (LocalContext.current as Activity)
        MyCityDetail(
            selectedSport = selectedSport,
            modifier = Modifier.weight(3f),
            onBackPressed = { activity.finish() }
        )
    }
}

@Preview()
@Composable
fun MyCityListItemPreview() {
    MyCityTheme {
        MyCityListItem(
            sport = LocalMyCityDataProvider.defaultSport,
            onItemClick = {}
        )
    }
}

@Preview()
@Composable
fun MyCityListPreview() {
    MyCityTheme() {
        Surface {
            MyCityList(
                sports = LocalMyCityDataProvider.getMyCityData(),
                onClick = {}
            )
        }
    }
}

@Preview()
@Composable
fun MyCityListAndDetailsPreview() {
    MyCityTheme() {
        Surface {
            MyCityListAndDetail(
                sports = LocalMyCityDataProvider.getMyCityData(),
                selectedSport = LocalMyCityDataProvider.getMyCityData().getOrElse(0) {
                    LocalMyCityDataProvider.defaultSport
                },
                onClick = {},
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
