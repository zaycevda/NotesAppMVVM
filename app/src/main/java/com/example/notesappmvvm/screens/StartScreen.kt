package com.example.notesappmvvm.screens

import android.app.Application
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.NavHostController
import com.example.notesappmvvm.MainViewModel
import com.example.notesappmvvm.MainViewModelFactory
import com.example.notesappmvvm.R
import com.example.notesappmvvm.navigation.NavRoute
import com.example.notesappmvvm.ui.theme.Invisible
import com.example.notesappmvvm.ui.theme.Maroon
import com.example.notesappmvvm.ui.theme.MistyRose
import com.example.notesappmvvm.utils.TYPE_DATABASE
import com.example.notesappmvvm.utils.TYPE_FIREBASE
import com.example.notesappmvvm.utils.TYPE_ROOM

@Composable
fun StartScreen(navController: NavHostController) {
    val context = LocalContext.current
    val mViewModel: MainViewModel =
        viewModel(factory = MainViewModelFactory(context.applicationContext as Application))
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        backgroundColor = Invisible,
        topBar = {
            Spacer(
                modifier = Modifier
                    .fillMaxHeight(0.6f)
            )},
        content = {
            Box(
                modifier = Modifier
                    .padding(bottom = 40.dp, start = 30.dp, end = 30.dp)
                    .background(Invisible)
                    .clip(RoundedCornerShape(percent = 20)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.kittiesblur),
                    contentDescription = "main bg",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                )
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    Text(
                        "What will we use?",
                        color = MistyRose,
                        fontSize = 35.sp,
                        modifier = Modifier
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
                    Button(
                        modifier = Modifier
                            .height(40.dp)
                            .width(200.dp)
                            .clip(RoundedCornerShape(percent = 40)),
                        colors = ButtonDefaults.buttonColors(Maroon),
                        onClick = {
                            mViewModel.initDatabase(TYPE_ROOM)
                            navController.navigate(NavRoute.Main.route)
                        }
                    ) {
                        Text(
                            "Room database",
                            color = MistyRose,
                            fontSize = 17.sp
                        )
                    }
                    Button(
                        modifier = Modifier
                            .height(40.dp)
                            .width(200.dp)
                            .clip(RoundedCornerShape(percent = 40)),
                        colors = ButtonDefaults.buttonColors(Maroon),
                        onClick = {
                            mViewModel.initDatabase(TYPE_FIREBASE)
                            navController.navigate(NavRoute.Main.route)
                        }
                    ) {
                        Text(
                            "Firebase database",
                            color = MistyRose,
                            fontSize = 17.sp
                        )
                    }
                }
            }
        }
    )
}