package com.example.wdskills002.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.wdskills002.ui.theme.Wdskills002Theme

@Composable
fun IntroScr(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Green)
    ) {


    }
}

@Preview(showBackground = true)
@Composable
fun IntroPreview() {
    IntroScr()

}