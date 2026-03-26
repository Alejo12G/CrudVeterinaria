// Declaración del paquete donde se encuentra esta clase
package crudveterinaria;

// Importa las clases necesarias
import java.util.List; // Permite el uso de listas
import java.util.Scanner; // Permite la entrada de datos por consola

import crudveterinaria.utils.Rol;

// Definición de la clase principal
public class Main {
    public static void main(String[] args) {
        // Crea un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        
        // Crea una instancia de UsuarioDAO, que maneja las operaciones CRUD
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        // Bucle infinito para mostrar el menú hasta que el usuario decida salir
        while (true) {
            // Muestra el menú de opciones en la consola
            System.out.println("\u001B[36m\n=== CRUD de Registro Usuarios ===\u001B[0m");
            System.out.println("\u001B[33m1. Agregar Usuario\u001B[0m");
            System.out.println("\u001B[33m2. Listar Usuarios\u001B[0m");
            System.out.println("\u001B[33m3. Actualizar Usuario\u001B[0m");
            System.out.println("\u001B[33m4. Eliminar Usuario\u001B[0m");
            System.out.println("\u001B[31m5. Salir\u001B[0m");
            System.out.println("\u001B[36mSeleccione una opción: \u001B[0m");
            
            // Lee la opción ingresada por el usuario
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpia el buffer del scanner después de leer un número
            
            // Estructura switch para manejar la opción seleccionada
            switch (opcion) {
                case 1:
                    // Opción para agregar un artista
                    System.out.print("\u001B[35mIngrese el nombre del usuario: \u001B[0m");
                    String nombre = scanner.nextLine(); // Lee el nombre del artista
                    System.out.print("\u001B[35mIngrese el correo del usuario: \u001B[0m");
                    String correo = scanner.nextLine(); // Lee el correo del usuario
                    System.out.print("\u001B[35mIngrese el teléfono del usuario: \u001B[0m");
                    String telefono = scanner.nextLine(); // Lee el teléfono del usuario
                    System.out.print("\u001B[35mIngrese la dirección del usuario: \u001B[0m");
                    String direccion = scanner.nextLine(); // Lee la dirección del usuario
                    System.out.print("\u001B[35mIngrese el rol del usuario (0: Administrador, 1: Veterinario, 2: Cliente): \u001B[0m");
                    String rol = scanner.nextLine(); // Lee el rol del usuario
                    System.out.print("\u001B[35mIngrese la contraseña del usuario: \u001B[0m");
                    String contraseña = scanner.nextLine(); // Lee la contraseña del usuario


                    // Crea un nuevo objeto Artista con los datos ingresados
                    Usuario nuevoUsuario = new Usuario(-1, nombre, correo, telefono, direccion, Rol.values()[Integer.parseInt(rol)], contraseña, true, java.time.LocalDateTime.now());
                    // Llama al método para agregar el artista en la base de datos
                    usuarioDAO.crearUsuario(nuevoUsuario);
                    System.out.println("\u001B[32m Usuario agregado exitosamente.\u001B[0m");
                    break;
                
                case 2:
                    // Opción para listar los artistas
                    List<Usuario> usuarios = usuarioDAO.obtenerUsuarios(); // Obtiene la lista de usuarios
                    System.out.println("\u001B[36m\n=== Lista de Usuarios ===\u001B[0m");
                    // Itera sobre la lista e imprime cada usuario
                    for (Usuario u : usuarios) {
                        System.out.println("\u001B[37m" + u.toString() + "\u001B[0m");
                    }
                    break;

                case 3:
                    // Opción para actualizar los datos de un artista
                    System.out.print("\u001B[35mIngrese el ID del usuario a actualizar: \u001B[0m");
                    int idActualizar = scanner.nextInt(); // Lee el ID del artista a actualizar
                    System.out.println("\u001B[34m---------------------------------\u001B[0m");
                    Usuario usuarioActualizar = usuarioDAO.obtenerUsuarioPorId(idActualizar); // Obtiene el usuario por su ID
                     if (usuarioActualizar == null) {
                        System.out.println("\u001B[31m No se encontró el usuario con ID: " + idActualizar + "\u001B[0m");
                        break;
                    }
                    System.out.println("\u001B[34mActualizando usuario \u001B[0m**" + usuarioActualizar.getNombre() + "**\u001B[0m");
                    System.out.println("\u001B[34m---------------------------------\u001B[0m");
                    System.out.println("\u001B[36mIngrese que datos desea actualizar:\n1. Nombre\n2. Correo\n3. Teléfono\n4. Dirección\n5. Rol\n6. Contraseña\n7. Activo\u001B[0m");
                    int datoActualizar = scanner.nextInt(); // Lee la opción del dato a actualizar
                    scanner.nextLine(); // Limpia el buffer del scanner después de leer un número
                    switch (datoActualizar) {
                        case 1:
                            System.out.print("\u001B[35mIngrese el nuevo nombre: \u001B[0m");
                            String nuevoNombre = scanner.nextLine();
                            usuarioActualizar.setNombre(nuevoNombre);
                            usuarioDAO.actualizarUsuario(usuarioActualizar);
                            break;
                        case 2:
                            System.out.print("\u001B[35mIngrese el nuevo correo: \u001B[0m");
                            String nuevoCorreo = scanner.nextLine();
                            usuarioActualizar.setCorreo(nuevoCorreo);
                            usuarioDAO.actualizarUsuario(usuarioActualizar);
                            break;
                        case 3:
                            System.out.print("\u001B[35mIngrese el nuevo teléfono: \u001B[0m");
                            String nuevoTelefono = scanner.nextLine();
                            usuarioActualizar.setTelefono(nuevoTelefono);
                            usuarioDAO.actualizarUsuario(usuarioActualizar);
                            break;
                        case 4:
                            System.out.print("\u001B[35mIngrese la nueva dirección: \u001B[0m");
                            String nuevaDireccion = scanner.nextLine();
                            usuarioActualizar.setDireccion(nuevaDireccion);
                            usuarioDAO.actualizarUsuario(usuarioActualizar);
                            break;
                        case 5:
                            System.out.print("\u001B[35mIngrese el nuevo rol (0: Administrador, 1: Veterinario, 2: Cliente): \u001B[0m");
                            String nuevoRol = scanner.nextLine();
                            usuarioActualizar.setRol(Rol.values()[Integer.parseInt(nuevoRol)]);
                            usuarioDAO.actualizarUsuario(usuarioActualizar);
                            break;
                        case 6:
                            System.out.print("\u001B[35mIngrese la nueva contraseña: \u001B[0m");
                            String nuevaContraseña = scanner.nextLine();
                            usuarioActualizar.setContraseña(nuevaContraseña);
                            usuarioDAO.actualizarUsuario(usuarioActualizar);
                            break;
                        case 7:
                            System.out.print("\u001B[35mIngrese el nuevo estado (true/false): \u001B[0m");
                            Boolean nuevoActivo = Boolean.parseBoolean(scanner.nextLine());
                            usuarioActualizar.setActivo(nuevoActivo);
                            usuarioDAO.actualizarUsuario(usuarioActualizar);
                            break;
                        default:
                            System.out.println("\u001B[31mOpción no válida para actualizar.\u001B[0m");
                    }
                    System.out.println("\u001B[32mUsuario actualizado exitosamente.\u001B[0m");
                    break;

                case 4:
                    // Opción para eliminar un usuario
                    System.out.print("Ingrese el ID del usuario a eliminar: ");
                    int idEliminar = scanner.nextInt(); // Lee el ID del usuario a eliminar
                    // Llama al método para eliminar el usuario en la base de datos
                    usuarioDAO.eliminarUsuario(idEliminar);
                    System.err.println("\u001B[31mUsuario eliminado exitosamente.\u001B[0m");
                    break;
                case 5:
                    // Opción para salir del programa
                    System.out.println("\u001B[31mSaliendo del sistema...\u001B[0m");
                    scanner.close(); // Cierra el scanner antes de salir
                    return; // Sale del método main y finaliza el programa*/
                default:
                    // Mensaje en caso de que el usuario ingrese una opción no válida
                    System.out.println("\u001B[31m Opción no válida, intente nuevamente.\u001B[0m");
            }
        }
    }
}
