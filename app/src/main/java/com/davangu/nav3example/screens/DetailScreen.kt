package com.davangu.nav3example.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DetailScreen(id:Int) {
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(vertical = 48.dp, horizontal = 24.dp),
        contentAlignment = Alignment.TopCenter) {
        Text("La id seleccionada es: $id",
            fontSize = 40.sp)
    }
}