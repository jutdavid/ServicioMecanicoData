package com.example.serviciomecanicodata

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

// --- PANTALLA 1: INICIO ---
@Composable
fun ServicioMecanicoHomeScreen(onVerCatalogoClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = Icons.Default.Settings,
            contentDescription = "Logo Mecánica",
            modifier = Modifier.size(120.dp),
            tint = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "Taller Mecánico Express",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Explora nuestros servicios de reparación y mantenimiento vehicular.",
            textAlign = androidx.compose.ui.text.style.TextAlign.Center
        )
        Spacer(modifier = Modifier.height(32.dp))
        Button(onClick = onVerCatalogoClick) {
            Text(text = "VER CATÁLOGO")
        }
    }
}

// --- PANTALLA 2: CATÁLOGO ---
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ServicioMecanicoCatalogScreen(
    servicios: List<ServicioMecanico>,
    onServicioClick: (ServicioMecanico) -> Unit,
    onBackClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Catálogo de Servicios") },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Volver")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            item { Spacer(modifier = Modifier.height(8.dp)) }
            items(servicios) { servicio ->
                ServicioMecanicoItem(
                    servicio = servicio,
                    onClick = { onServicioClick(servicio) }
                )
            }
        }
    }
}

// Componente Composable Reutilizable para la lista (Item)
@Composable
fun ServicioMecanicoItem(servicio: ServicioMecanico, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // IMAGEN CON COIL
            AsyncImage(
                model = servicio.imagenUrl,
                contentDescription = "Imagen de ${servicio.nombre}",
                modifier = Modifier
                    .size(70.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(text = servicio.nombre, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Text(text = servicio.descripcionCorta, style = MaterialTheme.typography.bodyMedium)
                Text(text = "$${servicio.precio}", color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Bold)
            }
        }
    }
}

// --- PANTALLA 3: DETALLE ---
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ServicioMecanicoDetailScreen(
    servicio: ServicioMecanico,
    onBackClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Detalle del Servicio") },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Volver")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            )
        }
    ) { paddingValues ->
        // AQUÍ ESTÁ EL SCROLL APLICADO
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // IMAGEN GRANDE CON COIL
            AsyncImage(
                model = servicio.imagenUrl,
                contentDescription = "Detalle de ${servicio.nombre}",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(24.dp))
            Text(text = servicio.nombre, fontSize = 26.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            Card(
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = "Costo Estimado:", fontWeight = FontWeight.Bold)
                    Text(text = "$${servicio.precio}", fontSize = 20.sp, color = MaterialTheme.colorScheme.primary)
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = "Descripción Detallada:", fontWeight = FontWeight.Bold)
                    Text(text = servicio.descripcionCompleta)
                }
            }
        }
    }
}

// --- PREVIEWS OBLIGATORIOS ---
@Preview(showBackground = true)
@Composable
fun PreviewServicioMecanicoItem() {
    ServicioMecanicoItem(
        servicio = listaServiciosDummy[0],
        onClick = {}
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewServicioMecanicoDetailScreen() {
    ServicioMecanicoDetailScreen(
        servicio = listaServiciosDummy[0],
        onBackClick = {}
    )
}