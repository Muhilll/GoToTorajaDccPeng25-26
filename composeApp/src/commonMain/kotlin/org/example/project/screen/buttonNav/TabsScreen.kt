package org.example.project.screen.buttonNav

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import gototorajaapp.composeapp.generated.resources.Res
import gototorajaapp.composeapp.generated.resources.setting
import org.example.project.screen.home.HomeTab
import org.example.project.screen.profile.ProfileTab
import org.jetbrains.compose.resources.painterResource

class TabsScreen : Screen {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {

        TabNavigator(HomeTab) {

            Scaffold(
                topBar = {
                    CenterAlignedTopAppBar(
                        title = {
                            Text(
                                text = "Go To Toraja",
                                fontWeight = FontWeight.Bold,
                                color = Color.Black
                            )
                        },
                        actions = {
                            IconButton(onClick = {}){
                                Icon(
                                    painter = painterResource(
                                        Res.drawable.setting
                                    ),
                                    contentDescription = null,
                                    modifier = Modifier.size(25.dp),
                                    tint = Color.Black
                                )
                            }
                        }
                    )
                },
                bottomBar = {

                    NavigationBar(
                        modifier = Modifier.height(100.dp),
                        containerColor = Color.White
                    ) {
                        TabNavigationItem(HomeTab)
                        TabNavigationItem(ProfileTab)
                    }

                }
            ) { paddingValues ->

                Box(
                    modifier = Modifier.padding(paddingValues)
                ) {
                    CurrentTab()
                }

            }

        }

    }

}