package com.uvg.laboratorio8.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.QrCodeScanner
import androidx.compose.material.icons.filled.Savings
import androidx.compose.material.icons.filled.SwapHoriz
import androidx.compose.ui.graphics.vector.ImageVector
import com.uvg.laboratorio8.ui.screens.Screen

data class BottomNavItem(
    val label: String, val icon: ImageVector, val route: String
)

val bottomNavItems = listOf(
    BottomNavItem("Inicio", Icons.Filled.Home, Screen.Inicio.route),
    BottomNavItem("Pagos", Icons.Filled.AccountBalance, Screen.Pagos.route),
    BottomNavItem("Transferir", Icons.Filled.SwapHoriz, Screen.Transferencias.route),
    BottomNavItem("Ahorros", Icons.Filled.Savings, Screen.Ahorros.route),
    BottomNavItem("QR", Icons.Filled.QrCodeScanner, Screen.QR.route)
)
