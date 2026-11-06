package com.davangu.nav3example.navigation

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.davangu.nav3example.navigation.Routes.*
import com.davangu.nav3example.screens.DetailScreen
import com.davangu.nav3example.screens.HomeScreen
import com.davangu.nav3example.screens.MenuScreen
import com.davangu.nav3example.screens.ScaffoldScreen

@Composable
fun NavigationWrapper() {
    val backStack = rememberNavBackStack(Menu)
    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeAt(backStack.lastIndex) },
        entryProvider =
            entryProvider {
                // SIN ARGUMENTOS DE ENTRADA
                entry<Home> {
                    HomeScreen( navToDetail = { id ->
                        backStack.add(Detail(id = id)) }
                    )
                }
                entry<Menu> {
                    MenuScreen(
                        goToHome = { backStack.add(Home) },
                        goToScaffold = { title ->
                            backStack.add(Scaffold(title = title))
                        }
                    )
                }
                // CON ARGUMENTOS DE ENTRADA
                entry<Detail> { key ->
                    DetailScreen(key.id) {
                        backStack.clear()
                        backStack.add(Menu)
                    }
                }

                entry<Scaffold> { key ->
                    ScaffoldScreen(key.title)
                }
            }
    )
}
