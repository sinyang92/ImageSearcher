package com.sinyang92.imagesearcher.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sinyang92.imagesearcher.ui.screen.SearchImageScreenRoute

@Composable
fun ImageSearcherNavigation() {
    val navController = rememberNavController()

    Scaffold(
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
                        SearchImageScreenRoute()
                    }
                }
            }
        }
    )
}