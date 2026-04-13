/*package com.example.navegacion.ui.theme

import android.content.Context
import android.provider.Settings
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontVariation
import androidx.navigation.NavController
import kotlinx.coroutines.launch
import com.example.navegacion.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun vacuna(navController: NavController) {

    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {

                NavigationDrawerItem(
                    label = { Text("Home") },
                    selected = false,
                    onClick = {
                        scope.launch { drawerState.close() }
                        navController.navigate("home")
                    },
                    icon = { Icon(Icons.Default.Home, null) }
                )

                NavigationDrawerItem(
                    label = { Text("Profile") },
                    selected = false,
                    onClick = {
                        scope.launch { drawerState.close() }
                        navController.navigate("profile")
                    },
                    icon = { Icon(Icons.Default.Person, null) }
                )

                NavigationDrawerItem(
                    label = { Text("Settings") },
                    selected = false,
                    onClick = {
                        scope.launch { drawerState.close() }
                        navController.navigate("settings")
                    },
                    icon = { Icon(Icons.Default.Settings, null) }
                )

                Spacer(modifier = Modifier.height(20.dp))
                Divider()

                NavigationDrawerItem(
                    label = { Text("Logout") },
                    selected = false,
                    onClick = {
                        scope.launch { drawerState.close() }
                        val prefs = context.getSharedPreferences("session", Context.MODE_PRIVATE)
                        prefs.edit().clear().apply()
                        navController.navigate("login") {
                            popUpTo("home") { inclusive = true }
                        }
                    },
                    icon = { Icon(Icons.Default.ExitToApp, null) }
                )
            }
        }
    ) {

        Scaffold { padding ->

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFF7EA87E))
                        .padding(10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Row(verticalAlignment = Alignment.CenterVertically) {

                        IconButton(onClick = {
                            scope.launch { drawerState.open() }
                        }) {
                            Icon(Icons.Default.Menu, null)
                        }

                        Icon(Icons.Default.Person, null)

                        Spacer(modifier = Modifier.width(8.dp))

                        Box(
                            modifier = Modifier
                                .background(Color.White, RoundedCornerShape(12.dp))
                                .padding(horizontal = 12.dp, vertical = 6.dp)
                        ) {
                            Text("Juan Lopez")
                        }
                    }

                    Image(
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = null,
                        modifier = Modifier
                            .size(45.dp)
                            .clip(CircleShape)
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {

                    CircleButtonImage(Color(0xFFE53935), R.drawable.carne2)
                    CircleButtonImage(Color(0xFF2ECC71), R.drawable.jeringa1)
                    CircleButton(Color(0xFF1ABC9C), Icons.Default.LocationOn)
                    CircleButton(Color(0xFFD97B5E), Icons.Default.Eco)
                }

                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    placeholder = { Text("No.Vaca") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                )

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Column(modifier = Modifier.padding(10.dp)) {

                        Text("No.V-0852")

                        Spacer(modifier = Modifier.height(8.dp))

                        Text("✔ Profesional encargado : Dr. Vet. Agustín Lara CED")

                        Spacer(modifier = Modifier.height(10.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text("Edad")
                            Text("Giro")
                            Text("Dosis")
                            Text("Fecha")
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text("5 años")
                            Text("Lechera")
                            Text("5 ml")
                            Text("01/03/2026")
                        }

                        Spacer(modifier = Modifier.height(20.dp))

                        Text("Notas:")

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(120.dp)
                                .border(2.dp, Color(0xFF7EA87E))
                        )
                    }
                }

                listOf("No.V-0285", "No.V-0237", "No.V-0278").forEach {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                    ) {
                        Text(it, modifier = Modifier.padding(12.dp))
                    }
                }
            }
        }
    }
}

@Composable
fun CircleButton(color: Color, icon: ImageVector) {
    Box(
        modifier = Modifier
            .size(50.dp)
            .background(color, CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Icon(icon, null, tint = Color.White)
    }
}

@Composable
fun CircleButtonImage(color: Color, imageRes: Int) {
    Box(
        modifier = Modifier
            .size(50.dp)
            .background(color, CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = null,
            modifier = Modifier.size(28.dp)
        )
    }
}*/