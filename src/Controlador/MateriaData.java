/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Conexion;
import Modelo.Materia;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;

public class MateriaData {

    private Connection con;

    public MateriaData() {
        this.con = Conexion.getConexion();
    }

    public void guardarMateria(Materia materia) {
        String sql = "INSERT INTO materia (nombre,año, estado) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);//aviso despues de que inserte el alumno me recuperar/retorna la clave generada, la clave que se le asigno en bd
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnio());
            ps.setBoolean(3, materia.isEstado());
            ps.executeUpdate();//insert, update, delete (enviamos las sentencia a la base de datos)

            ///setearle al id del alumno de la clase
            ResultSet rs = ps.getGeneratedKeys();//recupero las llaves el ultimo insertado es la primera llave
            if (rs.next()) {

                materia.setIdMateria(rs.getInt(1));
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "MateriaData Sentencia SQL erronea-AgregarMateria");
        }
    }

    public void ActualizarMateria(Materia materia) {

        String sql = "UPDATE materia SET nombre = ?,año = ? WHERE idMateria = ?;";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnio());
            ps.setInt(3, materia.getIdMateria());

            if (ps.executeUpdate() > 0) {//cantidad de filas afectadas

                JOptionPane.showMessageDialog(null, "Materia modificada");

            } else {//error al no encontral el alumno
                JOptionPane.showMessageDialog(null, " Materia no modificada");

            }///guardo en la base lo que venia en el materia

            ps.close();
        } catch (SQLException ex) {//error en la sentencia
            System.err.println("Error al modificar" + ex);
        }
    }

    public void borrarMateria(int id) {

        String sql = "UPDATE materia SET estado = 0 WHERE idMateria = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            if (ps.executeUpdate() > 0) {//cantidad de filas afectadas

                JOptionPane.showMessageDialog(null, "Materia borrada");

            } else {//error al no encontral el alumno
                JOptionPane.showMessageDialog(null, " Materia no borrada");

            }
            ///guardo en la base lo que venia en el Materia

        } catch (SQLException ex) {//error en la sentencia
            System.err.println("Error al borrar" + ex);
        }
    }

    public Materia BuscarMateriaXId(int id) {
        String sql = "SELECT * FROM materia WHERE idMateria = ?";
        Materia materia = new Materia();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnio(rs.getInt("año"));
                materia.setEstado(rs.getBoolean("estado"));   
            }
            ps.close();
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "MateriaData Sentencia SQL erronea-ObtenerMateriaXId");

        }
        return materia;

    }

    public List<Materia> obtenerMaterias() {
        ArrayList<Materia> listaTemp = new ArrayList<>();
        String sql = "SELECT * FROM materia WHERE estado = 1";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();//select
            while (rs.next()) {

                Materia materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnio(rs.getInt("año"));
                materia.setEstado(rs.getBoolean("estado")); 

                listaTemp.add(materia);
            }

            ps.close();//cerra la coneccion      
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "MateriaData Sentencia SQL erronea-ObtenerMateria");
        }
        return listaTemp;
    }

}
