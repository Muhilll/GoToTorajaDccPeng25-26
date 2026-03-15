package org.example.project.screen.profile

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import gototorajaapp.composeapp.generated.resources.Res
import gototorajaapp.composeapp.generated.resources.user
import org.jetbrains.compose.resources.painterResource

object ProfileTab : Tab {

    @Composable
    override fun Content() {
        ProfilePage()
    }

    override val options: TabOptions
        @Composable
        get() {
            val icon = painterResource(Res.drawable.user)

            return remember {
                TabOptions(
                    index = 1u,
                    title = "Profile",
                    icon = icon
                )
            }
        }
}