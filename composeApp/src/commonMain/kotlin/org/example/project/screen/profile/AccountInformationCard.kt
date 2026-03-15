package org.example.project.screen.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import gototorajaapp.composeapp.generated.resources.Res
import gototorajaapp.composeapp.generated.resources.email
import gototorajaapp.composeapp.generated.resources.phone
import gototorajaapp.composeapp.generated.resources.user

@Composable
fun AccountInformationCard() {

    Column {

        Text(
            "Account Information",
            fontWeight = FontWeight.SemiBold
        )

        Spacer(Modifier.height(12.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(2.dp, RoundedCornerShape(20.dp))
                .clip(RoundedCornerShape(20.dp))
                .background(Color.White).padding(vertical = 5.dp)
        ) {

            AccountItem(
                icon = Res.drawable.user,
                label = "Full Name",
                value = "Alice Smith"
            )

//            Divider()

            AccountItem(
                icon = Res.drawable.email,
                label = "Email Address",
                value = "alice@example.com"
            )

//            Divider()

            AccountItem(
                icon = Res.drawable.phone,
                label = "Phone Number",
                value = "+62 812 3456 789"
            )
        }
    }
}