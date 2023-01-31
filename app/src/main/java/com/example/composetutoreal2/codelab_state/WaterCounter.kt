package com.example.composetutoreal2.codelab_state

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import com.example.composetutoreal2.ui.theme.ComposeTutorial2Theme


@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun DefaultPreview() {
    ComposeTutorial2Theme {
        CountingWater()
    }
}


@Composable
fun CountingWater(modifier: Modifier = Modifier) {
    var count = 0
    Text(
        text = "You've had $count glasses.",
        modifier = modifier.padding(16.dp)
    )
}