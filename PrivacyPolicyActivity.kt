package com.huante.organizer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.huante.organizer.ui.theme.OrganizadorNotasTheme

class PrivacyPolicyActivity : ComponentActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        setContent {
            OrganizadorNotasTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PrivacyPolicyScreen(
                        onBack = {
                            finish()
                        }
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrivacyPolicyScreen(
    onBack: () -> Unit
) {
    val scrollState = rememberScrollState()
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Política de Privacidad") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Volver")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(scrollState)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Header
            Text(
                text = "POLÍTICA DE PRIVACIDAD",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            
            Text(
                text = "Organizador de Notas Personales",
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.fillMaxWidth()
            )
            
            HorizontalDivider()
            
            // Last Updated
            Text(
                text = "Última actualización: ${getCurrentDate()}",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            
            // Introduction
            PrivacySection(
                title = "1. INTRODUCCIÓN",
                content = """
                    En el Organizador de Notas Personales, respetamos y protegemos la privacidad de nuestros usuarios. Esta Política de Privacidad explica cómo recopilamos, usamos, almacenamos y protegemos su información personal cuando utiliza nuestra aplicación.
                    
                    Esta aplicación está diseñada para ayudar a los usuarios a organizar y gestionar sus notas personales, recordatorios y documentos de manera privada y segura.
                """.trimIndent()
            )
            
            // Data Collection
            PrivacySection(
                title = "2. INFORMACIÓN QUE RECOPILAMOS",
                content = """
                    2.1 INFORMACIÓN DE CUENTA:
                    - Dirección de correo electrónico (para autenticación)
                    - Información de autenticación (contraseña encriptada)
                    - Fecha de creación de la cuenta
                    
                    2.2 CONTENIDO DE NOTAS PERSONALES:
                    - Texto de sus notas personales y recordatorios
                    - Imágenes adjuntas a las notas (si las agrega)
                    - Fechas de creación y modificación de las notas
                    - Categorías y etiquetas personalizadas
                    - Listas de tareas y elementos de planificación
                    
                    2.3 INFORMACIÓN TÉCNICA:
                    - Información del dispositivo (modelo, sistema operativo)
                    - Metadatos de uso de la aplicación
                    - Registros de errores (para mejorar la aplicación)
                    
                    2.4 LO QUE NO RECOPILAMOS:
                    - No accedemos al contenido de sus notas con fines comerciales
                    - No recopilamos información de contactos sin su permiso
                    - No rastreamos su ubicación
                    - No accedemos a otras aplicaciones en su dispositivo
                """.trimIndent()
            )
            
            // Data Usage
            PrivacySection(
                title = "3. CÓMO USAMOS SU INFORMACIÓN",
                content = """
                    3.1 PROPORCIONAR EL SERVICIO:
                    - Almacenar y sincronizar sus notas personales
                    - Permitir el acceso seguro a su contenido
                    - Proporcionar funciones de búsqueda y organización
                    - Crear copias de seguridad de sus datos
                    
                    3.2 MEJORAR LA APLICACIÓN:
                    - Analizar patrones de uso para mejorar funcionalidades
                    - Identificar y corregir errores técnicos
                    - Desarrollar nuevas características basadas en necesidades de usuarios
                    
                    3.3 COMUNICACIÓN CON EL USUARIO:
                    - Enviar notificaciones importantes sobre la aplicación
                    - Informar sobre actualizaciones de seguridad
                    - Responder a consultas de soporte técnico
                    
                    3.4 NUNCA USAMOS SUS DATOS PARA:
                    - Vender su información a terceros
                    - Enviar publicidad no solicitada
                    - Compartir el contenido de sus notas con otros usuarios
                    - Crear perfiles publicitarios
                """.trimIndent()
            )
            
            // Data Sharing
            PrivacySection(
                title = "4. COMPARTIR INFORMACIÓN",
                content = """
                    4.1 POLÍTICA DE NO COMPARTIR:
                    - NO vendemos, alquilamos o compartimos sus datos personales con terceros para fines comerciales
                    - Sus notas personales son privadas y solo accesibles para usted
                    - No compartimos el contenido de sus notas con otros usuarios
                    
                    4.2 EXCEPCIONES LIMITADAS:
                    Podemos compartir información únicamente en estas situaciones excepcionales:
                    - Cuando lo autorice expresamente
                    - Para cumplir con órdenes judiciales válidas
                    - Para proteger la seguridad de usuarios o prevenir fraudes
                    - Con proveedores de servicios técnicos bajo estrictos acuerdos de confidencialidad
                    
                    4.3 PROVEEDORES DE SERVICIOS:
                    Trabajamos con proveedores confiables para:
                    - Servicios de almacenamiento en la nube (con cifrado)
                    - Autenticación de usuarios
                    - Análisis técnico de errores
                    Todos están obligados contractualmente a proteger su privacidad.
                """.trimIndent()
            )
            
            // Data Security
            PrivacySection(
                title = "5. SEGURIDAD DE SUS DATOS",
                content = """
                    5.1 CIFRADO:
                    - Todos los datos se cifran durante la transmisión (HTTPS/TLS)
                    - Los datos sensibles se cifran en el almacenamiento
                    - Las contraseñas se almacenan usando hash seguro
                    
                    5.2 ACCESO RESTRINGIDO:
                    - Solo personal autorizado puede acceder a sistemas con datos de usuario
                    - Implementamos autenticación de múltiples factores
                    - Registramos y monitoreamos todos los accesos
                    
                    5.3 MEDIDAS TÉCNICAS:
                    - Firewalls y sistemas de detección de intrusiones
                    - Actualizaciones regulares de seguridad
                    - Copias de seguridad encriptadas
                    - Pruebas regulares de seguridad
                    
                    5.4 MEDIDAS FÍSICAS:
                    - Servidores en centros de datos seguros
                    - Control de acceso físico restringido
                    - Sistemas de monitoreo 24/7
                """.trimIndent()
            )
            
            // User Rights
            PrivacySection(
                title = "6. SUS DERECHOS Y CONTROL",
                content = """
                    6.1 ACCESO Y CONTROL:
                    - Puede acceder a todos sus datos desde la aplicación
                    - Puede editar o eliminar sus notas en cualquier momento
                    - Puede exportar sus datos en formato estándar
                    - Puede eliminar su cuenta completamente
                    
                    6.2 SOLICITUDES DE PRIVACIDAD:
                    Puede solicitar:
                    - Una copia de todos sus datos personales
                    - Corrección de información incorrecta
                    - Eliminación de su cuenta y datos
                    - Restricción del procesamiento de datos
                    
                    6.3 TIEMPO DE RESPUESTA:
                    - Responderemos a sus solicitudes dentro de 30 días
                    - Las eliminaciones de datos se procesan inmediatamente
                    - Le proporcionaremos confirmación de las acciones tomadas
                """.trimIndent()
            )
            
            // Data Retention
            PrivacySection(
                title = "7. RETENCIÓN DE DATOS",
                content = """
                    7.1 MIENTRAS USE LA APLICACIÓN:
                    - Conservamos sus datos mientras su cuenta esté activa
                    - Sus notas se mantienen hasta que las elimine
                    - Los datos de respaldo se conservan por seguridad
                    
                    7.2 DESPUÉS DE ELIMINAR SU CUENTA:
                    - Eliminamos todos sus datos personales dentro de 30 días
                    - Algunos datos técnicos pueden conservarse de forma anónima
                    - Las copias de seguridad se eliminan según el cronograma de retención
                    
                    7.3 DATOS TÉCNICOS:
                    - Los registros de errores se conservan por 1 año
                    - Los datos de uso agregados se conservan indefinidamente (anónimos)
                    - Los datos de seguridad se conservan según sea necesario
                """.trimIndent()
            )
            
            // International Transfers
            PrivacySection(
                title = "8. TRANSFERENCIAS INTERNACIONALES",
                content = """
                    8.1 ALMACENAMIENTO DE DATOS:
                    - Sus datos pueden almacenarse en servidores seguros en diferentes países
                    - Utilizamos proveedores de nube confiables con certificaciones de seguridad
                    - Todos los datos están protegidos independientemente de su ubicación
                    
                    8.2 PROTECCIONES:
                    - Implementamos salvaguardas contractuales con todos los proveedores
                    - Cumplimos con estándares internacionales de protección de datos
                    - Sus datos mantienen el mismo nivel de protección en todos los países
                """.trimIndent()
            )
            
            // Children's Privacy
            PrivacySection(
                title = "9. PRIVACIDAD DE MENORES",
                content = """
                    Esta aplicación no está dirigida a menores de 13 años. No recopilamos conscientemente información personal de menores de 13 años. Si descubrimos que hemos recopilado información de un menor, eliminaremos inmediatamente esos datos.
                    
                    Los padres o tutores que crean que su hijo nos ha proporcionado información personal pueden contactarnos para solicitar la eliminación de esos datos.
                """.trimIndent()
            )
            
            // Changes to Policy
            PrivacySection(
                title = "10. CAMBIOS A ESTA POLÍTICA",
                content = """
                    10.1 NOTIFICACIÓN DE CAMBIOS:
                    - Le notificaremos sobre cambios significativos en esta política
                    - Los cambios se anunciarán en la aplicación con 30 días de anticipación
                    - Los cambios menores se indicarán actualizando la fecha de "última actualización"
                    
                    10.2 SU CONSENTIMIENTO:
                    - El uso continuado de la aplicación después de los cambios constituye aceptación
                    - Para cambios significativos, podemos solicitar su consentimiento explícito
                    - Siempre puede eliminar su cuenta si no está de acuerdo con los cambios
                """.trimIndent()
            )
            
            // Contact Information
            PrivacySection(
                title = "11. CONTACTO",
                content = """
                    Si tiene preguntas sobre esta Política de Privacidad o sobre cómo manejamos sus datos personales, puede contactarnos a través de:
                    
                    - La sección de configuración en la aplicación
                    - Nuestros canales oficiales de soporte
                    - El formulario de contacto en la aplicación
                    
                    Nos comprometemos a responder a todas las consultas sobre privacidad dentro de 30 días.
                """.trimIndent()
            )
            
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun PrivacySection(
    title: String,
    content: String
) {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )
        
        Text(
            text = content,
            style = MaterialTheme.typography.bodyMedium,
            lineHeight = MaterialTheme.typography.bodyMedium.lineHeight * 1.2
        )
    }
}