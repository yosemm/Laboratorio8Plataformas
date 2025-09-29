package com.uvg.laboratorio8.ui.screens

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Inicio : Screen("inicio")
    object Pagos : Screen("pagos")
    object Transferencias : Screen("transferencias")
    object Ahorros : Screen("ahorros")
    object QR : Screen("qr")
}