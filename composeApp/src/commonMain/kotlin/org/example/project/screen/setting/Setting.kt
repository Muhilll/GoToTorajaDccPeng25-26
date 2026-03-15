package org.example.project.screen.setting

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import gototorajaapp.composeapp.generated.resources.Res
import gototorajaapp.composeapp.generated.resources.arrow
import gototorajaapp.composeapp.generated.resources.chevronRight
import gototorajaapp.composeapp.generated.resources.code
import gototorajaapp.composeapp.generated.resources.email
import gototorajaapp.composeapp.generated.resources.info
import gototorajaapp.composeapp.generated.resources.lightMode
import gototorajaapp.composeapp.generated.resources.nightMode
import gototorajaapp.composeapp.generated.resources.notification
import gototorajaapp.composeapp.generated.resources.sytemMode
import gototorajaapp.composeapp.generated.resources.trash
import org.jetbrains.compose.resources.painterResource

class SettingsScreen: Screen{
    @Composable
    override fun Content() {
        SettingsPage()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showBackground = true)
fun SettingsPage() {
    val navigator = LocalNavigator.current

    var pushNotification by remember { mutableStateOf(true) }
    var emailSummary by remember { mutableStateOf(false) }
    var appearance by remember { mutableStateOf("light") }

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
                    text = "Settings",
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            }
        )

        Column (
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF3F4F6))
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {

            Text(
                text = "NOTIFICATIONS",
                fontWeight = FontWeight.Bold,
                color = Color(0xFF6B7280),
                modifier = Modifier.padding(bottom = 8.dp)
            )

            CardContainer {
                SwitchItem(
                    icon = painterResource(Res.drawable.notification),
                    title = "Push Notifications",
                    subtitle = "Alerts for goals and trip updates",
                    checked = pushNotification,
                    onCheckedChange = { pushNotification = it }
                )

                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(0.3.dp)
                        .background(Color.Gray)
                )

                SwitchItem(
                    icon = painterResource(Res.drawable.email),
                    title = "Email Summaries",
                    subtitle = "Weekly savings progress report",
                    checked = emailSummary,
                    onCheckedChange = { emailSummary = it }
                )
            }

            Spacer(Modifier.height(24.dp))

            Text(
                text = "APP APPEARANCE",
                fontWeight = FontWeight.Bold,
                color = Color(0xFF6B7280),
                modifier = Modifier.padding(bottom = 8.dp)
            )

            CardContainer {

                RadioItem(
                    icon = painterResource(Res.drawable.lightMode),
                    title = "Light Mode",
                    selected = appearance == "light",
                    onClick = { appearance = "light" }
                )

                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(0.3.dp)
                        .background(Color.Gray)
                )

                RadioItem(
                    icon = painterResource(Res.drawable.nightMode),
                    title = "Dark Mode",
                    selected = appearance == "dark",
                    onClick = { appearance = "dark" }
                )

                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(0.3.dp)
                        .background(Color.Gray)
                )

                RadioItem(
                    icon = painterResource(Res.drawable.sytemMode),
                    title = "System Default",
                    selected = appearance == "system",
                    onClick = { appearance = "system" }
                )
            }

            Spacer(Modifier.height(24.dp))

            Text(
                text = "ABOUT",
                fontWeight = FontWeight.Bold,
                color = Color(0xFF6B7280),
                modifier = Modifier.padding(bottom = 8.dp)
            )

            CardContainer {

                NavigationItem(
                    icon = painterResource(Res.drawable.info),
                    title = "App Version",
                    trailing = {
                        Surface (
                            shape = RoundedCornerShape(20.dp),
                            color = Color(0xFFE5E7EB)
                        ) {
                            Text(
                                "v1.0.4",
                                modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
                                fontSize = 12.sp
                            )
                        }
                    }
                )

                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(0.3.dp)
                        .background(Color.Gray)
                )

                NavigationItem(
                    icon = painterResource(Res.drawable.code),
                    title = "Developer Credits",
                    trailing = {
                        Icon(
                            painterResource(Res.drawable.chevronRight),
                            null,
                            modifier = Modifier.size(15.dp)
                        )
                    }
                )

                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(0.3.dp)
                        .background(Color.Gray)
                )

                NavigationItem(
                    icon = painterResource(Res.drawable.trash),
                    title = "Delete Account",
                    titleColor = Color.Red
                )
            }
        }
    }
}