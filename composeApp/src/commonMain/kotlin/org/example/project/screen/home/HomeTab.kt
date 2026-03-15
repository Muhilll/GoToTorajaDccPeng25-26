package org.example.project.screen.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import gototorajaapp.composeapp.generated.resources.Res
import gototorajaapp.composeapp.generated.resources.home
import org.jetbrains.compose.resources.painterResource

object HomeTab : Tab {

    @Composable
    override fun Content() {
        HomePage()
    }

    override val options: TabOptions
        @Composable
        get() {
            val icon = painterResource(Res.drawable.home)

            return remember {
                TabOptions(
                    index = 0u,
                    title = "Home",
                    icon = icon
                )
            }
        }
}