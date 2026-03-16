package org.example.project.screen.budget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.LocalNavigator
import gototorajaapp.composeapp.generated.resources.Res
import gototorajaapp.composeapp.generated.resources.add
import org.jetbrains.compose.resources.painterResource

@Composable
@Preview(showBackground = true)
fun BudgetPage() {
    val navigator = LocalNavigator.current

    Box(){
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF6F8F6))
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            item {
                BudgetSummaryCard()
            }

            item {
                ExpenseHeader()
            }

            item {
                ExpenseItem(
                    title = "Transport",
                    subtitle = "Flights, trains, local taxi",
                    amount = "Rp 3,000,000",
                    percent = "33.3%"
                )
            }

            item {
                ExpenseItem(
                    title = "Accommodation",
                    subtitle = "Hotels and Airbnbs",
                    amount = "Rp 2,500,000",
                    percent = "27.8%"
                )
            }

            item {
                ExpenseItem(
                    title = "Food & Drinks",
                    subtitle = "Meals and street food",
                    amount = "Rp 2,000,000",
                    percent = "22.2%"
                )
            }

            item {
                ExpenseItem(
                    title = "Tourist Tickets",
                    subtitle = "Attractions and tours",
                    amount = "Rp 1,500,000",
                    percent = "16.7%"
                )
            }
        }

        FloatingActionButton(
            onClick = {
                navigator?.push(FormAddBudgetScreen())
            },
            contentColor = Color.White,
            containerColor = Color(0xFF22C55E),
            elevation = FloatingActionButtonDefaults.elevation(5.dp),
            modifier = Modifier.align(Alignment.BottomEnd).padding(all = 20.dp)
        ){
            Icon(
                painter = painterResource(Res.drawable.add),
                contentDescription = null,
                modifier = Modifier.padding(20.dp).size(20.dp),
            )
        }
    }
}