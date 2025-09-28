package com.uvg.laboratorio8.ui.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uvg.laboratorio8.R
import com.uvg.laboratorio8.ui.theme.Laboratorio8Theme

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

@Preview(showBackground = true)
@Composable
fun AppTopBarPreview() {
    Laboratorio8Theme {
        AppTopBar()
    }
}