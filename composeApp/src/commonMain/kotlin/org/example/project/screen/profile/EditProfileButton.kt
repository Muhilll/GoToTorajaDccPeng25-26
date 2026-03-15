package org.example.project.screen.profile

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import gototorajaapp.composeapp.generated.resources.Res
import gototorajaapp.composeapp.generated.resources.edit
import org.jetbrains.compose.resources.painterResource

@Composable
fun EditProfileButton() {

    OutlinedButton(
        onClick = {},
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
}

@Composable
@Preview(showBackground = true)
fun EditProfileButtonPreview(){
    MaterialTheme {
        EditProfileButton()
    }
}