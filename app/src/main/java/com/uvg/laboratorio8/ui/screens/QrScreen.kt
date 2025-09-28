package com.uvg.laboratorio8.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.PhotoLibrary
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun QrScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            QrTabButton(text = "ESCANEAR", isSelected = true) {}
            QrTabButton(text = "CREAR", isSelected = false) {}
            QrTabButton(text = "HISTORIAL", isSelected = false) {}
        }

        Spacer(modifier = Modifier.height(24.dp))

        ScanQrContent()
    }
}

@Composable
fun QrTabButton(text: String, isSelected: Boolean, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(50),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface,
            contentColor = if (isSelected) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.primary
        ),
        border = if (!isSelected) BorderStroke(1.dp, MaterialTheme.colorScheme.primary) else null,
        modifier = Modifier.padding(horizontal = 4.dp)
    ) {
        Text(text, fontSize = 12.sp)
        Spacer(modifier = Modifier.width(4.dp))
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
            contentDescription = null,
            modifier = Modifier.size(12.dp)
        )
    }
}

@Composable
fun ScanQrContent() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Utiliza el QR para recibir pagos instantáneos",
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Card(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .aspectRatio(1f),
            shape = RoundedCornerShape(8.dp),
            border = BorderStroke(2.dp, Color.Black),
            elevation = CardDefaults.cardElevation(0.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(4.dp), contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        "SCAN HERE",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "TOCA AQUÍ PARA ESCANEAR EL CÓDIGO",
                        textAlign = TextAlign.Center,
                        fontSize = 16.sp,
                        color = Color.Black
                    )
                }

                // Aquí le solicité ayuda a la IA para ayudar a hacer que pareciera un scanner de QR.

                val lBarLength = 40.dp
                val lBarThickness = 6.dp
                val bracketColor = Color.Black
                val armCornerRadius = lBarThickness / 2

                Box(Modifier.align(Alignment.TopStart)) {
                    Box(
                        Modifier
                            .width(lBarLength)
                            .height(lBarThickness)
                            .clip(RoundedCornerShape(armCornerRadius))
                            .background(bracketColor)
                    )
                    Box(
                        Modifier
                            .width(lBarThickness)
                            .height(lBarLength)
                            .clip(RoundedCornerShape(armCornerRadius))
                            .background(bracketColor)
                    )
                }

                Box(Modifier.align(Alignment.TopEnd)) {
                    Box(
                        Modifier
                            .align(Alignment.TopEnd)
                            .width(lBarLength)
                            .height(lBarThickness)
                            .clip(RoundedCornerShape(armCornerRadius))
                            .background(bracketColor)
                    )
                    Box(
                        Modifier
                            .align(Alignment.TopEnd)
                            .width(lBarThickness)
                            .height(lBarLength)
                            .clip(RoundedCornerShape(armCornerRadius))
                            .background(bracketColor)
                    )
                }

                Box(Modifier.align(Alignment.BottomStart)) {
                    Box(
                        Modifier
                            .align(Alignment.BottomStart)
                            .width(lBarLength)
                            .height(lBarThickness)
                            .clip(RoundedCornerShape(armCornerRadius))
                            .background(bracketColor)
                    )
                    Box(
                        Modifier
                            .align(Alignment.BottomStart)
                            .width(lBarThickness)
                            .height(lBarLength)
                            .clip(RoundedCornerShape(armCornerRadius))
                            .background(bracketColor)
                    )
                }

                Box(Modifier.align(Alignment.BottomEnd)) {
                    Box(
                        Modifier
                            .align(Alignment.BottomEnd)
                            .width(lBarLength)
                            .height(lBarThickness)
                            .clip(RoundedCornerShape(armCornerRadius))
                            .background(bracketColor)
                    )
                    Box(
                        Modifier
                            .align(Alignment.BottomEnd)
                            .width(lBarThickness)
                            .height(lBarLength)
                            .clip(RoundedCornerShape(armCornerRadius))
                            .background(bracketColor)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically, modifier = Modifier.clickable {}) {
            Icon(
                imageVector = Icons.Filled.PhotoLibrary,
                contentDescription = "Seleccionar imagen",
                tint = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                "SELECCIONAR UNA IMAGEN",
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Medium
            )
        }
    }
}