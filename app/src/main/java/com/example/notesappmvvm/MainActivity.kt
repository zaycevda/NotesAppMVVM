package com.example.notesappmvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.notesappmvvm.navigation.NotesNavHost
import com.example.notesappmvvm.ui.theme.Invisible
import com.example.notesappmvvm.ui.theme.Maroon
import com.example.notesappmvvm.ui.theme.NotesAppMVVMTheme
import com.example.notesappmvvm.ui.theme.MistyRose

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotesAppMVVMTheme {
                Image(
                    painter = painterResource(id = R.drawable.kitties),
                    contentDescription = "background",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                        .alpha(1f)
                )
                Scaffold(
                    backgroundColor = Invisible,
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(
                                    "Notes  App",
                                    letterSpacing = 3.sp,
                                    fontSize = 23.sp,
                                    color = MistyRose
                                )
                            },
                            backgroundColor = Maroon,
                            elevation = 12.dp,
                            modifier = Modifier
                                .alpha(0.975f)
                                .padding(3.dp)
                                .clip(
                                    RoundedCornerShape(percent = 40)
                                )
                        )
                    },
                    content = {
                        NotesNavHost()
                    }
                )
            }
        }
    }
}