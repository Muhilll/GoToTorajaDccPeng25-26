package org.example.project

import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import cafe.adriel.voyager.navigator.CurrentScreen
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import org.example.project.model.Week
import org.example.project.screen.home.FinalGoal

@Composable
@Preview
fun App() {
    Navigator(FinalGoal()){navigator ->
        SlideTransition(navigator)
    }
}