package com.example.notesappmvvm.screens

import android.app.Application
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.notesappmvvm.MainViewModel
import com.example.notesappmvvm.MainViewModelFactory
import com.example.notesappmvvm.R
import com.example.notesappmvvm.model.Note
import com.example.notesappmvvm.navigation.NavRoute
import com.example.notesappmvvm.ui.theme.*

@Composable
fun MainScreen(navController: NavHostController) {
    val context = LocalContext.current
    val mViewModel: MainViewModel =
        viewModel(factory = MainViewModelFactory(context.applicationContext as Application))

    val notes = mViewModel.readTest.observeAsState(listOf()).value
    Scaffold(
        backgroundColor = Invisible,
        floatingActionButton = {
            FloatingActionButton(
                backgroundColor = Maroon,
                onClick = {
                    navController.navigate(NavRoute.Add.route)
                }) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "Add Icon",
                    tint = Color.Black
                )
            }
        }
    ) {
        //Column {
    //  NoteItem(title = "Note 1", subtitle = "Note 1", navController = navController)
        //}
        LazyColumn {
            items(notes) { note ->
                NoteItem(note = note, navController = navController)
            }
        }
    }
}

@Composable
fun NoteItem(
    note: Note,
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
                navController.navigate(NavRoute.Note.route)
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
                note.title,
                fontSize = 35.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 3.dp),
                letterSpacing = 3.sp,
                color = Pen
            )
            Text(
                note. subtitle,
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