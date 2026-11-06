package com.davangu.nav3example.screens

import android.graphics.Paint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation3.runtime.NavKey

@Composable
fun DetailScreen(id: Int, onBack: () -> Unit) {
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(vertical = 48.dp, horizontal = 24.dp),
        contentAlignment = Alignment.TopCenter) {
        Text("La id seleccionada es: $id",
            fontSize = 40.sp)
        Button(modifier = Modifier.align(Alignment.BottomCenter),
            onClick = { onBack() }){Text("MENU")}
    }
}