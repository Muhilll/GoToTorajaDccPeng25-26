package org.example.project.screen.buttonNav
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import gototorajaapp.composeapp.generated.resources.Res
import gototorajaapp.composeapp.generated.resources.setting
import kotlinx.coroutines.launch
import org.example.project.screen.budget.BudgetTab
import org.example.project.screen.home.HomeTab
import org.example.project.screen.profile.ProfileTab
import org.example.project.screen.setting.SettingsScreen
import org.jetbrains.compose.resources.painterResource

class TabsScreen : Screen {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        val tabs = listOf(HomeTab, ProfileTab, BudgetTab)

        val pagerState = rememberPagerState(
            initialPage = 0,
            pageCount = { tabs.size }
        )

        val scope = rememberCoroutineScope()

        Scaffold(

            topBar = {
                CenterAlignedTopAppBar(
                    title = {
                        Text(
                            text = "Go To Toraja",
                            fontWeight = FontWeight.Bold
                        )
                    },
                    actions = {
                        IconButton(onClick = {
                            navigator?.push(SettingsScreen())
                        }) {
                            Icon(
                                painter = painterResource(Res.drawable.setting),
                                contentDescription = null,
                                modifier = Modifier.padding(7.dp)
                            )
                        }
                    }
                )
            },

            bottomBar = {

                NavigationBar(containerColor = Color.White) {

                    tabs.forEachIndexed { index, tab ->

                        NavigationBarItem(
                            modifier = Modifier.height(70.dp),

                            selected = pagerState.currentPage == index,

                            onClick = {
                                scope.launch {
                                    pagerState.animateScrollToPage(index)
                                }
                            },

                            icon = {
                                Icon(
                                    painter = tab.options.icon!!,
                                    contentDescription = tab.options.title,
                                    modifier = Modifier.size(20.dp)
                                )
                            },

                            label = { Text(tab.options.title) },

                            colors = NavigationBarItemDefaults.colors(
                                selectedIconColor = Color(0xFF22C55E),
                                unselectedIconColor = Color.Gray,
                                selectedTextColor = Color(0xFF22C55E),
                                unselectedTextColor = Color.Gray,
                                indicatorColor = Color.Transparent
                            )
                        )
                    }
                }
            }

        ) { paddingValues ->

            HorizontalPager(
                state = pagerState,
                modifier = Modifier.padding(paddingValues)
            ) { page ->

                tabs[page].Content()

            }
        }
    }
}