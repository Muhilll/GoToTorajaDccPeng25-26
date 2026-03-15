package org.example.project

import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import org.example.project.screen.buttonNav.TabsScreen

@Composable
@Preview
fun App() {
    Navigator(TabsScreen()){ navigator ->
        SlideTransition(navigator)
    }
}