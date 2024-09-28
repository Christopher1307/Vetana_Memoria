Aquí tienes un ejemplo de un archivo **README** para tu programa:

---

# Ventana Con Memoria

**Ventana Con Memoria** es una aplicación JavaFX que permite al usuario ajustar los valores de color (Rojo, Verde, Azul) a través de deslizadores. El tamaño y la posición de la ventana, así como los valores de los colores seleccionados, se almacenan cuando el programa se cierra y se restauran al volver a abrirlo.

## Características

- **Control de colores RGB:** El usuario puede modificar el color de fondo de la ventana usando deslizadores que controlan los valores de Rojo, Verde y Azul.
- **Persistencia de configuración:** La aplicación guarda el tamaño, la posición de la ventana y los valores de los colores seleccionados en un archivo de configuración (`config.properties`) ubicado en la carpeta del perfil de usuario.
- **Interfaz gráfica:** La interfaz permite ajustar fácilmente los valores de color usando deslizadores con etiquetas descriptivas para cada componente RGB.

## Requisitos

- Java JDK 8 o superior
- JavaFX SDK (incluido en JDK 8 en adelante o descargado por separado para JDK superiores)

## Estructura del Proyecto

```
src/
└── ventanaconmemoria/
    ├── VentanaConMemoriaApp.java  // Clase principal que define la lógica de la aplicación
    └── config.properties          // Archivo de configuración que almacena el estado de la ventana (generado automáticamente)
```

## Instalación y Ejecución

### Paso 1: Clonar el Repositorio

Clona este repositorio en tu máquina local:

```bash
git clone https://github.com/tu_usuario/ventana-con-memoria.git
```

### Paso 2: Configurar JavaFX

Si usas una versión de Java superior a 8, es posible que necesites agregar el SDK de JavaFX manualmente. Descarga JavaFX desde la página oficial: https://openjfx.io/

Asegúrate de configurar correctamente el **path** de JavaFX en tu IDE (como IntelliJ o Eclipse) o cuando ejecutes desde la línea de comandos:

```bash
java --module-path /path/to/javafx-sdk/lib --add-modules=javafx.controls,javafx.fxml -jar VentanaConMemoria.jar
```

### Paso 3: Ejecutar el Programa

Puedes compilar y ejecutar el programa desde un IDE como IntelliJ, Eclipse, o también usando comandos de compilación y ejecución desde la terminal.

#### Compilar:
```bash
javac -d out src/ventanaconmemoria/VentanaConMemoriaApp.java
```

#### Ejecutar:
```bash
java -cp out ventanaconmemoria.VentanaConMemoriaApp
```

## Uso

1. **Deslizadores RGB:** Usa los tres deslizadores disponibles para ajustar el color de fondo de la ventana. Los deslizadores ajustan los valores de Rojo, Verde y Azul (RGB) entre 0 y 255.
   
2. **Posición y tamaño de la ventana:** Puedes mover y redimensionar la ventana. Cuando cierres la aplicación, se almacenará la posición, tamaño y color seleccionados en un archivo de configuración.

3. **Archivo de configuración:** El archivo `config.properties` se genera automáticamente en la carpeta `.VentanaConMemoria` dentro del directorio del perfil del usuario. Si eliminas este archivo, la próxima vez que ejecutes la aplicación, se restablecerán los valores predeterminados.

## Almacenamiento de Configuración

El archivo de configuración se almacena en:

- **Windows:** `C:\Users\TuUsuario\.VentanaConMemoria\config.properties`
- **Linux/Mac:** `/home/TuUsuario/.VentanaConMemoria/config.properties`

Este archivo almacena las siguientes propiedades:

- `size.width`: Ancho de la ventana
- `size.height`: Alto de la ventana
- `size.x`: Posición X de la ventana
- `size.y`: Posición Y de la ventana
- `background.red`: Valor del color rojo
- `background.green`: Valor del color verde
- `background.blue`: Valor del color azul

## Contribuciones

Las contribuciones son bienvenidas. Puedes crear issues para reportar errores o sugerir nuevas características. También puedes hacer un fork del proyecto y enviar pull requests.

## Licencia

Este proyecto está bajo la licencia MIT. Puedes ver más detalles en el archivo [LICENSE](LICENSE).

---

Con este **README**, cualquier usuario o desarrollador que quiera utilizar o contribuir a tu proyecto tendrá una comprensión clara de su propósito, cómo usarlo y cómo ejecutarlo.
