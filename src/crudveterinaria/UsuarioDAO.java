package crudveterinaria;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import crudveterinaria.utils.Encriptar;
import crudveterinaria.utils.Rol;

public class UsuarioDAO {
    public void crearUsuario(Usuario usuario) {
        // Consulta SQL para insertar un nuevo usuario en la tabla "usuarios"
        String sql = "INSERT INTO usuarios (nombre, email, telefono, direccion, rol, password_hash, activo, fecha_registro) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConexionBD.getConnection();
                java.sql.PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // Asignamos los valores a los parámetros de la consulta SQL
            pstmt.setString(1, usuario.getNombre());
            pstmt.setString(2, usuario.getCorreo());
            pstmt.setString(3, usuario.getTelefono());
            pstmt.setString(4, usuario.getDireccion());
            pstmt.setString(5, usuario.getRol().name());
            pstmt.setString(6, Encriptar.hashPassword(usuario.getContraseña()));
            pstmt.setBoolean(7, usuario.getActivo());
            pstmt.setTimestamp(8, java.sql.Timestamp.valueOf(usuario.getFechaRegistro()));
            pstmt.executeUpdate();
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }
        public void actualizarUsuario(Usuario usuario) {
        // Implementar la lógica para actualizar un usuario en la base de datos
        String sql = "UPDATE usuarios SET nombre = ?, email = ?, telefono = ?, direccion = ?, rol = ?, password_hash = ?, activo = ?, fecha_registro = ? WHERE id = ?";
        try (Connection conn = ConexionBD.getConnection();
                java.sql.PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, usuario.getNombre());
            pstmt.setString(2, usuario.getCorreo());
            pstmt.setString(3, usuario.getTelefono());
            pstmt.setString(4, usuario.getDireccion());
            pstmt.setString(5, usuario.getRol().name());
            pstmt.setString(6, Encriptar.hashPassword(usuario.getContraseña()));
            pstmt.setBoolean(7, usuario.getActivo());
            pstmt.setTimestamp(8, java.sql.Timestamp.valueOf(usuario.getFechaRegistro()));
            pstmt.setInt(9, usuario.getId());
            pstmt.executeUpdate();
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }

    }
    public void eliminarUsuario(int id) {
        // Implementar la lógica para eliminar un usuario de la base de datos
        String sql = "UPDATE usuarios SET activo = 0 WHERE id = ?";
        try (Connection conn = ConexionBD.getConnection();
                java.sql.PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }

    public Usuario obtenerUsuarioPorId(int id) {
        Usuario usuario = null;
        String sql = "SELECT * FROM usuarios WHERE id = ? ";
        try (Connection conn = ConexionBD.getConnection();
                java.sql.PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (java.sql.ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    usuario = new Usuario(
                            rs.getInt("id"),
                            rs.getString("nombre"),
                            rs.getString("email"),
                            rs.getString("telefono"),
                            rs.getString("direccion"),
                            Rol.valueOf(rs.getString("rol")),
                            rs.getString("password_hash"), 
                            rs.getBoolean("activo"),
                            rs.getTimestamp("fecha_registro").toLocalDateTime());
                    usuario.setId(rs.getInt("id"));
                }
            }
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }

    public List<Usuario> obtenerUsuarios() {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuarios WHERE activo = 1";
        try (Connection conn = ConexionBD.getConnection();
                java.sql.Statement stmt = conn.createStatement();
                java.sql.ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Usuario usuario = new Usuario(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("email"),
                        rs.getString("telefono"),
                        rs.getString("direccion"),
                        Rol.valueOf(rs.getString("rol")),
                        rs.getString("password_hash"), // Nota: No se recomienda mostrar el hash de la contraseña
                        rs.getBoolean("activo"),
                        rs.getTimestamp("fecha_registro").toLocalDateTime());
                lista.add(usuario);
            }
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}