# CRUD VETERIANRIA

## Descripción
Este proyecto es una aplicación de consola en Java que implementa un CRUD (Crear, Leer, Actualizar, Eliminar) para la gestión de usuarios en una veterinaria.

## Funcionalidades principales

- **Agregar Usuario:** Permite registrar un nuevo usuario solicitando datos como nombre, correo, teléfono, dirección, rol y contraseña.
- **Listar Usuarios:** Muestra en pantalla todos los usuarios registrados con sus datos principales.
- **Actualizar Usuario:** Permite modificar los datos de un usuario existente seleccionando el campo a actualizar (nombre, correo, teléfono, dirección, rol, contraseña o estado activo).
- **Eliminar Usuario:** Permite eliminar un usuario de la base de datos por su ID.
- **Salir:** Finaliza la aplicación de forma segura.

## Estructura del menú

El menú principal se muestra en consola con opciones numeradas y colores para facilitar la interacción:

1. Agregar Usuario
2. Listar Usuarios
3. Actualizar Usuario
4. Eliminar Usuario
5. Salir

## Tecnologías usadas
- Java (JDK 8+)
- JDBC (para conexión a base de datos, si aplica)
- ANSI escape codes (para colores en consola)

## Ejecución
Compila todos los archivos Java y ejecuta la clase `Main`. El sistema mostrará el menú interactivo en consola.

## Notas
- El sistema utiliza un enum para los roles de usuario (Administrador, Veterinario, Cliente).
- Las contraseñas se almacenan encriptadas para mayor seguridad.
- El campo de fecha de registro se almacena automáticamente al crear un usuario.
