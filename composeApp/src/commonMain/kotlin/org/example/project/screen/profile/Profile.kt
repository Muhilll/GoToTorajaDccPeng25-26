package org.example.project.screen.profile

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.LocalNavigator
import gototorajaapp.composeapp.generated.resources.Res
import gototorajaapp.composeapp.generated.resources.edit
import gototorajaapp.composeapp.generated.resources.logout
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfilePage() {
    val navigator = LocalNavigator.current
    
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF6F8F6))
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        ProfileHeader()

        Spacer(Modifier.height(24.dp))

        TripSavingsCard()

        Spacer(Modifier.height(24.dp))

        AccountInformationCard()

        Spacer(Modifier.height(24.dp))

        OutlinedButton(
            onClick = {
                navigator?.push(EditProfileScreen())
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(54.dp),
            shape = RoundedCornerShape(50.dp),
            border = BorderStroke(2.dp, Color(0xFF22C55E))
        ) {

            Icon(
                painter = painterResource(Res.drawable.edit),
                contentDescription = null,
                tint = Color(0xFF22C55E),
                modifier = Modifier.size(25.dp).padding(bottom = 5.dp)
            )

            Spacer(Modifier.width(8.dp))

            Text(
                "Edit Profile",
                color = Color(0xFF22C55E),
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp
            )
        }

        TextButton(onClick = {}) {

            Icon(
                painter = painterResource(Res.drawable.logout),
                contentDescription = null,
                tint = Color.Red,
                modifier = Modifier.size(25.dp).padding(top = 3.dp)
            )

            Spacer(Modifier.width(6.dp))

            Text(
                "Logout",
                color = Color.Red,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}


@Composable
@Preview(showBackground = true)
fun ProfilePagePreview(){
    MaterialTheme {
        ProfilePage()
    }
}