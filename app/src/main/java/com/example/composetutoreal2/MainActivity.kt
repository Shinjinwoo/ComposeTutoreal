@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.example.composetutoreal2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.composetutoreal2.codelab_layout.FavoriteCollectionsGrid
import com.example.composetutoreal2.codelab_layout.HomeScreen
import com.example.composetutoreal2.codelab_layout.SootheBottomNavigation
import com.example.composetutoreal2.ui.theme.ComposeTutorial2Theme

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeTutorial2Theme {
                Scaffold(
                    bottomBar = { SootheBottomNavigation() }
                ) { padding ->
                    HomeScreen(Modifier.padding(padding))
                }
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun DefaultPreview() {
    ComposeTutorial2Theme {
        FavoriteCollectionsGrid()
    }
}




