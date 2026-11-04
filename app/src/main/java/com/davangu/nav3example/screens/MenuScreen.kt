package com.davangu.nav3example.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MenuScreen(goToHome: () -> Unit,
               goToScaffold: (String) -> Unit) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 48.dp)) {
        Button(onClick = { goToHome() }) {
            Text("HOME")
        }
        Button(onClick = { goToScaffold("Hola")}) {
            Text("SCAFFOLD")
        }
    }
}