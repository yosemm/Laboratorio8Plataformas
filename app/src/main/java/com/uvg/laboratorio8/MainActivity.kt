package com.uvg.laboratorio8

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.uvg.laboratorio8.ui.navigation.AppTopBar
import com.uvg.laboratorio8.ui.navigation.BottomNavigationBar
import com.uvg.laboratorio8.ui.navigation.MenuTopBar
import com.uvg.laboratorio8.ui.screens.AhorrosScreen
import com.uvg.laboratorio8.ui.screens.InicioScreen
import com.uvg.laboratorio8.ui.screens.LoginScreen
import com.uvg.laboratorio8.ui.screens.PagosScreen
import com.uvg.laboratorio8.ui.screens.QrScreen
import com.uvg.laboratorio8.ui.screens.Screen
import com.uvg.laboratorio8.ui.screens.TransferenciasScreen
import com.uvg.laboratorio8.ui.theme.Laboratorio8Theme

const val AUTH_GRAPH_ROUTE = "auth"
const val MAIN_APP_GRAPH_ROUTE = "main"

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Laboratorio8Theme {
                val navController = rememberNavController()
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentGraphRoute = navBackStackEntry?.destination?.parent?.route

                @Composable
                fun AppNavigation(modifier: Modifier = Modifier) {
                    NavHost(
                        navController = navController,
                        startDestination = AUTH_GRAPH_ROUTE,
                        modifier = modifier
                    ) {
                        navigation(
                            startDestination = Screen.Login.route, route = AUTH_GRAPH_ROUTE
                        ) {
                            composable(Screen.Login.route) {
                                LoginScreen(onLoginClick = {
                                    navController.navigate(MAIN_APP_GRAPH_ROUTE) {
                                        popUpTo(AUTH_GRAPH_ROUTE) { inclusive = true }
                                        launchSingleTop = true
                                    }
                                })
                            }
                        }
                        navigation(
                            startDestination = Screen.Inicio.route, route = MAIN_APP_GRAPH_ROUTE
                        ) {
                            composable(Screen.Inicio.route) { InicioScreen() }
                            composable(Screen.Pagos.route) { PagosScreen() }
                            composable(Screen.Transferencias.route) { TransferenciasScreen() }
                            composable(Screen.Ahorros.route) { AhorrosScreen() }
                            composable(Screen.QR.route) { QrScreen() }
                        }
                    }
                }

                if (currentGraphRoute == MAIN_APP_GRAPH_ROUTE) {
                    MenuTopBar(onMailIconClick = {}, screenContent = {
                        Scaffold(
                            bottomBar = { BottomNavigationBar(navController = navController) }) {
                            AppNavigation(modifier = Modifier.fillMaxSize())
                        }
                    })
                } else {
                    Scaffold(
                        modifier = Modifier.fillMaxSize(), topBar = {
                            AppTopBar(onNavigationIconClick = {}, onMailIconClick = {})
                        }) { innerPadding ->
                        AppNavigation(modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding))
                    }
                }
            }
        }
    }
}
