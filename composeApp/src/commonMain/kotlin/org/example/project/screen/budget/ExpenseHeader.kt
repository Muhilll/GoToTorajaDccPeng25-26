package org.example.project.screen.budget

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun ExpenseHeader() {

    Row (
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Text(
            "Expense Breakdown",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            "View Details",
            color = Color(0xFF22C55E),
            fontWeight = FontWeight.Medium
        )
    }
}