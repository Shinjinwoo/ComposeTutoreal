package com.example.composetutoreal2.codelab_state

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.composetutoreal2.ui.theme.ComposeTutorial2Theme

@Composable
fun WellnessScreen (modifier: Modifier = Modifier) {
    CountingWater(modifier)
}

@Preview(showBackground = true)
@Composable
fun WellnessScreenPreview() {
    ComposeTutorial2Theme {
        WellnessScreen()
    }
}
