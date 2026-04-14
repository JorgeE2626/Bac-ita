package com.example.navegacion.ui.theme

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.*
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.*
import androidx.navigation.NavController
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LogoCarne(navController: NavController) {

    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = { DrawerMenu() }
    ) {

        Scaffold(
            topBar = {
                TopBarHoja(
                    onMenuClick = { scope.launch { drawerState.open() } },
                    userName = "Juan Lopez"
                )
            }
        ) { padding ->

            LogoCarneContent(
                modifier = Modifier.padding(padding),
                navController = navController
            )
        }
    }
}

@Composable
fun LogoCarneContent(modifier: Modifier = Modifier, navController: NavController) {

    var expanded by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {

        Row(
            horizontalArrangement = Arrangement.spacedBy(15.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            IconNavButton(Icons.Default.Restaurant, RojoCarne, isSelected = true) {
            }
            IconNavButton(Icons.Default.MedicalServices, VerdeJeringa) {
            }
            IconNavButton(Icons.Default.LocationOn, CyanUbicacion) {
                navController.navigate("rancho_registrado")
            }
            IconNavButton(Icons.Default.Eco, NaranjaEco) {
                navController.navigate("logo_hoja")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = "",
            onValueChange = {},
            placeholder = { Text("🔍 No.Vaca", color = Color.Gray) },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(8.dp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = Color.LightGray
            )
        )

        Spacer(modifier = Modifier.height(12.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            border = BorderStroke(1.dp, Color.LightGray),
            shape = RoundedCornerShape(8.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Box {
                    OutlinedTextField(
                        value = "Nombre : Lana",
                        onValueChange = {},
                        readOnly = true,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { expanded = true }
                    )

                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false }
                    ) {
                        DropdownMenuItem(text = { Text("Nombre: Lana") }, onClick = { expanded = false })
                        DropdownMenuItem(text = { Text("Peso: 750 kg") }, onClick = { expanded = false })
                        DropdownMenuItem(text = { Text("Edad: 4 años") }, onClick = { expanded = false })
                        DropdownMenuItem(text = { Text("Vacunas: Completas") }, onClick = { expanded = false })
                        DropdownMenuItem(text = { Text("Crías: 2") }, onClick = { expanded = false })
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                LinearProgressIndicator(
                    progress = { 0.95f },
                    modifier = Modifier.fillMaxWidth(),
                    color = AzulGrafica
                )

                Text("95% del peso ideal", fontSize = 12.sp)

                Spacer(modifier = Modifier.height(10.dp))

                LinearProgressIndicator(
                    progress = { 0.2f },
                    modifier = Modifier.fillMaxWidth(),
                    color = RosaGrafica
                )

                Text(
                    "ALERTA 20 % de las vacunas requeridas llame al profesional encargado...",
                    fontSize = 12.sp,
                    color = Color.Red
                )

                Spacer(modifier = Modifier.height(20.dp))

                Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                    LegendCarne(AzulGrafica, "Ganancia trimestral")
                    LegendCarne(RosaGrafica, "Inversión neta")
                }

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    modifier = Modifier.fillMaxWidth().height(100.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.Bottom
                ) {
                    BarCarne(60.dp, AzulGrafica)
                    BarCarne(30.dp, RosaGrafica)
                    BarCarne(80.dp, AzulGrafica)
                    BarCarne(40.dp, RosaGrafica)
                    BarCarne(90.dp, AzulGrafica)
                    BarCarne(50.dp, RosaGrafica)
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        var expanded2 by remember { mutableStateOf(false) }

        Box {
            OutlinedTextField(
                value = "Número de identificación: V-0237",
                onValueChange = {},
                readOnly = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { expanded2 = true }
            )

            DropdownMenu(
                expanded = expanded2,
                onDismissRequest = { expanded2 = false }
            ) {
                DropdownMenuItem(text = { Text("Nombre: Lana") }, onClick = { expanded2 = false })
                DropdownMenuItem(text = { Text("Alimento: Pastura") }, onClick = { expanded2 = false })
                DropdownMenuItem(text = { Text("Peso: 750 kg") }, onClick = { expanded2 = false })
                DropdownMenuItem(text = { Text("Edad: 4 años") }, onClick = { expanded2 = false })
                DropdownMenuItem(text = { Text("Crías: 2") }, onClick = { expanded2 = false })
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = "Observaciones adicionales",
            onValueChange = {},
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun LegendCarne(color: Color, text: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Box(
            modifier = Modifier
                .size(10.dp)
                .background(color, CircleShape)
        )
        Spacer(modifier = Modifier.width(5.dp))
        Text(text, fontSize = 12.sp)
    }
}

@Composable
fun BarCarne(height: Dp, color: Color) {
    Box(
        modifier = Modifier
            .width(20.dp)
            .height(height)
            .background(color, RoundedCornerShape(4.dp))
    )
}
