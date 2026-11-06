package com.davangu.nav3example.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ScaffoldScreen(title:String) {
    var index by rememberSaveable { mutableIntStateOf(-1) }
    Scaffold(
        topBar = { if(index == 1) MyTopAppBar(title) },
        content = { innerPadding ->
            MyContent(innerPadding, index)
        },
        //bottomBar = { MyBottomNavigation(index){ if(index == it) index = -1 else index = it } },
        bottomBar = { MyBottomNavigation(
            index = index,
            onIconPressed = { if(index == it) index = -1 else index = it }
        ) },
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {  }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(title: String) {
    TopAppBar(
        title = { Text(title) },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.LightGray),
        navigationIcon = {
            IconButton(onClick = { }) {
                Icon(
                    Icons.Filled.Menu,
                    contentDescription = "Desc")
            }
        },
        actions = {
            IconButton(onClick = {}) {
                Icon(Icons.Filled.Add,
                    contentDescription = "Desc")
            }
            IconButton(onClick = {}) {
                Icon(Icons.Filled.Close,
                    contentDescription = "Desc")
            }
        }
    )
}

@Composable
fun MyBottomNavigation(index: Int, onIconPressed: (Int) -> Unit) {
    NavigationBar( containerColor = Color.Red,
        contentColor = Color.White
    ) {
        NavigationBarItem(
            selected = index == 0,
            onClick = { onIconPressed(0) },
            icon = { Icon(imageVector = Icons.Default.Home,
                contentDescription = "Home Icon") },
            label = { Text("Home") }
        )
        NavigationBarItem(
            selected = index == 1,
            onClick = { onIconPressed(1) },
            icon = { Icon(imageVector = Icons.Default.Favorite,
                contentDescription = "Fav Icon") },
            label = { Text("FAV") }
        )
        NavigationBarItem(
            selected = index == 2,
            onClick = { onIconPressed(2) },
            icon = { Icon(imageVector = Icons.Default.Person,
                contentDescription = "Person Icon") },
            label = { Text("Person") }
        )
    }
}

@Composable
fun MyContent(innerPadding: PaddingValues, index: Int) {
    when (index) {
        0 -> Box(modifier = Modifier.fillMaxSize().background(Color.Blue))
        1 -> Box(modifier = Modifier.fillMaxSize().background(Color.Yellow))
        2 -> {
            val colors = listOf(
                Color(0xFFffd7d7.toInt()),
                Color(0xFFffe9d6.toInt()),
                Color(0xFFfffbd0.toInt()),
                Color(0xFFe3ffd9.toInt()),
                Color(0xFFd0fff8.toInt())
            )
            Column(
                modifier = Modifier
                    .padding(innerPadding)
            ) {
                for (i in 1..20) {
                    Box(
                        Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .background(colors[i % colors.size])
                    ) { Text(text = "Fila $i") }
                }
            }
        }
        else -> Box(modifier = Modifier.fillMaxSize().background(Color.Green))
    }
}