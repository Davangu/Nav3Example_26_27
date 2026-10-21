package com.davangu.nav3example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.davangu.nav3example.navigation.NavigationWrapper
import com.davangu.nav3example.ui.theme.Nav3ExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Nav3ExampleTheme {
                NavigationWrapper()
            }
        }
    }
}