package com.example.notesappmvvm.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.notesappmvvm.R
import com.example.notesappmvvm.navigation.NavRoute
import com.example.notesappmvvm.ui.theme.*

@Composable
fun MainScreen(navController: NavHostController) {
    Scaffold(
        backgroundColor = Invisible,
        floatingActionButton = {
            FloatingActionButton(
                backgroundColor = Maroon,
                onClick = {

                }) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "Add Icon",
                    tint = Color.Black
                )
            }
        }
    ) {
        Column {
            NoteItem(title = "Note 1", subtitle = "Note 1", navController = navController)
        }
    }
}

@Composable
fun NoteItem(
    title: String,
    subtitle: String,
    navController: NavHostController
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(
                top = 20.dp,
                end = 20.dp,
                start = 20.dp
            )
            .clip(RoundedCornerShape(percent = 40))
            .clickable {

            },
        elevation = 6.dp
    ) {
        Image(
            painter = painterResource(id = R.drawable.checheredblur),
            contentDescription = "card bg blur",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
        )
        Column {
            Text(
                title,
                fontSize = 35.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 3.dp),
                letterSpacing = 3.sp,
                color = Pen
            )
            Text(
                subtitle,
                modifier = Modifier
                    .padding(start = 7.dp, bottom = 3.dp, end = 7.dp),
                fontSize = 17.sp,
                color = Pen
            )
        } 
    }
}


@Preview(showBackground = true)
@Composable
fun prevMainScreen() {
    NotesAppMVVMTheme {
        MainScreen(navController = rememberNavController())
    }
}