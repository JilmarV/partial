/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Connection.ConnectionMySQL;
import Models.Bull;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author jilssa
 */
public class BullController {
    // Creamos un objeto de la clase ConexionMySQL
    ConnectionMySQL conexion;

    public BullController() {
        this.conexion = new ConnectionMySQL();
    }

    public void insert(Bull bull) {
        // Establecemos la conexión con la base de datos
        try (Connection conn = conexion.conectarMySQL()) {
            // Verificamos si la conexión fue exitosa
            if (conn != null) {
                // Preparamos la consulta SQL para insertar datos
                String insertSQL = "INSERT INTO bull (name, race, owner, weight, agressivenessLevel) VALUES (?,?,?,?,?)";
                try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
                    pstmt.setString(1, bull.getName());
                    pstmt.setString(2, bull.getRace());
                    pstmt.setString(3, bull.getOwner());
                    pstmt.setFloat(4, bull.getWeight());
                    pstmt.setInt(5, bull.getAgressivenessLevel());

                    // Ejecutamos la consulta
                    int rowsAffected = pstmt.executeUpdate();

                    // Verificamos si la inserción fue exitosa
                    if (rowsAffected > 0) {
                        System.out.println("Inserción exitosa");
                        JOptionPane.showMessageDialog(null, "Se ha registrado con exito ");
                    } else {
                        System.out.println("No se pudo insertar los datos");
                    }
                }
            } else {
                System.out.println("No se pudo establecer la conexión con la base de datos");
            }
        } catch (SQLException e) {
            System.out.println("Ocurrió un error al realizar la inserción en la base de datos");
            e.printStackTrace();
        }
    }
    
    public void select() {
        // Establecemos la conexión con la base de datos
        try (Connection conn = conexion.conectarMySQL()) {
            // Verificamos si la conexión fue exitosa
            if (conn != null) {
                // Preparamos la consulta SQL para seleccionar datos
                String selectSQL = "SELECT * FROM bull";
                try (PreparedStatement pstmt = conn.prepareStatement(selectSQL)) {
                    // Ejecutamos la consulta
                    ResultSet rs = pstmt.executeQuery();

                    // Iteramos sobre los resultados
                    while (rs.next()) {
                        System.out.println("Id: " + rs.getString("id") + ", Nombre: " + rs.getString("name") + 
                                ", Raza: " + rs.getString("race") + ", Dueño: " + rs.getString("owner") + ", Peso: " + rs.getInt("weight") +
                                ", Nivel de agresividad: " + rs.getInt("agressivenessLevel") );
                    }
                }
            } else {
                System.out.println("No se pudo establecer la conexión con la base de datos");
            }
        } catch (SQLException e) {
            System.out.println("Ocurrió un error al realizar la selección en la base de datos");
            e.printStackTrace();
        }
    }

}
