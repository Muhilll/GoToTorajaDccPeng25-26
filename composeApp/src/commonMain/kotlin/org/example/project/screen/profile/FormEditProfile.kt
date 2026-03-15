package org.example.project.screen.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import gototorajaapp.composeapp.generated.resources.Res
import gototorajaapp.composeapp.generated.resources.arrow
import gototorajaapp.composeapp.generated.resources.avatar
import gototorajaapp.composeapp.generated.resources.edit
import gototorajaapp.composeapp.generated.resources.email
import gototorajaapp.composeapp.generated.resources.phone
import gototorajaapp.composeapp.generated.resources.user
import org.jetbrains.compose.resources.painterResource

class EditProfileScreen: Screen {
    @Composable
    override fun Content() {
        EditProfilePage()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showBackground = true)
fun EditProfilePage() {
    val navigator = LocalNavigator.current
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }

    Column {
        CenterAlignedTopAppBar(
            navigationIcon = {
                IconButton(onClick = {
                    navigator?.pop()
                }) {
                    Icon(
                        painter = painterResource(
                            Res.drawable.arrow
                        ),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp),
                        tint = Color.Black
                    )
                }
            },
            title = {
                Text(
                    text = "Edit Profile",
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            }
        )

        Column (
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF6F8F6))
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column (
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Box {

                    Image(
                        painter = painterResource(Res.drawable.avatar),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(120.dp)
                            .clip(CircleShape)
                    )

                    Box(
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .size(32.dp)
                            .clip(CircleShape)
                            .background(Color(0xFF22C55E)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(Res.drawable.edit),
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(16.dp).padding(start = 2.dp, bottom = 2.dp)
                        )
                    }
                }

                Spacer(Modifier.height(12.dp))

                Text(
                    "Profile Picture",
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF13EC5B)
                )
            }

            Spacer(Modifier.height(24.dp))

            Card(
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {

                Column(
                    modifier = Modifier
                        .padding(24.dp),
                    verticalArrangement = Arrangement.spacedBy(18.dp)
                ) {

                    FormField(
                        label = "Full Name",
                        value = name,
                        icon = painterResource(Res.drawable.user),
                        placeHolder = "Full Name"
                    ) { name = it }

                    FormField(
                        label = "Email Address",
                        value = email,
                        icon = painterResource(Res.drawable.email),
                        placeHolder = "Email Address"
                    ) { email = it }

                    FormField(
                        label = "Phone Number",
                        value = phone,
                        icon = painterResource(Res.drawable.phone),
                        placeHolder = "Phone Number"
                    ) { phone = it }
                }
            }

            Spacer(Modifier.height(24.dp))

            Button(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(30.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF22C55E)
                )
            ) {

                Text(
                    text = "Save Changes",
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    fontSize = 17.sp
                )
            }

            TextButton(
                onClick = {
                    navigator?.pop()
                }
            ){
                Text(
                    text = "Cancel",
                    color = Color.Gray,
                    fontSize = 17.sp
                )
            }

        }
    }
}

@Composable
fun FormField(
    label: String,
    value: String,
    icon: Painter,
    placeHolder: String,
    onValueChange: (String) -> Unit
) {

    Column {
        Text(
            text = label,
            fontSize = 14.sp,
            color = Color(0xFF6B7280)
        )

        Spacer(modifier = Modifier.height(6.dp))

        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            leadingIcon = {
                Icon(
                    icon, contentDescription = null,
                    modifier = Modifier.size(20.dp),
                    tint = Color(0xFF13EC5B)
                )
            },
            modifier = Modifier.fillMaxWidth().border(
                width = 1.dp,
                color = Color(0xFFE5E7EB),
                shape = RoundedCornerShape(20.dp)
            ),
            shape = RoundedCornerShape(20.dp),
            singleLine = true,
            placeholder = {
                Text(placeHolder)
            }
        )
    }
}