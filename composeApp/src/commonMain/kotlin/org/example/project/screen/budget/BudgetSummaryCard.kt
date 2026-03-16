package org.example.project.screen.budget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BudgetSummaryCard() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(2.dp, RoundedCornerShape(20.dp))
            .clip(RoundedCornerShape(20.dp))
            .background(Color.White)
            .padding(16.dp)
    ) {

        Text(
            "Total Estimated Budget",
            color = Color.Gray,
            fontSize = 14.sp
        )

        Spacer(Modifier.height(6.dp))

        Text(
            "Rp 9,000,000",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Column {
                Text("COLLECTED", fontSize = 12.sp, color = Color.Gray)
                Text(
                    "Rp 4,500,000",
                    color = Color(0xFF22C55E),
                    fontWeight = FontWeight.Bold
                )
            }

            Column {
                Text("REMAINING", fontSize = 12.sp, color = Color.Gray)
                Text(
                    "Rp 4,500,000",
                    color = Color.DarkGray,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Spacer(Modifier.height(16.dp))

        Text(
            "Fund Collection Progress",
            fontSize = 14.sp
        )

        Spacer(Modifier.height(6.dp))

        LinearProgressIndicator(
            progress = 0.5f,
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
                .clip(RoundedCornerShape(50)),
            color = Color(0xFF13EC5B),
        )
    }
}