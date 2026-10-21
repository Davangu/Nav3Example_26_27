package com.davangu.nav3example.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.davangu.nav3example.navigation.Routes.*
import com.davangu.nav3example.screens.DetailScreen
import com.davangu.nav3example.screens.HomeScreen

@Composable
fun NavigationWrapper() {
    val backStack = rememberNavBackStack(Home)
    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeAt(backStack.lastIndex) },
        entryProvider =
            entryProvider {
                entry<Home> {
                    HomeScreen { id ->
                        backStack.add(Detail(id = id))
                    }
                }
                entry<Detail> { key ->
                    DetailScreen(key.id)
                }
            }
    )
}
