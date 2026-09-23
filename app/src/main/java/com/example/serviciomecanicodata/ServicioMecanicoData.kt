package com.example.serviciomecanicodata

data class ServicioMecanico(
    val id: Int,
    val nombre: String,
    val descripcionCorta: String,
    val descripcionCompleta: String,
    val precio: Double,
    val imagenUrl: String
)

// 2. Datos Dummy Al menos 6 registros)
val listaServiciosDummy = listOf(
    ServicioMecanico(
        id = 1,
        nombre = "Cambio de Aceite",
        descripcionCorta = "Aceite sintético y filtro",
        descripcionCompleta = "Servicio completo de cambio de aceite utilizando aceite 100% sintético de alta calidad. Incluye cambio de filtro, revisión de niveles de fluidos y ajuste de presión de llantas.",
        precio = 45.50,
        imagenUrl = "https://automagazine.ec/wp-content/uploads/2018/10/Cambio-Aceite-Renault-800x445.jpg"
    ),
    ServicioMecanico(
        id = 2,
        nombre = "Alineación y Balanceo",
        descripcionCorta = "Para las 4 ruedas",
        descripcionCompleta = "Alineación computarizada 3D para las cuatro ruedas, balanceo dinámico y rotación de neumáticos para extender la vida útil de tus llantas.",
        precio = 35.00,
        imagenUrl = "https://static.wixstatic.com/media/9988e4_ba51898513314018ba058dece64a6b33~mv2.jpg/v1/fill/w_1000,h_750,al_c,q_85,usm_0.66_1.00_0.01/9988e4_ba51898513314018ba058dece64a6b33~mv2.jpg"
    ),
    ServicioMecanico(
        id = 3,
        nombre = "Revisión de Frenos",
        descripcionCorta = "Cambio de pastillas y rectificación",
        descripcionCompleta = "Inspección completa del sistema de frenado. Incluye cambio de pastillas delanteras de cerámica, rectificación de discos y purga del líquido de frenos.",
        precio = 80.00,
        imagenUrl = "https://motor.elpais.com/wp-content/uploads/2019/09/Frenos.jpg"
    ),
    ServicioMecanico(
        id = 4,
        nombre = "Escaneo Computarizado",
        descripcionCorta = "Diagnóstico de Check Engine",
        descripcionCompleta = "Conexión de escáner OBD2 avanzado para leer códigos de falla del motor, transmisión, ABS y Airbag. Se entrega reporte detallado.",
        precio = 25.00,
        imagenUrl = "https://cloudfront-us-east-1.images.arcpublishing.com/infobae/PPHK6I2MG5EX7HRDA7XGIJJX3I.jpg"
    ),
    ServicioMecanico(
        id = 5,
        nombre = "Mantenimiento Aire Acondicionado",
        descripcionCorta = "Recarga de gas y limpieza",
        descripcionCompleta = "Limpieza de ductos, cambio de filtro de cabina, detección de fugas y recarga completa de gas refrigerante R134a o R1234yf.",
        precio = 60.00,
        imagenUrl = "https://revoshop.com.pe/wp-content/uploads/2023/03/blog51.png"
    ),
    ServicioMecanico(
        id = 6,
        nombre = "Cambio de Batería",
        descripcionCorta = "Instalación y revisión del alternador",
        descripcionCompleta = "Reemplazo de batería a domicilio o en taller. Incluye limpieza de bornes, instalación y prueba de carga del alternador para asegurar el funcionamiento.",
        precio = 110.00,
        imagenUrl = "https://www.karway.ec/blog/wp-content/uploads/2025/05/alargar-la-vida-util-de-la-bateria-de-tu-auto-.jpg"
    )
)