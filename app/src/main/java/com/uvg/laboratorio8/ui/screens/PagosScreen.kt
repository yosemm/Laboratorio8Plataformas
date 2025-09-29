package com.uvg.laboratorio8.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ReceiptLong
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.MonetizationOn
import androidx.compose.material.icons.filled.Router
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class CategoriaPago(val nombre: String, val icono: ImageVector)

val categoriasPago = listOf(
    CategoriaPago("TARJETAS DE CRÉDITO", Icons.Filled.CreditCard),
    CategoriaPago("PRÉSTAMOS", Icons.Filled.MonetizationOn),
    CategoriaPago("SERVICIOS", Icons.AutoMirrored.Filled.ReceiptLong),
    CategoriaPago("TELEFONÍA", Icons.Filled.Router),
    CategoriaPago("DECLARACIONES", Icons.Filled.AccountBalance),
    CategoriaPago("FAVORITOS", Icons.Filled.Star)
)

@Composable
fun PagosScreen(modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        contentPadding = PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        items(categoriasPago) { categoria ->
            CategoriaCard(categoria = categoria)
        }
    }
}

@Composable
fun CategoriaCard(categoria: CategoriaPago, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.aspectRatio(1f),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
        colors = CardDefaults.cardColors(containerColor = colorScheme.surfaceBright)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = categoria.icono,
                contentDescription = categoria.nombre,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize(0.6f),
                tint = colorScheme.primary
            )
            Text(
                text = categoria.nombre,
                fontSize = 12.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 8.dp),
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                color = colorScheme.onPrimaryContainer
            )
        }
    }
}