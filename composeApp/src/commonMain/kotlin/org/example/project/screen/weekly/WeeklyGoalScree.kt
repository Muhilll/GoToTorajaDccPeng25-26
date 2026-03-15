package org.example.project.screen.weekly

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import gototorajaapp.composeapp.generated.resources.Res
import gototorajaapp.composeapp.generated.resources.arrow
import org.example.project.model.Member
import org.example.project.model.Week
import org.jetbrains.compose.resources.painterResource

class WeeklyGoalScree(
    private val week: Week
): Screen{
    @Composable
    override fun Content() {
        WeeklyGoalPage(week = week)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeeklyGoalPage(
    week: Week
){
    val navigator = LocalNavigator.current
    val members = listOf(
        Member(
            name = "Alice",
            contribution = 937.5,
            progress = 0.75f,
            percentText = "75% Complete",
            remaining = "$312.50",
            status = "On Track",
            avatarUrl = "https://i.pravatar.cc/150?img=1"
        ),
        Member(
            "Bob",
            625.0,
            0.50f,
            "50% Complete",
            "$625.00",
            "Action Needed",
            "https://i.pravatar.cc/150?img=2"
        ),
        Member(
            "Chloe",
            1125.0,
            0.90f,
            "90% Complete",
            "$125.00",
            "Almost there!",
            "https://i.pravatar.cc/150?img=3"
        ),
        Member(
            "David",
            562.5,
            0.45f,
            "45% Complete",
            "$687.50",
            "In Progress",
            "https://i.pravatar.cc/150?img=4"
        )
    )

    Column {
        CenterAlignedTopAppBar(
            navigationIcon = {
                IconButton(onClick = {
                    navigator?.pop()
                }) {
                    Icon(
                        painter = painterResource(
                            Res.drawable.arrow
                        ),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp),
                        tint = Color.Black
                    )
                }
            },
            title = {
            }
        )
        Column (
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF6F8F6))
                .padding(16.dp)
        ) {
            TripGoalCard(week = week)

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = "Individual Contributions",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )

                Surface(
                    shape = RoundedCornerShape(20.dp),
                    color = Color(0xFFE5E7EB)
                ) {
                    Text(
                        "4 Members",
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
                    defaultElevation = 1.dp,
                ),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )
            ) {
                LazyColumn(modifier = Modifier.padding(all = 10.dp)) {
                    items(members) { member ->

                        MemberContributionItem(member)

                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }
            }
        }
    }
}

@Composable
@Preview
fun WeeklyGoalPreview(){

    val members = listOf(
        Member(
            name = "Alice",
            contribution = 937.5,
            progress = 0.75f,
            percentText = "75% Complete",
            remaining = "$312.50",
            status = "On Track",
            avatarUrl = "https://i.pravatar.cc/150?img=1"
        ),
        Member(
            "Bob",
            625.0,
            0.50f,
            "50% Complete",
            "$625.00",
            "Action Needed",
            "https://i.pravatar.cc/150?img=2"
        ),
        Member(
            "Chloe",
            1125.0,
            0.90f,
            "90% Complete",
            "$125.00",
            "Almost there!",
            "https://i.pravatar.cc/150?img=3"
        ),
        Member(
            "David",
            562.5,
            0.45f,
            "45% Complete",
            "$687.50",
            "In Progress",
            "https://i.pravatar.cc/150?img=4"
        )
    )

    val week = Week(
        "22 - 28 March 2026",
        937.5,
        0.75f,
        "75% Complete",
        "$312.50",
        "On Track"
    )

    MaterialTheme{
        WeeklyGoalPage(week = week)
    }
}