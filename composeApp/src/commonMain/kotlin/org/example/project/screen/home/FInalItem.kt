package org.example.project.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.example.project.model.Week
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.runtime.remember
import androidx.compose.material3.ripple
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun FinalGoalItemPage(week: Week, onClick: () -> Unit) {
    val scope = rememberCoroutineScope()
    val interactionSource = remember { MutableInteractionSource() }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .clickable(
                interactionSource = interactionSource,
                indication = ripple()
            ) {
                scope.launch {
                    delay(150)
                    onClick()
                }
            }
            .padding(vertical = 4.dp)
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(end = 10.dp)
        ) {

            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {

                Text(
                    week.date,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp
                )
                Text(week.percentText)
            }

            Column(horizontalAlignment = Alignment.End) {

                Text(
                    "$${week.contribution}",
                    fontWeight = FontWeight.Bold,
                )

                Text("PAID", fontSize = 12.sp)
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        LinearProgressIndicator(
            progress = week.progress,
            modifier = Modifier
                .fillMaxWidth()
                .height(6.dp).padding(horizontal = 10.dp),
            color = Color(0xFF22C55E)
        )

        Spacer(modifier = Modifier.height(4.dp))

        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text("Remaining: ${week.remaining}", fontSize = 12.sp)

            Text(week.status, fontSize = 12.sp)
        }

        Spacer(modifier = Modifier.height(5.dp))

        Spacer(
            modifier = Modifier
            .fillMaxWidth()
            .height(0.3.dp)
            .background(Color.Gray)
        )
    }
}