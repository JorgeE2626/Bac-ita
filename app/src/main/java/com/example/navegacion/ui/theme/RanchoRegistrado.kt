package com.example.navegacion.ui.theme

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.*
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.*
import androidx.navigation.NavController
import kotlinx.coroutines.launch
import android.content.Intent
import android.net.Uri
import androidx.compose.ui.platform.LocalContext

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RanchoRegistrado(navController: NavController) {

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
            }
        ) { padding ->

            RanchoContent(
                modifier = Modifier.padding(padding),
                onEditarClick = {
                    navController.navigate("editar_rancho")
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(onMenuClick: () -> Unit) {
    TopAppBar(
        title = { Text("Juan Lopez") },
        navigationIcon = {
            IconButton(onClick = onMenuClick) {
                Icon(Icons.Default.Menu, contentDescription = "")
            }
        }
    )
}

@Composable
fun DrawerMenu() {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .width(250.dp)
            .background(Color.White)
            .padding(16.dp)
    ) {

        Text("Menu", fontSize = 20.sp)

        Spacer(modifier = Modifier.height(16.dp))

        HorizontalDivider()
        Text("Opción", modifier = Modifier.padding(12.dp))
        HorizontalDivider()
        Text("Cerrar Sesión", modifier = Modifier.padding(12.dp))
        HorizontalDivider()
        Text("Ajustes", modifier = Modifier.padding(12.dp))
        HorizontalDivider()
    }
}

@Composable
fun RanchoContent(
    modifier: Modifier = Modifier,
    onEditarClick: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(FondoGris)
            .padding(16.dp)
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .background(Color.Gray)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text("Rancho \"El Paraíso\"", fontSize = 20.sp)

        Spacer(modifier = Modifier.height(16.dp))

        InfoField("Hectáreas Totales:", "50 ha")
        InfoField("Propietario:", "Pugberto Dominguez")
        InfoField("Veterinario encargado:", "Tralalero Perez")

        Spacer(modifier = Modifier.height(8.dp))

        Text("Ganado:")
        Row {
            Chip("Bovino")
            Spacer(modifier = Modifier.width(8.dp))
            Chip("Porcino")
        }

        Spacer(modifier = Modifier.height(8.dp))
        val context = LocalContext.current

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {

                    val uri = Uri.parse("https://share.google/dltSWceQYXuxPC6J4")
                    val intent = Intent(Intent.ACTION_VIEW, uri)
                    context.startActivity(intent)
                }
                .padding(8.dp)
        ) {
            Text("Localización:")
            Text("Tecnológico de Aguascalientes")

            Spacer(modifier = Modifier.height(8.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .background(Color.Gray),
                contentAlignment = Alignment.Center
            ) {
                Text("Ver mapa")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = onEditarClick,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("Editar")
        }
    }
}

@Composable
fun InfoField(label: String, value: String) {
    Column {
        Text(label, fontSize = 12.sp)
        OutlinedTextField(
            value = value,
            onValueChange = {},
            enabled = false,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun Chip(text: String) {
    Box(
        modifier = Modifier
            .background(VerdeChip, shape = RoundedCornerShape(16.dp))
            .padding(horizontal = 12.dp, vertical = 6.dp)
    ) {
        Text(text)
    }
}
