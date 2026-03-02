package com.saif.dpm1.ui.theme

import androidx.compose.ui.graphics.Color

// Colores principales (Morado, Rojo y Azul)
val PrimaryPurple = Color(0xFF9C27B0)        // Morado vibrante
val PrimaryRed = Color(0xFFB71C1C)           // Rojo elegante
val PrimaryBlue = Color(0xFF0D47A1)          // Azul corporativo

// Variantes (tonalidades)
val PurpleLight = Color(0xFFF3E5F5)          // Morado muy claro (fondo)
val PurpleMedium = Color(0xFFBA68C8)         // Morado medio (para variantes)
val RedLight = Color(0xFFFFCDD2)              // Rojo muy claro (fondo)
val RedMedium = Color(0xFFE57373)             // Rojo medio (para variantes)
val BlueLight = Color(0xFFE3F2FD)             // Azul muy claro (fondo)
val BlueMedium = Color(0xFF64B5F6)            // Azul medio (para variantes)

// Tonos oscuros
val PurpleDark = Color(0xFF6A1B9A)            // Morado oscuro
val RedDark = Color(0xFF8B0000)                // Rojo oscuro
val BlueDark = Color(0xFF0A3569)               // Azul mas profundo

// Definicion de roles (como se usaran)
val Primary = PrimaryPurple                    // Color principal: Morado
val Secondary = PrimaryRed                     // Color secundario: Rojo
val Tertiary = PrimaryBlue                     // Color terciario: Azul

// Variantes por rol
val PrimaryVariant = PurpleDark                // Morado oscuro
val SecondaryVariant = RedDark                  // Rojo oscuro
val TertiaryVariant = BlueDark                  // Azul oscuro

// Colores neutros (fondos, textos)
val Background = Color(0xFFF8F9FA)             // Casi blanco (fondo general)
val Surface = Color(0xFFFFFFFF)                 // Blanco puro (tarjetas)
val SurfaceVariant = PurpleLight                // Fondo con toque morado suave
val SurfaceRed = RedLight                       // Fondo con toque rojo suave
val SurfaceBlue = BlueLight                     // Fondo con toque azul suave

// Colores de texto
val OnPrimary = Color(0xFFFFFFFF)               // Texto blanco sobre morado
val OnSecondary = Color(0xFFFFFFFF)             // Texto blanco sobre rojo
val OnTertiary = Color(0xFFFFFFFF)              // Texto blanco sobre azul
val OnBackground = Color(0xFF1A1A1A)            // Texto oscuro sobre fondo claro
val OnSurface = Color(0xFF1A1A1A)               // Texto oscuro sobre superficies
val OnSurfaceVariant = PrimaryPurple            // Texto morado sobre fondo claro
val HintText = Color(0xFF757575)                 // Texto de ayuda (gris)

// Componentes de formulario
val InputBackground = Color(0xFFF5F5F5)         // Fondo de inputs
val InputBorder = Color(0xFFE0E0E0)             // Borde normal
val InputBorderFocused = PrimaryPurple          // Borde morado al enfocar
val InputBorderError = PrimaryRed               // Borde rojo si hay error
val Placeholder = Color(0xFF9E9E9E)             // Texto placeholder
val Divider = Color(0xFFE0E0E0)                 // Lineas divisorias

// Checkbox y Radio buttons
val CheckboxChecked = PrimaryPurple             // Morado cuando esta marcado
val CheckboxUnchecked = Color(0xFF757575)       // Gris cuando no
val RadioSelected = PrimaryPurple                // Morado cuando seleccionado
val RadioUnselected = Color(0xFF757575)         // Gris cuando no

// Botones
val ButtonPrimary = PrimaryPurple                // Boton principal morado
val ButtonPrimaryHover = PurpleDark              // Morado oscuro al pasar mouse
val ButtonSecondary = PrimaryRed                 // Boton secundario rojo
val ButtonSecondaryHover = RedDark               // Rojo oscuro al pasar mouse
val ButtonTertiary = PrimaryBlue                 // Boton terciario azul
val ButtonTertiaryHover = BlueDark               // Azul oscuro al pasar mouse
val ButtonDisabled = Color(0xFFCCCCCC)           // Boton deshabilitado

// Colores de estado
val Success = Color(0xFF2E7D32)                  // Verde oscuro
val SuccessLight = Color(0xFFA5D6A7)             // Verde claro (fondo)
val Error = PrimaryRed                           // Rojo para errores
val ErrorLight = RedLight                         // Rojo claro (fondo error)
val Info = PrimaryBlue                           // Azul para informacion
val InfoLight = BlueLight                         // Azul claro (fondo info)
val Warning = Color(0xFFFF6F00)                  // Ambar/naranja
val WarningLight = Color(0xFFFFE082)             // Ambar claro

// Gradientes (para efectos visuales)
val GradientPurpleRed = listOf(PrimaryPurple, PrimaryRed)
val GradientPurpleBlue = listOf(PrimaryPurple, PrimaryBlue)
val GradientRedBlue = listOf(PrimaryRed, PrimaryBlue)
val GradientLightPurple = listOf(PurpleLight, PurpleMedium)

// Sombras y efectos
val ShadowColor = Color(0x33000000)              // Sombra negra semitransparente
val OverlayColor = Color(0x1A000000)             // Overlay semitransparente