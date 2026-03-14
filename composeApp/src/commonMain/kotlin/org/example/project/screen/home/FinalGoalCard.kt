package org.example.project.screen.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import gototorajaapp.composeapp.generated.resources.Res
import gototorajaapp.composeapp.generated.resources.calendar
import org.jetbrains.compose.resources.painterResource

@Composable
fun FinalGoalCard() {

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
                    Text("Final Goal")

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

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text("$3,250 raised")
                Text("$1,750 left")
            }

            Spacer(modifier = Modifier.height(8.dp))

            LinearProgressIndicator(
                progress = 0.65f,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp),
                color = Color(0xFF22C55E)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(20.dp)
                    )
                    .border(
                        width = 0.5.dp,
                        color = Color(0xFF22C55E),
                        shape = RoundedCornerShape(20.dp)
                    )
                    .padding(vertical = 10.dp)
            )
            {
                Icon(
                    painter = painterResource(Res.drawable.calendar),
                    contentDescription = null,
                    modifier = Modifier.size(20.dp),
                    tint = Color(0xFF22C55E)
                )

                Spacer(modifier = Modifier.width(10.dp))

                Text(text = "85 days until Toraja!", fontWeight = FontWeight.Bold, color = Color.Black)
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun FinalGoalCardPreview(){
    MaterialTheme {
        FinalGoalCard()
    }
}