package org.example.project.screen.form

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import gototorajaapp.composeapp.generated.resources.Res
import gototorajaapp.composeapp.generated.resources.arrow
import gototorajaapp.composeapp.generated.resources.calendar
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import org.jetbrains.compose.resources.painterResource
import kotlin.time.Instant

class FormContributionPeriodScreen: Screen {
    @Composable
    override fun Content() {
        FormContributionPeriodPage()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormContributionPeriodPage() {
    val navigator = LocalNavigator.current
    var startDate by remember { mutableStateOf("") }
    var showDatePicker by remember { mutableStateOf(false) }
    var amount by remember { mutableStateOf("") }
    var notes by remember { mutableStateOf("") }

    val interactionSource = remember { MutableInteractionSource() }
    LaunchedEffect(interactionSource) {
        interactionSource.interactions.collect { interaction ->
            if (interaction is PressInteraction.Release) {
                showDatePicker = true
            }
        }
    }

    if (showDatePicker) {

        val datePickerState = rememberDatePickerState()

        DatePickerDialog(
            onDismissRequest = { showDatePicker = false },
            confirmButton = {

                TextButton(
                    onClick = {
                        val millis = datePickerState.selectedDateMillis

                        if (millis != null) {

                            val date = Instant
                                .fromEpochMilliseconds(millis)
                                .toLocalDateTime(TimeZone.currentSystemDefault())
                                .date

                            startDate =
                                "${date.dayOfMonth}/${date.monthNumber}/${date.year}"
                        }

                        showDatePicker = false
                    }
                ) {
                    Text("OK")
                }

            }
        ) {

            DatePicker(state = datePickerState)

        }
    }

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
                    text = "Create Contribution Periode",
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            }
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF6F8F6))
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color.White)
                    .padding(16.dp)
            ) {
                Column {

                    Text(
                        text = "Week Number",
                        fontSize = 13.sp,
                        color = Color(0xFF6B7280)
                    )

                    Spacer(Modifier.height(6.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(12.dp))
                            .background(Color(0xFFF1F3F5))
                            .padding(12.dp)
                    ) {
                        Text(
                            text = "#  Week 9",
                            color = Color(0xFF6B7280)
                        )
                    }
                }

                Spacer(Modifier.height(16.dp))

                Column {

                    Text(
                        text = "Start Date",
                        fontSize = 13.sp,
                        color = Color(0xFF6B7280)
                    )

                    Spacer(Modifier.height(6.dp))

                    OutlinedTextField(
                        value = startDate,
                        onValueChange = {},
                        readOnly = true,
                        interactionSource = interactionSource,
                        placeholder = { Text("Select date") },
                        trailingIcon = {
                            Icon(
                                painter = painterResource(Res.drawable.calendar),
                                contentDescription = null,
                                modifier = Modifier.size(20.dp)
                            )
                        },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedContainerColor = Color(0xFFF1F3F5),
                            focusedContainerColor = Color(0xFFF1F3F5),
                            unfocusedBorderColor = Color.Transparent,
                            focusedBorderColor = Color.Transparent
                        )
                    )
                }

                Spacer(Modifier.height(16.dp))

                Column {

                    Text(
                        text = "Contribution Amount",
                        fontSize = 13.sp,
                        color = Color(0xFF6B7280)
                    )

                    Spacer(Modifier.height(6.dp))

                    OutlinedTextField(
                        value = amount,
                        onValueChange = { amount = it },
                        modifier = Modifier.fillMaxWidth(),
                        prefix = { Text("Rp ") },
                        placeholder = { Text("5000") },
                        trailingIcon = {
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(6.dp))
                                    .background(Color(0xFFE7F9ED))
                                    .padding(horizontal = 8.dp, vertical = 4.dp)
                            ) {
                                Text(
                                    text = "MINIMUM",
                                    fontSize = 10.sp,
                                    color = Color(0xFF16A34A),
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        },
                        shape = RoundedCornerShape(12.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedContainerColor = Color(0xFFF1F3F5),
                            focusedContainerColor = Color(0xFFF1F3F5),
                            unfocusedBorderColor = Color.Transparent,
                            focusedBorderColor = Color.Transparent
                        )
                    )
                }


                Spacer(Modifier.height(16.dp))

                Column {

                    Text(
                        text = "Notes (Optional)",
                        fontSize = 13.sp,
                        color = Color(0xFF6B7280)
                    )

                    Spacer(Modifier.height(6.dp))

                    OutlinedTextField(
                        value = notes,
                        onValueChange = { notes = it },
                        placeholder = { Text("Add a memo for this week...") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        shape = RoundedCornerShape(12.dp),
                        maxLines = 4,
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedContainerColor = Color(0xFFF1F3F5),
                            focusedContainerColor = Color(0xFFF1F3F5),
                            unfocusedBorderColor = Color.Transparent,
                            focusedBorderColor = Color.Transparent
                        )
                    )
                }

            }

            Spacer(Modifier.height(20.dp))

            Row (
                verticalAlignment = Alignment.CenterVertically
            ) {

                Box(
                    modifier = Modifier
                        .size(20.dp)
                        .clip(CircleShape)
                        .background(Color(0xFF22C55E)),
                    contentAlignment = Alignment.Center
                ) {
                    Text("i", color = Color.White, modifier = Modifier.align(Alignment.Center))
                }

                Spacer(Modifier.width(10.dp))

                Text(
                    text = "By adding this week, all group members will be notified to complete their contribution of Rp 25,000.",
                    fontSize = 13.sp,
                    color = Color(0xFF6B7280)
                )
            }

            Spacer(Modifier.height(20.dp))

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
                    text = "Create Contribution Period",
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
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
                    fontSize = 14.sp
                )
            }


        }
    }
}

@Composable
@Preview(showBackground = true)
fun FormContributionPeriodPreview(){
    MaterialTheme{
        FormContributionPeriodPage()
    }
}
