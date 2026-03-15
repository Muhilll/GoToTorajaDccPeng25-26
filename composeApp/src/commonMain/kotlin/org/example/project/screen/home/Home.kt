package org.example.project.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import gototorajaapp.composeapp.generated.resources.Res
import gototorajaapp.composeapp.generated.resources.setting
import org.example.project.model.Week
import org.jetbrains.compose.resources.painterResource
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import gototorajaapp.composeapp.generated.resources.add
import org.example.project.screen.form.FormContributionPeriodScreen
import org.example.project.screen.weekly.WeeklyGoalScree

class HomeScreen : Screen {
    @Composable
    override fun Content() {
        HomePage()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(){
    val weeks = listOf(
        Week(
            "22 - 28 March 2026",
            937.5,
            0.75f,
            "75% Complete",
            "$312.50",
            "On Track"
        ),
        Week(
            "15 - 21 March 2026",
            625.0,
            0.50f,
            "50% Complete",
            "$625.00",
            "Action Needed"
        ),
        Week(
            "8 - 14 March 2026",
            1125.0,
            0.90f,
            "90% Complete",
            "$125.00",
            "Almost there!"
        ),
        Week(
            "1 - 7 March 2026",
            562.5,
            0.45f,
            "45% Complete",
            "$687.50",
            "In Progress"
        )
    )

    val navigator = LocalNavigator.current

    Column() {
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

        Box(){
            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFF6F8F6))
                    .padding(16.dp)
            ) {

                FinalGoalCard()

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = "Weekly Goal",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )

                    Surface(
                        shape = RoundedCornerShape(20.dp),
                        color = Color(0xFFE5E7EB)
                    ) {
                        Text(
                            "12 Weeks",
                            fontSize = 13.sp,
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Card (
                    modifier = Modifier
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 0.5.dp,
                    ),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    )
                ) {
                    LazyColumn(modifier = Modifier.padding(all = 10.dp)) {
                        items(weeks) { week ->

                            FinalGoalItem(
                                week = week,
                                onClick = {navigator?.push(WeeklyGoalScree(week = week))}
                            )

                            Spacer(modifier = Modifier.height(16.dp))
                        }
                    }
                }
            }

            FloatingActionButton(
                onClick = {
                    navigator?.push(FormContributionPeriodScreen())
                },
                contentColor = Color.White,
                containerColor = Color(0xFF22C55E),
                elevation = FloatingActionButtonDefaults.elevation(5.dp),
                modifier = Modifier.align(Alignment.BottomEnd).padding(end = 20.dp, bottom = 40.dp)
            ){
                Icon(
                    painter = painterResource(Res.drawable.add),
                    contentDescription = null,
                    modifier = Modifier.padding(20.dp).size(20.dp),
                )
            }
        }
    }
}

@Composable
@Preview
fun HomePreview(){
    MaterialTheme{
        HomePage()
    }
}