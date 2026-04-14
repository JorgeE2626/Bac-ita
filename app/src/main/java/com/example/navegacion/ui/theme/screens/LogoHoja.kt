package com.example.navegacion.ui.theme.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.*
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.*
import androidx.navigation.NavController
import kotlinx.coroutines.launch
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.style.TextDecoration

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LogoHoja(navController: NavController) {
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
            LogoHojaContent(
                modifier = Modifier.padding(padding),
                navController = navController
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarHoja(onMenuClick: () -> Unit, userName: String) {
    CenterAlignedTopAppBar(
        modifier = Modifier.background(Color(0xFF8DB580)),
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color(0xFF8DB580)
        ),
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .background(Color.White, RoundedCornerShape(8.dp))
                    .padding(horizontal = 12.dp, vertical = 4.dp)
            ) {
                Text(userName, color = Color.Black, fontSize = 16.sp)
            }
        },
        navigationIcon = {
            IconButton(onClick = onMenuClick) {
                Icon(Icons.Default.Menu, contentDescription = "Menu", tint = Color.Black)
            }
        },
        actions = {
            Box(
                modifier = Modifier
                    .padding(end = 8.dp)
                    .size(45.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color.DarkGray, CircleShape)
            ) {
                Icon(
                    Icons.Default.AccountCircle,
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    tint = Color.DarkGray
                )
            }
        }
    )
}

@Composable
fun LogoHojaContent(modifier: Modifier = Modifier, navController: NavController) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Color.White)
            .padding(16.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(15.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            IconNavButton(Icons.Default.Restaurant, Color(0xFFD65A5A)) {
                navController.navigate("logo_carne")
            }
            IconNavButton(Icons.Default.MedicalServices, Color(0xFF2E7D32)) {
                // navController.navigate("logo_jeringa")
            }
            IconNavButton(Icons.Default.LocationOn, Color(0xFF26A69A)) {
                navController.navigate("rancho_registrado")
            }
            IconNavButton(Icons.Default.Eco, Color(0xFFDD8C6F), isSelected = true) {
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
                OutlinedTextField(
                    value = "No. V-02337",
                    onValueChange = {},
                    readOnly = true,
                    modifier = Modifier.fillMaxWidth().height(50.dp),
                    shape = RoundedCornerShape(4.dp)
                )

                Spacer(modifier = Modifier.height(8.dp))
                Text("Nombre : Azul", fontWeight = FontWeight.Bold)
                
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("Esquema de vacunación actualizado : ")
                    Icon(Icons.Default.Warning, contentDescription = null, tint = Color(0xFFFBC02D), modifier = Modifier.size(20.dp))
                }

                Spacer(modifier = Modifier.height(12.dp))

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    border = BorderStroke(1.dp, Color.LightGray)
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .border(1.dp, Color.LightGray, RoundedCornerShape(4.dp))
                                .padding(8.dp)
                        ) {
                            Text("Esquema nutricional inteligente", textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
                        }
                        
                        Spacer(modifier = Modifier.height(8.dp))
                        InfoRow("Fecha de registro", "15/09/2024")
                        InfoRow("Peso", "300 kg")
                        InfoRow("Estado", "Desnutrida")
                        InfoRow("Foránea", "si")
                        InfoRow("Giro", "Carne")

                        Spacer(modifier = Modifier.height(12.dp))

                        TableAlimento()
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    border = BorderStroke(1.dp, Color.LightGray)
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .border(1.dp, Color.LightGray, RoundedCornerShape(4.dp))
                                .padding(8.dp)
                        ) {
                            Text("Progresión esperada", textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
                        }
                        
                        Spacer(modifier = Modifier.height(8.dp))
                        
                        Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth()) {
                            LegendItem(Color(0xFF5C6BC0), "Enfermedad")
                            LegendItem(Color(0xFFEC407A), "Peso")
                            LegendItem(Color(0xFF26A69A), "Malnutricion")
                        }

                        Spacer(modifier = Modifier.height(16.dp))
                        
                        Box(modifier = Modifier.fillMaxWidth().height(100.dp)) {
                            Text("Gráfica de líneas aquí", modifier = Modifier.align(Alignment.Center), color = Color.LightGray, fontSize = 10.sp)
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        FooterSection("Tiempo estimado para venta con maxima ganancia : 6 meses ... ", "VER MAS")
        Spacer(modifier = Modifier.height(8.dp))
        FooterSection("Historial de alimentación:", null)
    }
}

@Composable
fun IconNavButton(icon: ImageVector, color: Color, isSelected: Boolean = false, onClick: () -> Unit) {
    Surface(
        onClick = onClick,
        shape = CircleShape,
        color = color,
        modifier = Modifier.size(40.dp),
        shadowElevation = if (isSelected) 4.dp else 0.dp
    ) {
        Box(contentAlignment = Alignment.Center) {
            Icon(icon, contentDescription = null, tint = Color.White, modifier = Modifier.size(24.dp))
            if (isSelected) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .border(2.dp, Color.White.copy(alpha = 0.5f), CircleShape)
                )
            }
        }
    }
}

@Composable
fun InfoRow(label: String, value: String) {
    Row(modifier = Modifier.fillMaxWidth().padding(vertical = 2.dp)) {
        Text(label, modifier = Modifier.weight(1.5f), fontSize = 14.sp)
        Text(": $value", modifier = Modifier.weight(1f), fontSize = 14.sp)
    }
}

@Composable
fun TableAlimento() {
    Column(modifier = Modifier.border(1.dp, Color.LightGray, RoundedCornerShape(4.dp))) {
        Row(modifier = Modifier.background(Color.White).padding(8.dp)) {
            Text("Alimento", modifier = Modifier.weight(1f), fontWeight = FontWeight.Bold, fontSize = 12.sp)
            Text("Cantidad", modifier = Modifier.weight(1f), fontWeight = FontWeight.Bold, fontSize = 12.sp)
            Text("Frecuencia", modifier = Modifier.weight(1f), fontWeight = FontWeight.Bold, fontSize = 12.sp)
        }
        HorizontalDivider(color = Color.LightGray)
        Row(modifier = Modifier.padding(8.dp)) {
            Text("Maíz", modifier = Modifier.weight(1f), fontSize = 12.sp)
            Text("10 kg", modifier = Modifier.weight(1f), fontSize = 12.sp)
            Text("6 hrs X 6 S", modifier = Modifier.weight(1f), fontSize = 12.sp)
        }
    }
}

@Composable
fun LegendItem(color: Color, text: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Box(modifier = Modifier.size(8.dp).background(color, CircleShape))
        Spacer(modifier = Modifier.width(4.dp))
        Text(text, fontSize = 10.sp)
    }
}

@Composable
fun FooterSection(text: String, linkText: String?) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        border = BorderStroke(1.dp, Color.LightGray),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(buildAnnotatedString {
                append(text)
                if (linkText != null) {
                    withStyle(style = SpanStyle(color = Color(0xFF2196F3), textDecoration = TextDecoration.Underline)) {
                        append(linkText)
                    }
                }
            }, fontSize = 13.sp)
        }
    }
}
