
package universidad_proyectotransversal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class AlumnoData {

    private Connection con;

    public AlumnoData() {
        this.con = Conexion.getConexion();
    }
    
    public void guardarAlumno(Alumno alumno) {
        String sql = "INSERT INTO alumno(dni,apellido,nombre,fechaNacimiento,estado) VALUES (?,?,?,?,?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNacimiento()));
            ps.setBoolean(5, alumno.isEstado());

            ps.executeUpdate(); //envio instruccion a la BD (insert, update, delete)

            ResultSet rs = ps.getGeneratedKeys(); //ResulSet devuelve un 
            
            if(rs.next()){
                alumno.setIdAlumno(rs.getInt(1));
            }
            System.out.println("Alumno guardado con exito");
            ps.close();

        } catch (Exception e) {
            System.out.println("Error al Agregar Alumno (Clase AlumnoData)\n" + e);
            
        }
    }
    
    public List <Alumno> obtenerAlumnos() {
        
        List<Alumno> datos = new ArrayList<>();
        String sql = "SELECT * FROM alumno WHERE estado =1";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
           
            while (rs.next()) {
                Alumno a = new Alumno();
                a.setIdAlumno(rs.getInt("idAlumno"));
                a.setDni(rs.getInt("dni"));
                a.setApellido(rs.getString("apellido"));
                a.setNombre(rs.getString("nombre"));
                a.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());//convertir de date a LocalDate
                a.setEstado(rs.getBoolean("estado"));
                datos.add(a);
            }
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error al listar los alumnos(clase AlumnoData) " + e);
        }

        return datos;
    }
    
    public void actualizarAlumno(Alumno alumno){
        
        String sql = "UPDATE alumno SET dni=?, apellido=?, nombre=?, fechaNacimiento=?, estado=? WHERE idAlumno=?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNacimiento()));
            ps.setBoolean(5, alumno.isEstado());
            ps.setInt(6, alumno.getIdAlumno());
            
            if(ps.executeUpdate()>0){
                JOptionPane.showMessageDialog(null, "Modificado exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "Alumno no Encontrado");
            }
            
            ps.close();
         
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "Error Al modificar un Alumno");   
        }
    }
    
    public Alumno buscarAlumno(int id) {
        Alumno alumno = new Alumno();
        String sql = "SELECT idAlumno dni, apellido, nombre, fechaNacimiento FROM alumno WHERE idAlumno=? AND estado = 1";
        
      
        try {
            PreparedStatement ps = con.prepareStatement(sql); // Tener el string con la sentencia sql
            ps.setInt(1, id); // seteo al sql el parametro dinamico el id
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                alumno.setIdAlumno(id);
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                //alumno.setEstado(rs.getBoolean("estado"));

            }
            ps.close();

        } catch (SQLException ex) {
            System.out.println("Error al buscar Alumno(Clase Alumno)");
        }

        return alumno;
    }
    
    public void eliminarAlumno(int id){
        String sql = "UPDATE alumno SET estado=0 Where idAlumno=?";
        try {
  
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
            ps.close();
            
        } catch (Exception ex) {
            System.out.println("Error al querer eliminar alumno (Clase AlumnoData) ");
        }
    }
    
}

