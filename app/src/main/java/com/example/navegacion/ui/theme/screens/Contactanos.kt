package com.example.navegacion.ui.theme.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.*
import androidx.navigation.NavController
import kotlinx.coroutines.launch

@Composable
fun Contactanos(navController: NavController) {

    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerMenu()
        }
    ) {

        Scaffold(
            topBar = {
                TopBar {
                    scope.launch { drawerState.open() }
                }
            },
            bottomBar = {
                BottomBar()
            }
        ) { padding ->

            ContactanosContent(
                modifier = Modifier.padding(padding)
            )
        }
    }
}
@Composable
fun ContactanosContent(modifier: Modifier = Modifier) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFEFEFEF))
            .padding(16.dp)
    ) {

        Text("¿Cómo podemos ayudarte?")
        Divider(thickness = 2.dp)

        Spacer(modifier = Modifier.height(16.dp))

        ItemAyuda("No puedo actualizar los datos de mi vaca")
        ItemAyuda("La ubicación no está actualizada")
        ItemAyuda("¿Por qué no puedo agregar más vacunas?")
        ItemAyuda("No se guardan los datos de mi rancho")

        Spacer(modifier = Modifier.height(20.dp))

        Text("¿Ninguna fue de ayuda?")
        Divider(thickness = 2.dp)

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(Icons.Default.LocationOn, contentDescription = "")
                Text("Ubicación de\nnuestra oficina", fontSize = 12.sp)
                Text(
                    "Av. Adolfo López Mateos #1801\nOte., Fraccionamiento Bona\nGens, C.P. 20255, Ags, Ags.",
                    fontSize = 10.sp
                )
            }

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(Icons.Default.Call, contentDescription = "")
                Text("Teléfono (fijo)", fontSize = 12.sp)
                Text("+52 055 876 6789", fontSize = 10.sp)
            }
        }
    }
}
@Composable
fun ItemAyuda(texto: String) {
    Column {
        Text(texto)
        Divider()
        Spacer(modifier = Modifier.height(10.dp))
    }
}
@Composable
fun BottomBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF8FBF8F))
            .padding(12.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Icon(Icons.Default.Menu, contentDescription = "")
        Icon(Icons.Default.Home, contentDescription = "")
        Icon(Icons.Default.ArrowBack, contentDescription = "")
    }
}