package org.example.project.screen.budget

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import gototorajaapp.composeapp.generated.resources.Res
import gototorajaapp.composeapp.generated.resources.arrow
import gototorajaapp.composeapp.generated.resources.info
import gototorajaapp.composeapp.generated.resources.sytemMode
import org.jetbrains.compose.resources.painterResource

enum class Category {
    TRANSPORT, STAY, FOOD, TICKET, OTHER
}

class FormAddBudgetScreen : Screen{
    @Composable
    override fun Content() {
        FormAddBudgetPage()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showBackground = true)
fun FormAddBudgetPage() {
    val navigator = LocalNavigator.current

    var selectedCategory by remember { mutableStateOf(Category.TRANSPORT) }
    var itemName by remember { mutableStateOf("") }
    var estimatedCost by remember { mutableStateOf("") }
    var notes by remember { mutableStateOf("") }

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
                    text = "Add Budget",
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
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Column {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .shadow(2.dp, RoundedCornerShape(20.dp))
                        .clip(RoundedCornerShape(20.dp))
                        .background(Color.White)
                        .padding(16.dp)
                ) {

                    Text(
                        "Category",
                        fontWeight = FontWeight.SemiBold
                    )

                    Spacer(Modifier.height(12.dp))

                    val categories = listOf(
                        Category.TRANSPORT,
                        Category.STAY,
                        Category.FOOD,
                        Category.TICKET,
                        Category.OTHER
                    )

                    FlowRow(
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {

                        categories.forEach {

                            val borderColor = if (it == selectedCategory) Color(0xFF13EC5B) else Color(0xFFF1F3F5)
                            val bgColor = if (it == selectedCategory) Color(0xFFD3FDE1) else Color(0xFFF3F4F6)

                            Column(
                                modifier = Modifier
                                    .width(100.dp)
                                    .clip(RoundedCornerShape(16.dp))
                                    .background(bgColor)
                                    .border(2.dp, borderColor, RoundedCornerShape(16.dp))
                                    .clickable { selectedCategory == it }
                                    .padding(vertical = 16.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {

                                Icon(
                                    painter = painterResource(Res.drawable.sytemMode),
                                    contentDescription = null,
                                    modifier = Modifier.size(20.dp)
                                )

                                Spacer(Modifier.height(6.dp))

                                Text(
                                    it.name.lowercase().replaceFirstChar { it.uppercase() },
                                    fontSize = 12.sp
                                )
                            }
                        }
                    }

                    Spacer(Modifier.height(20.dp))

                    Column {
                        Text("Item Name")

                        Spacer(Modifier.height(6.dp))

                        OutlinedTextField(
                            value = itemName,
                            onValueChange = { itemName = it },
                            placeholder = { Text("e.g. Flight to Tokyo") },
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(14.dp),
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
                        Text("Estimated Cost")

                        Spacer(Modifier.height(6.dp))

                        OutlinedTextField(
                            value = estimatedCost,
                            onValueChange = {estimatedCost = it},
                            leadingIcon = {
                                Text(
                                    "Rp",
                                    color = Color(0xFF22C55E),
                                    fontWeight = FontWeight.Bold
                                )
                            },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number
                            ),
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(14.dp),
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
                        Text("Notes (Optional)")

                        Spacer(Modifier.height(6.dp))

                        OutlinedTextField(
                            value = notes,
                            onValueChange = { notes = it },
                            placeholder = { Text("Add any specific details here...") },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(100.dp),
                            shape = RoundedCornerShape(14.dp),
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
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(14.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Icon(
                        painter = painterResource(Res.drawable.info),
                        contentDescription = null,
                        tint = Color(0xFF22C55E),
                        modifier = Modifier.size(15.dp)
                    )

                    Spacer(Modifier.width(10.dp))

                    Text(
                        "Pro-tip: You can split this budget with friends later in the trip overview screen.",
                        fontSize = 12.sp
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
                        text = "Save Changes",
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        fontSize = 17.sp
                    )
                }


                TextButton(
                    onClick = {
                        navigator?.pop()
                    },
                    modifier = Modifier.align(Alignment.CenterHorizontally)
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
}