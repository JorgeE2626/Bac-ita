package com.example.navegacion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.background
import androidx.navigation.compose.*
import com.example.navegacion.ui.theme.NavegacionTheme
import com.example.navegacion.ui.theme.Tur
import com.example.navegacion.ui.theme.Home
import com.example.navegacion.ui.theme.Profile
import com.example.navegacion.ui.theme.Settings

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            NavegacionTheme {

                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = "login"
                ) {

                    composable("login") {
                        Scaffold(
                            modifier = Modifier.fillMaxSize()
                        ) { padding ->

                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(Tur)
                                    .padding(padding),
                                contentAlignment = Alignment.Center
                            ) {
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {

                                    Cajatexto1()
                                    Cajatexto2()

                                    BotonAzulMarino {
                                        navController.navigate("home") {
                                            popUpTo("login") {
                                                inclusive = true
                                            }
                                            launchSingleTop = true
                                        }
                                    }
                                }
                            }
                        }
                    }

                    composable("home") {
                        Home(navController)
                    }

                    composable("settings") {
                        Settings(navController)
                    }

                    composable("profile") {
                        Profile(navController)
                    }
                }
            }
        }
    }
}

@Composable
fun Cajatexto1() {
    var texto by remember { mutableStateOf("") }

    OutlinedTextField(
        value = texto,
        onValueChange = { texto = it },
        label = { Text("Nombre") },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color.Black,
            unfocusedBorderColor = Color.Black,
            focusedLabelColor = Color.Black,
            cursorColor = Color.Black
        )
    )
}

@Composable
fun Cajatexto2() {
    var texto by remember { mutableStateOf("") }

    OutlinedTextField(
        value = texto,
        onValueChange = { texto = it },
        label = { Text("Correo") },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color.Black,
            unfocusedBorderColor = Color.Black,
            focusedLabelColor = Color.Black,
            cursorColor = Color.Black
        )
    )
}

@Composable
fun BotonAzulMarino(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF001F3F)
        )
    ) {
        Text(text = "Presionar", color = Color.White)
    }
}