package com.example.serviciomecanicodata

import androidx.compose.runtime.*
// ESTE IMPORT ES EL SECRETO PARA SOBREVIVIR AL GIRO DE PANTALLA:
import androidx.compose.runtime.saveable.rememberSaveable

// Definimos las pantallas disponibles
enum class ServicioMecanicoPantallas {
    INICIO, CATALOGO, DETALLE
}

@Composable
fun ServicioMecanicoApp() {
    // 1. Cambiamos 'remember' por 'rememberSaveable'
    var pantallaActual by rememberSaveable { mutableStateOf(ServicioMecanicoPantallas.INICIO) }

    // 2. Para el giro de pantalla, es mejor guardar solo el ID (un número) del servicio
    // en lugar del objeto completo. rememberSaveable maneja los números perfectamente.
    var servicioSeleccionadoId by rememberSaveable { mutableStateOf<Int?>(null) }

    // Navegación manual
    when (pantallaActual) {
        ServicioMecanicoPantallas.INICIO -> {
            ServicioMecanicoHomeScreen(
                onVerCatalogoClick = { pantallaActual = ServicioMecanicoPantallas.CATALOGO }
            )
        }
        ServicioMecanicoPantallas.CATALOGO -> {
            ServicioMecanicoCatalogScreen(
                servicios = listaServiciosDummy,
                onServicioClick = { servicio ->
                    servicioSeleccionadoId = servicio.id // Guardamos el ID
                    pantallaActual = ServicioMecanicoPantallas.DETALLE
                },
                onBackClick = { pantallaActual = ServicioMecanicoPantallas.INICIO }
            )
        }
        ServicioMecanicoPantallas.DETALLE -> {
            // Buscamos el servicio en nuestra lista usando el ID que guardamos
            val servicioAMostrar = listaServiciosDummy.find { it.id == servicioSeleccionadoId }

            servicioAMostrar?.let { servicio ->
                ServicioMecanicoDetailScreen(
                    servicio = servicio,
                    onBackClick = { pantallaActual = ServicioMecanicoPantallas.CATALOGO }
                )
            }
        }
    }
}