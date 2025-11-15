package agenda.dao;

import agenda.model.Contacto;
import agenda.util.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ContactoDAO {

    /**
     * CREATE (Crear) - Inserta un nuevo contacto en la BD.
     */
    public boolean insertar(Contacto contacto) {
        String sql = "INSERT INTO contactos (nombre, apellido_paterno, apellido_materno, sexo, telefono, direccion, tipo_contacto) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, contacto.getNombre());
            pstmt.setString(2, contacto.getApellidoPaterno());
            pstmt.setString(3, contacto.getApellidoMaterno());
            pstmt.setString(4, contacto.getSexo());
            pstmt.setString(5, contacto.getTelefono());
            pstmt.setString(6, contacto.getDireccion());
            pstmt.setString(7, contacto.getTipoContacto());
            
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * READ (Leer) - Obtiene todos los contactos.
     */
    public List<Contacto> listarTodos() {
        List<Contacto> contactos = new ArrayList<>();
        String sql = "SELECT * FROM contactos";
        
        try (Connection conn = DB.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                contactos.add(mapearContacto(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contactos;
    }

    /**
     * READ (Leer) - Busca un contacto por su ID.
     */
    public Contacto buscarPorId(int id) {
        String sql = "SELECT * FROM contactos WHERE id = ?";
        Contacto contacto = null;
        
        try (Connection conn = DB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    contacto = mapearContacto(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contacto;
    }

    /**
     * UPDATE (Actualizar) - Actualiza un contacto existente.
     */
    public boolean actualizar(Contacto contacto) {
        String sql = "UPDATE contactos SET nombre = ?, apellido_paterno = ?, apellido_materno = ?, sexo = ?, telefono = ?, direccion = ?, tipo_contacto = ? WHERE id = ?";
        
        try (Connection conn = DB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, contacto.getNombre());
            pstmt.setString(2, contacto.getApellidoPaterno());
            pstmt.setString(3, contacto.getApellidoMaterno());
            pstmt.setString(4, contacto.getSexo());
            pstmt.setString(5, contacto.getTelefono());
            pstmt.setString(6, contacto.getDireccion());
            pstmt.setString(7, contacto.getTipoContacto());
            pstmt.setInt(8, contacto.getId());
            
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * DELETE (Borrar) - Elimina un contacto por su ID.
     */
    public boolean eliminar(int id) {
        String sql = "DELETE FROM contactos WHERE id = ?";
        
        try (Connection conn = DB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    private Contacto mapearContacto(ResultSet rs) throws SQLException {
        return new Contacto(
            rs.getInt("id"),
            rs.getString("nombre"),
            rs.getString("apellido_paterno"),
            rs.getString("apellido_materno"),
            rs.getString("sexo"),
            rs.getString("telefono"),
            rs.getString("direccion"),
            rs.getString("tipo_contacto")
        );
    }
}