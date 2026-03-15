package org.example.project.screen.profile

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import gototorajaapp.composeapp.generated.resources.Res
import gototorajaapp.composeapp.generated.resources.logout
import org.jetbrains.compose.resources.painterResource

@Composable
fun LogoutButton() {

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

@Composable
@Preview(showBackground = true)
fun LogoutButtonPreview(){
    MaterialTheme {
        LogoutButton()
    }
}