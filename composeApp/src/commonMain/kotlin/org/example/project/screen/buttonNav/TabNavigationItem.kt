package org.example.project.screen.buttonNav

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab

@Composable
fun RowScope.TabNavigationItem(tab: Tab) {

    val tabNavigator = LocalTabNavigator.current

    NavigationBarItem(
        modifier = Modifier.height(70.dp),
        selected = tabNavigator.current == tab,

        onClick = {
            tabNavigator.current = tab
        },

        icon = {
            Icon(
                painter = tab.options.icon!!,
                contentDescription = tab.options.title,
                modifier = Modifier.size(20.dp)
            )
        },

        label = {
            Text(tab.options.title)
        },

        colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color(0xFF22C55E),
                unselectedIconColor = Color.Gray,
                selectedTextColor = Color(0xFF22C55E),
                unselectedTextColor = Color.Gray,
                indicatorColor = Color.Transparent
        )
    )
}