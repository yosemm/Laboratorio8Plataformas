package com.uvg.laboratorio8.ui.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.SupportAgent
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.uvg.laboratorio8.R
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(onNavigationIconClick: () -> Unit = {}, onMailIconClick: () -> Unit = {}) {
    CenterAlignedTopAppBar(
        title = {
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Image(
                    painter = painterResource(id = R.drawable.gyt_logo),
                    contentDescription = "G&T Continental logo",
                    modifier = Modifier.height(36.dp)
                )
            }
        }, navigationIcon = {
            IconButton(onClick = onNavigationIconClick) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "Menú de navegación",
                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }, actions = {
            IconButton(onClick = onMailIconClick) {
                Icon(
                    imageVector = Icons.Filled.Mail,
                    contentDescription = "Mensajes",
                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }, colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.inversePrimary
        )
    )
}


// Aqui le pedi ayuda a la IA, para que me diera una explicacion y me ayudara a desplegar un navigation drawer desde la top bar.
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuTopBar(
    onMailIconClick: () -> Unit = {}, screenContent: @Composable () -> Unit
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    val drawerItemColors = NavigationDrawerItemDefaults.colors(
        unselectedContainerColor = MaterialTheme.colorScheme.primary,
        unselectedIconColor = MaterialTheme.colorScheme.onPrimary,
        unselectedTextColor = MaterialTheme.colorScheme.onPrimary,
        selectedContainerColor = MaterialTheme.colorScheme.primary,
        selectedIconColor = MaterialTheme.colorScheme.onPrimary,
        selectedTextColor = MaterialTheme.colorScheme.onPrimary
    )

    ModalNavigationDrawer(
        drawerState = drawerState, drawerContent = {
            ModalDrawerSheet(
                drawerContainerColor = Color.White
            ) {
                Column {
                    Spacer(Modifier.height(12.dp))

                    NavigationDrawerItem(
                        icon = { Icon(Icons.Filled.Settings, contentDescription = "Servicios") },
                        label = {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text("Servicios"); Icon(
                                Icons.Filled.ArrowDropDown,
                                contentDescription = "Desplegar servicios"
                            )
                            }
                        },
                        selected = false,
                        onClick = { scope.launch { drawerState.close() } },
                        colors = drawerItemColors,
                        shape = RectangleShape
                    )
                    Text(
                        text = "  Recargas móviles",
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 56.dp, top = 8.dp, bottom = 8.dp, end = 8.dp)
                            .clickable { scope.launch { drawerState.close() } })
                    Text(
                        text = "  Alertas y notificaciones",
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 56.dp, top = 8.dp, bottom = 8.dp, end = 8.dp)
                            .clickable { scope.launch { drawerState.close() } })

                    Spacer(Modifier.height(8.dp))

                    NavigationDrawerItem(
                        icon = {
                            Icon(
                                Icons.Filled.Description, contentDescription = "Solicitudes"
                            )
                        },
                        label = {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text("Solicitudes"); Icon(
                                Icons.Filled.ArrowDropDown,
                                contentDescription = "Desplegar solicitudes"
                            )
                            }
                        },
                        selected = false,
                        onClick = { scope.launch { drawerState.close() } },
                        colors = drawerItemColors,
                        shape = RectangleShape
                    )
                    Text(
                        text = "  Productos nuevos (cuentas, tarjetas)",
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 56.dp, top = 8.dp, bottom = 8.dp, end = 8.dp)
                            .clickable { scope.launch { drawerState.close() } })
                    Text(
                        text = "  Chequeras",
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 56.dp, top = 8.dp, bottom = 8.dp, end = 8.dp)
                            .clickable { scope.launch { drawerState.close() } })
                    Text(
                        text = "  Créditos y préstamos",
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 56.dp, top = 8.dp, bottom = 8.dp, end = 8.dp)
                            .clickable { scope.launch { drawerState.close() } })

                    Spacer(Modifier.height(8.dp))

                    NavigationDrawerItem(
                        icon = {
                            Icon(
                                Icons.Filled.Build,
                                contentDescription = "Gestiones"
                            )
                        },
                        label = {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text("Gestiones"); Icon(
                                Icons.Filled.ArrowDropDown,
                                contentDescription = "Desplegar gestiones"
                            )
                            }
                        },
                        selected = false,
                        onClick = { scope.launch { drawerState.close() } },
                        colors = drawerItemColors,
                        shape = RectangleShape
                    )
                    Text(
                        text = "  Seguridad (cambio de PIN, bloqueo/desbloqueo de tarjetas)",
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 56.dp, top = 8.dp, bottom = 8.dp, end = 8.dp)
                            .clickable { scope.launch { drawerState.close() } })
                    Text(
                        text = "  Configuración de montos y límites",
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 56.dp, top = 8.dp, bottom = 8.dp, end = 8.dp)
                            .clickable { scope.launch { drawerState.close() } })
                    Text(
                        text = "  Actualización de datos personales",
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 56.dp, top = 8.dp, bottom = 8.dp, end = 8.dp)
                            .clickable { scope.launch { drawerState.close() } })

                    Spacer(Modifier.height(8.dp))

                    NavigationDrawerItem(
                        icon = {
                            Icon(
                                Icons.Filled.SupportAgent, contentDescription = "Atención Virtual"
                            )
                        },
                        label = { Text("Atención Virtual") },
                        selected = false,
                        onClick = { scope.launch { drawerState.close() } },
                        colors = drawerItemColors,
                        shape = RectangleShape
                    )
                    Spacer(Modifier.weight(1f))
                }
            }
        }) {
        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    title = {
                        Box(
                            modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.gyt_logo),
                                contentDescription = "G&T Continental logo",
                                modifier = Modifier.height(36.dp)
                            )
                        }
                    }, navigationIcon = {
                        IconButton(onClick = { scope.launch { drawerState.open() } }) {
                            Icon(
                                imageVector = Icons.Filled.Menu,
                                contentDescription = "Abrir menú lateral",
                                tint = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }, actions = {
                        IconButton(onClick = onMailIconClick) {
                            Icon(
                                imageVector = Icons.Filled.Mail,
                                contentDescription = "Mensajes",
                                tint = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }, colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.inversePrimary
                    )
                )
            }) { paddingValues ->
            Box(modifier = Modifier.padding(paddingValues)) {
                screenContent()
            }
        }
    }
}
