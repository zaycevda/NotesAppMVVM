package com.example.notesappmvvm.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.notesappmvvm.navigation.NavRoute
import com.example.notesappmvvm.ui.theme.*

@Composable
fun AddScreen(navController: NavHostController) {
    var title by remember { mutableStateOf("")}
    var subtitle by remember { mutableStateOf("")}
    Scaffold(
        backgroundColor = Invisible
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                "Add new note",
                color = MistyRose,
                fontSize = 35.sp,
                modifier = Modifier
                    .padding(vertical = 10.dp)
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Maroon
                        ),
                            startY = 25f
                    )
                )
            )
            OutlinedTextField(
                value = title,
                onValueChange = {title = it},
                label = { Text(
                    "Note title",
                    fontSize = 17.sp,
                    color = Pen
                ) },
                colors = TextFieldDefaults.textFieldColors(Pen)
            )
            OutlinedTextField(
                value = subtitle,
                onValueChange = {subtitle = it},
                label = { Text(
                    "Note subtitle",
                    fontSize = 17.sp,
                    color = Pen
                ) },
                colors = TextFieldDefaults.textFieldColors(Pen)
            )
            Button(
                modifier = Modifier
                    .clip(RoundedCornerShape(percent = 40))
                    .padding(vertical = 10.dp),
                colors = ButtonDefaults.buttonColors(Maroon),
                onClick = {

                }
            ) {
                Text(
                    "Add note",
                    color = MistyRose,
                    fontSize = 17.sp
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun prevAddScreen() {
    NotesAppMVVMTheme {
        AddScreen(navController = rememberNavController())
    }
}