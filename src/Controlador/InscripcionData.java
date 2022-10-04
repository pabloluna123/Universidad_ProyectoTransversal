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
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    public void agregarInscripcion(Inscripcion inscripto){
        
        String sql = "INSERT INTO inscripcion (nota, idAlumno, idMateria) VALUES (?,?,?)";
        
        try {
            
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            
            ps.setInt(1, inscripto.getNota());
            ps.setInt(2, inscripto.getIdAlumno().getIdAlumno());
            ps.setInt(3, inscripto.getIdMateria().getIdMateria());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            
            if (rs.next()) {
                
                inscripto.setIdInscripcion(rs.getInt(1)); 
            }
            
            ps.close();             
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "InscripcionData Sentencia SQL erronea-AgregarInscripcion");  
        }    
    }
    
    public void actualizarNota(Alumno alumno,Materia materia,int nota){
        
        String sql = "UPDATE inscripcion SET nota= ? WHERE idAlumno = ? and idMateria = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, nota);
            ps.setInt(2, alumno.getIdAlumno());
            ps.setInt(3, materia.getIdMateria());
            
            if (ps.executeUpdate() > 0) {

                JOptionPane.showMessageDialog(null, "Nota modificada");

            } else {
                JOptionPane.showMessageDialog(null, " Nota no modificada");
            }
            
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "InscripcionData Sentencia SQL erronea-actualizarNota");     
        }  
    }
    
    public void borrarInscripto(){
        
        
    }
    
    public List<Alumno> AlumnosInscriptos(Materia materia){///id alumno
        return null;
        
    }
    public List<Materia> MateriaNoInscriptos(Alumno alumno){//id alumno
        return null;
        
    }
    public List<Materia> MateriasInscripto(Alumno alumno){//id alumno
        return null;
    }
    
    
    
    public List<Inscripcion> obtenerInscriptos() {
        
        ArrayList<Inscripcion> listaTemp = new ArrayList<>();
        
        String sql = "SELECT * FROM inscripcion";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
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
            JOptionPane.showMessageDialog(null, "InscripcionData Sentencia SQL erronea-ObtenerIncriptos");
        }
        return listaTemp;
    }
    
    
    
    
    
    
    
    
    
    
    
}
