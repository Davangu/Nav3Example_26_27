package com.davangu.nav3example.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(navToDetail: (Int) -> Unit) {
    val scroll = rememberScrollState()
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(vertical = 36.dp, horizontal = 24.dp)
        .verticalScroll(scroll),
        verticalArrangement = Arrangement.spacedBy(16.dp))
    {
        for(i in 1..50) {
            Card(
                modifier = Modifier.height(30.dp)
                    .fillMaxWidth()
                    .border(width = 2.dp, color = Color.Black)
                    .clickable { navToDetail(i) }
            ) {
                Text(modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(8.dp),
                    text = "Item $i")
            }
        }
    }
}