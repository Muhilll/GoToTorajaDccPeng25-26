package org.example.project.screen.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import gototorajaapp.composeapp.generated.resources.Res
import gototorajaapp.composeapp.generated.resources.email
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun AccountItem(
    icon: DrawableResource,
    label: String,
    value: String
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Box(
            modifier = Modifier
                .size(36.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Color(0xFFF1F3F5)),
            contentAlignment = Alignment.Center
        ) {

            Icon(
                painter = painterResource(icon),
                contentDescription = null,
                modifier = Modifier.size(18.dp),
                tint = Color(0xFF13EC5B)
            )
        }

        Spacer(Modifier.width(12.dp))

        Column {
            Text(
                label,
                fontSize = 12.sp,
                color = Color.Gray
            )

            Text(
                value,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun AccountItemPreview(){
    MaterialTheme {
        AccountItem(
            icon = Res.drawable.email,
            label = "Email Address",
            value = "alice@example.com"
        )
    }
}