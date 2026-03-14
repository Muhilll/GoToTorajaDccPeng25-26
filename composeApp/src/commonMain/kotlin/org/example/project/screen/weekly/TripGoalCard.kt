package org.example.project.screen.weekly

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.example.project.model.Member
import org.example.project.model.Week

@Composable
fun TripGoalCard(week: Week) {

    Card(
        shape = RoundedCornerShape(20.dp),
        border = BorderStroke(
            width = 0.5.dp,
            color = Color(0xFF22C55E)
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFD1FAE5)
        ),
        modifier = Modifier.fillMaxWidth(),
    ) {

        Column(
            modifier = Modifier.padding(20.dp)
        ) {

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {

                Column {
                    Text("${week.date} Goal")

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        "$5,000",
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Text(
                    "65%",
                    color = Color(0xFF22C55E),
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            LinearProgressIndicator(
                progress = 0.65f,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp),
                color = Color(0xFF22C55E)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text("$3,250 raised")
                Text("$1,750 left")
            }
        }
    }
}