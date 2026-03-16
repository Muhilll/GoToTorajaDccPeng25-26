package org.example.project.screen.budget

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import gototorajaapp.composeapp.generated.resources.Res
import gototorajaapp.composeapp.generated.resources.wallet
import org.jetbrains.compose.resources.painterResource

object BudgetTab : Tab {
    @Composable
    override fun Content() {
        BudgetPage()
    }

    override val options: TabOptions
        @Composable
        get() {
            val icon = painterResource(Res.drawable.wallet)

            return remember {
                TabOptions(
                    index = 2u,
                    title = "Budget",
                    icon = icon
                )
            }
        }
}