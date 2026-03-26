package com.sinyang92.imagesearcher.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.sinyang92.design.R
import com.sinyang92.feature.searchimage.ui.resultscreen.ResultScreenRoute
import com.sinyang92.feature.searchimage.ui.searchscreen.SearchImageScreenRoute

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ImageSearcherNavigation() {
    val navController = rememberNavController()

    val navBackStackEntry by navController.currentBackStackEntryAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    if (navBackStackEntry?.destination?.hasRoute<SearchImageResultScreen>() == true) {
                        IconButton(
                            onClick = { navController.navigateUp() }
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.ic_back),
                                contentDescription = "back"
                            )
                        }
                    }
                }
            )
        },
        content = { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.White)
                    .padding(innerPadding)
            ) {
                NavHost(
                    navController = navController,
                    startDestination = SearchImageScreen
                ) {
                    composable<SearchImageScreen> {
                        SearchImageScreenRoute(
                            onSearchClicked = { query ->
                                navController.navigate(SearchImageResultScreen(query = query))
                            }
                        )
                    }

                    composable<SearchImageResultScreen> {
                        ResultScreenRoute(
                            navigateUp = {
                                navController.navigateUp()
                            }
                        )
                    }
                }
            }
        }
    )
}