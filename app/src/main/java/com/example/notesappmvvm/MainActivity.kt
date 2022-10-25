package com.example.notesappmvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.notesappmvvm.navigation.NotesNavHost
import com.example.notesappmvvm.screens.StartScreen
import com.example.notesappmvvm.ui.theme.Invisible
import com.example.notesappmvvm.ui.theme.Maroon
import com.example.notesappmvvm.ui.theme.MistyRose
import com.example.notesappmvvm.ui.theme.NotesAppMVVMTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotesAppMVVMTheme {
                Image(
                    painter = painterResource(id = R.drawable.kitties),
                    contentDescription = "Main bg",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
               Scaffold(
                   backgroundColor = Invisible,
                   topBar = {
                       TopAppBar(
                           title = {
                               Text("Notes App", color = MistyRose, letterSpacing = 3.sp)
                           },
                           backgroundColor = Maroon,
                           elevation = 12.dp,
                           modifier = Modifier
                               .clip(RoundedCornerShape(percent = 40))
                               .padding(5.dp)
                               .alpha(0.975f)
                       )
                   },
                   content = {
                       Surface(
                           modifier = Modifier.fillMaxSize(),
                           color = Invisible
                       ) {
                           NotesNavHost()
                       }
                   }
               )
            }    
        } 
    }
}