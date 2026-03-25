package com.sinyang92.imagesearcher

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.sinyang92.design.theme.ImageSearcherTheme
import com.sinyang92.imagesearcher.ui.navigation.ImageSearcherNavigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ImageSearcherTheme {
                ImageSearcherNavigation()
            }
        }
    }
}