package org.example.project.screen.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.LocalNavigator

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

        EditProfileButton()

        Spacer(Modifier.height(16.dp))

        LogoutButton()
    }
}


@Composable
@Preview(showBackground = true)
fun ProfilePagePreview(){
    MaterialTheme {
        ProfilePage()
    }
}