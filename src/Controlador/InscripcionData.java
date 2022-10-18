/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Alumno;
import Modelo.Conexion;
import Modelo.Inscripcion;
import Modelo.Materia;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Familia
 */
public class InscripcionData {

    private Connection con;
    private AlumnoData ad;
    private MateriaData md;

    public InscripcionData() {

        this.con = Conexion.getConexion();
        this.ad = new AlumnoData();
        this.md = new MateriaData();
    }

    public void agregarInscripcion(Inscripcion inscripto) {

        String sql = "INSERT INTO inscripcion (nota, idAlumno, idMateria) VALUES (?,?,?)";

        try {

            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, inscripto.getNota());
            ps.setInt(2, inscripto.getIdAlumno().getIdAlumno());
            ps.setInt(3, inscripto.getIdMateria().getIdMateria());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {

                inscripto.setIdInscripcion(rs.getInt(1));  
                JOptionPane.showMessageDialog(null, "Inscripcion agregada");
            }else{
                JOptionPane.showMessageDialog(null, "Inscripcion no agregada");
            }
            ps.close();
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "InscripcionData Sentencia SQL/base de datos inactiva, error-agregarInscripcion");
        }
    }

    public void actualizarNota(int idAlumno, int idMateria, int nota) {

        String sql = "UPDATE inscripcion SET nota= ? WHERE idAlumno = ? and idMateria = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, nota);
            ps.setInt(2, idAlumno);
            ps.setInt(3, idMateria);

            if (ps.executeUpdate() > 0) {

                JOptionPane.showMessageDialog(null, "Nota modificada");

            } else {
                JOptionPane.showMessageDialog(null, " Nota no modificada");
            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "InscripcionData Sentencia SQL/base de datos inactiva, error-actualizarNota");
        }
    }

    public Inscripcion obtenerCursadaXId(int idAlumno, int idMateria) { //ya quedo

        String sql = "SELECT * FROM inscripcion WHERE idAlumno = ? AND idMateria = ?";

        Inscripcion inscripto = new Inscripcion();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ps.setInt(2, idMateria);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {//while al pedo poner if

                inscripto.setIdInscripcion(rs.getInt("idInscripto"));
                inscripto.setIdAlumno(ad.BuscarAlumnoXId(rs.getInt("idAlumno")));
                inscripto.setIdMateria(md.BuscarMateriaXId(rs.getInt("idMateria")));
                inscripto.setNota(rs.getInt("nota"));
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "InscripcionData Sentencia SQL/base de datos inactiva, error-obtenerCursadaXId");
        }

        return inscripto;
    }

    public void borrarInscripto(int idAlumno, int idMateria) {

        String sql = "DELETE FROM inscripcion WHERE idAlumno = ? AND idMateria = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, idAlumno);
            ps.setInt(2, idMateria);

            if (ps.executeUpdate() > 0) {

                JOptionPane.showMessageDialog(null, "Inscripto Borrado");

            } else {
                JOptionPane.showMessageDialog(null, "Inscripto no Borrado");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "InscripcionData Sentencia SQL/base de datos inactiva, error-borraInscripto");
        }
    }

    public List<Alumno> AlumnosInscriptos(int idMateria) {///id materia me devuelve los alumnos incriptos a dicha materia
        List<Alumno> listTemp = new ArrayList<>();
        String instruccion = "SELECT alumno.idAlumno, alumno.dni, alumno.apellido, alumno.nombre, alumno.fechaNacimiento, alumno.estado"
                + " FROM inscripcion"
                + " JOIN alumno ON inscripcion.idAlumno=alumno.idAlumno"
                + " WHERE inscripcion.idMateria=?";

        try {
            PreparedStatement ps = con.prepareStatement(instruccion);
            ps.setInt(1, idMateria);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Alumno a = new Alumno();
                a.setIdAlumno(rs.getInt("idAlumno"));
                a.setDni(rs.getInt("dni"));
                a.setApellido(rs.getString("apellido"));
                a.setNombre(rs.getString("nombre"));
                a.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                a.setEstado(rs.getBoolean("estado"));
                listTemp.add(a);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "InscripcionData Sentencia SQL/base de datos inactiva, error-AlumnosInscriptos");
        }
        return listTemp;   
    }

    public List<Materia> MateriaNoInscripto(int idAlumno) {//id alumno devuelve una lista de materias en la que no esta inscripto el alumno

        ArrayList<Materia> listaTemp = new ArrayList<>();

        String sql = "SELECT * FROM materia WHERE idMateria NOT IN (SELECT idMateria FROM inscripcion WHERE idAlumno = ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, idAlumno);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Materia materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnio(rs.getInt("año"));
                materia.setEstado(rs.getBoolean("estado"));

                listaTemp.add(materia);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "InscripcionData Sentencia SQL/base de datos inactiva, error-MateriaNoInscripto");
        }
        return listaTemp;
    }

    public List<Materia> MateriasInscripto(int idAlumno) {//id alumno devuelve una lista de materias en la que esta inscripto el alumno
        ArrayList<Materia> listaTemp = new ArrayList<>();
         
         String sql = "SELECT m.idMateria, m.nombre, m.año, m.estado"
                 + " FROM materia m, alumno a, inscripcion i" 
                 + " WHERE m.idMateria = i.idMateria" 
                 + " AND a.idAlumno = i.idAlumno "
                 + " AND i.idAlumno = ?";  
         
         try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Materia materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnio(rs.getInt("año"));
                materia.setEstado(rs.getBoolean("estado"));

                listaTemp.add(materia);
            }
            ps.close();
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "InscripcionData Sentencia SQL/base de datos inactiva, error-MateriasInscripto");
        }
        return listaTemp; 
    }

    public List<Inscripcion> obtenerInscriptos(Alumno alumno) {

        ArrayList<Inscripcion> listaTemp = new ArrayList<>();

        String sql = "SELECT inscripcion.idInscripto, inscripcion.idMateria,inscripcion.idAlumno, inscripcion.nota "
                + "FROM inscripcion JOIN materia ON inscripcion.idMateria=materia.idMateria "
                + "WHERE inscripcion.idAlumno=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, alumno.getIdAlumno());
            
            ResultSet rs = ps.executeQuery();//select

            while (rs.next()) {

                Inscripcion inscri = new Inscripcion();//no se si es necesario dentro del while (sobreescritura)

                inscri.setIdInscripcion(rs.getInt("idInscripto"));
                inscri.setIdAlumno(ad.BuscarAlumnoXId(rs.getInt("idAlumno")));
                inscri.setIdMateria(md.BuscarMateriaXId(rs.getInt("idMateria")));
                inscri.setNota(rs.getInt("nota"));

                listaTemp.add(inscri);
            }

            ps.close();//cerra la coneccion      
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "InscripcionData Sentencia SQL/base de datos inactiva, error-obtenerInscriptos(alumno)");
        }
        return listaTemp;
    }
    
    public List<Inscripcion> obtenerInscriptos(Materia materia) {

        ArrayList<Inscripcion> listaTemp = new ArrayList<>();

        String sql = "SELECT inscripcion.idInscripto, inscripcion.idMateria,inscripcion.idAlumno, inscripcion.nota "
                + "FROM inscripcion JOIN Alumno ON inscripcion.idAlumno=alumno.idAlumno "
                + "WHERE inscripcion.idMateria=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, materia.getIdMateria());
            
            ResultSet rs = ps.executeQuery();//select

            while (rs.next()) {

                Inscripcion inscri = new Inscripcion();//no se si es necesario dentro del while (sobreescritura)

                inscri.setIdInscripcion(rs.getInt("idInscripto"));
                inscri.setIdAlumno(ad.BuscarAlumnoXId(rs.getInt("idAlumno")));
                inscri.setIdMateria(md.BuscarMateriaXId(rs.getInt("idMateria")));
                inscri.setNota(rs.getInt("nota"));

                listaTemp.add(inscri);
            }

            ps.close();//cerra la coneccion      
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "InscripcionData Sentencia SQL/base de datos inactiva, error-obtenerInscriptos(Materia)");
        }
        return listaTemp;
    }

}
