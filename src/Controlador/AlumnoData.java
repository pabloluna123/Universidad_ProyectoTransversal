package Controlador;

import Modelo.Alumno;
import Modelo.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class AlumnoData {

    private Connection con;

    public AlumnoData() {
        this.con = Conexion.getConexion();
    }

    public void guardarAlumno(Alumno alumno) {
        String sql = "INSERT INTO alumno (dni, apellido, nombre, fechaNacimiento, estado) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);//aviso despues de que inserte el alumno me recuperar/retorna la clave generada, la clave que se le asigno en bd
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNacimiento()));//de localDate a date sql
            ps.setBoolean(5, alumno.isEstado());
            ps.executeUpdate();//insert, update, delete (enviamos las sentencia a la base de datos)

            ///setearle al id del alumno de la clase
            ResultSet rs = ps.getGeneratedKeys();//recupero las llaves el ultimo insertado es la primera llave
            if (rs.next()) {

                alumno.setIdAlumno(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Alumno agregado");
            }else{
                JOptionPane.showMessageDialog(null, "Alumno no agregado");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "AlumnoData Sentencia SQL/base de datos inactiva, error-agregarAlumno");
        }
    }

    public void actualizarAlumno(Alumno alumno) {

        String sql = "UPDATE alumno SET dni = ?,apellido = ?, nombre = ? , fechaNacimiento = ?, estado = ? WHERE idAlumno = ?;";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNacimiento()));
            ps.setBoolean(5, alumno.isEstado());
            ps.setInt(6, alumno.getIdAlumno());
            if (ps.executeUpdate() > 0) {//cantidad de filas afectadas

                JOptionPane.showMessageDialog(null, "Alumno modificado");

            } else {//error al no encontral el alumno
                JOptionPane.showMessageDialog(null, " Alumno no modificado");

            }///guardo en la base lo que venia en el alumno

            ps.close();
        } catch (SQLException ex) {//error en la sentencia
            JOptionPane.showMessageDialog(null, "AlumnoData Sentencia SQL/base de datos inactiva, error-actualizarAlumno");
        }
    }

    public void borrarAlumno(int id) {

        String sql = "UPDATE alumno SET estado = 0 WHERE idAlumno = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            if (ps.executeUpdate() > 0) {//cantidad de filas afectadas

                JOptionPane.showMessageDialog(null, "Alumno borrado");

            } else {//error al no encontral el alumno
                JOptionPane.showMessageDialog(null, " Alumno no borrado");

            }
            ///guardo en la base lo que venia en el alumno

        } catch (SQLException ex) {//error en la sentencia
            JOptionPane.showMessageDialog(null, "AlumnoData Sentencia SQL/base de datos inactiva, error-borrarAlumno");
        }
    }

    public Alumno BuscarAlumnoXId(int id) {
        String sql = "SELECT * FROM alumno WHERE idAlumno = ?";
        Alumno alumno = new Alumno();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());//transforma un date sql a localdate
                alumno.setEstado(rs.getBoolean("estado"));
            }
            ps.close();
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "AlumnoData Sentencia SQL/base de datos inactiva, error-buscarAlumnoXId");

        }
        return alumno;

    }

    public List<Alumno> obtenerAlumnos() {
        ArrayList<Alumno> listaTemp = new ArrayList<>();
        String sql = "SELECT * FROM alumno WHERE estado = 1";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();//select
            while (rs.next()) {

                Alumno a = new Alumno();
                a.setIdAlumno(rs.getInt("idAlumno"));
                a.setDni(rs.getInt("dni"));
                a.setApellido(rs.getString("apellido"));
                a.setNombre(rs.getString("nombre"));
                a.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());//transforma un date sql a localdate
                a.setEstado(rs.getBoolean("estado"));

                listaTemp.add(a);
            }

            ps.close();//cerra la coneccion      
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "AlumnoData Sentencia SQL/base de datos inactiva, error-obtenerAlumnos");
        }
        return listaTemp;
    }
}
