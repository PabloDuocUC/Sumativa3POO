![Duoc UC](https://www.duoc.cl/wp-content/uploads/2022/09/logo-0.png)
# 🧠 Sumativa 3 Programacion orientada a objetos
# 👤 Autor del proyecto
Nombre completo: Pablo Nicolas Alonso Gallardo Gallardo

Carrera: Analista Programador

Sede: Sede Online

# 📘 Descripción general del sistema
Este proyecto corresponde a la Evaluación Sumativa 3 de la asignatura Desarrollo Orientado a Objetos I. Se trata de un sistema para una salmonera, cuyo objetivo es modelar y gestionar entidades representativas de la empresa salmonera Salmontt, aplicando los principios de encapsulamiento, herencia, polimorfismo e interfaces.

El sistema permite gestionar diferentes tipos de entidades operativas de la empresa, cargando datos desde archivos de texto y proporcionando una interfaz gráfica básica para la interacción.

# 🚀 Funcionalidades del sistema


# ✅ Lo que el sistema SÍ puede hacer:
📂 Carga automática desde archivos

Lee 4 archivos .txt con formato simple (campo1;campo2;campo3)

Carga centros de cultivo, plantas de proceso, proveedores y empleados

Validación básica del formato

🎭 Polimorfismo completo

Interfaz Registrable implementada por 4 clases diferentes

Método mostrarResumen() con implementaciones específicas

Lista List<Registrable> que almacena múltiples tipos

🧬 Herencia bien estructurada

Clase abstracta UnidadOperativa con atributos comunes

CentroCultivo y PlantaProceso heredan y especializan

Evita duplicación de código

🔍 Diferenciación con instanceof

Identifica el tipo específico de cada entidad en tiempo de ejecución

Permite lógica específica para cada tipo

Cumple con requisitos de la rúbrica

🖥️ Interfaz gráfica básica

Menú simple con 4 opciones

Permite agregar nuevos empleados y proveedores

Muestra resumen completo del sistema

Validación de entrada de datos

📊 Resumen y estadísticas

Cuenta entidades por tipo

Muestra lista completa

Total de entidades gestionadas

# ❌ Lo que el sistema NO puede hacer (limitaciones):

❌ No guarda datos persistentemente

Los datos agregados por GUI se pierden al cerrar el programa

No escribe en los archivos .txt

❌ Validaciones limitadas

Solo verifica formato básico en archivos

No valida rangos de valores (salarios negativos, etc.)

No verifica duplicados

❌ Manejo de errores simple

Excepciones básicas sin recuperación

Si falla un archivo, continúa sin esos datos

# ⚙️ Instrucciones para clonar y ejecutar el proyecto
1. Clona el repositorio desde GitHub:
git clone https://github.com/usuario/salmonttapp.git

2. Configura los archivos de datos:

Crea la carpeta archivos/ en la raíz del proyecto
Dentro, crea los 4 archivos .txt con el formato correcto

3. Abre el proyecto en IntelliJ IDEA:

Importa como proyecto Java existente
Verifica que la estructura de paquetes sea correcta

4. Compila desde terminal:
Ubícate en la carpeta src/
cd src/
# Compila todas las clases
javac -d . ui/Main.java model/*.java data/*.java ui/*.java

5. Ejecuta el programa:
Desde la misma ubicación
java ui.Main

# 🧪 Cómo probar el sistema
Prueba 1: Carga de archivos
✅ Verifica que aparezcan mensajes de carga en consola

Prueba 2: Uso de GUI
1. Selecciona "Agregar Empleado"
2. Ingresa datos válidos
3. Verifica que aparece mensaje de confirmación

Prueba 3: Resumen
1. Selecciona "Mostrar Resumen"
2. Verifica que aparezcan todos los tipos
3. Comprueba que los contadores sean correctos

Prueba 4: instanceof
✅ Mira la consola al iniciar - debe mostrar diferenciación por tipos

© Duoc UC | Escuela de Informática y Telecomunicaciones | Evaluación Final Transversal EFT
