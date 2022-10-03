
package universidad_proyectotransversal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class InscripcionData {
    
    private Connection con;
    
    public InscripcionData() {
        this.con = Conexion.getConexion();
    }
    
    public int inscribir(Alumno alumno, Materia materia, Inscripcion nota) {
        String instruccion = "INSERT INTO inscripcion(idMateria,idAlumno,nota) VALUES (?,?,?)";
        
        try {   
            PreparedStatement ps = con.prepareStatement(instruccion);
            ps.setInt(1, materia.getIdMateria());
            ps.setInt(2, alumno.getIdAlumno());
            ps.setDouble(3, nota.getNota());

            ps.executeUpdate();
            ps.close();
            System.out.println("Inscripcion completada");

            return 1;
        } catch (Exception ex) {
            System.out.println("Error al querer realizar la inscripcion (Clase InscripcionData)\n");
            return 0;
        }
    }
    
    public List listarMateriasActivas() {
        
        List<Materia> datos = new ArrayList<>();
        String sql = "SELECT * FROM materia WHERE estado=1";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Materia m = new Materia();
                m.setIdMateria(rs.getInt("idMateria"));
                m.setNombre(rs.getString("nombre"));
                m.setAño(rs.getInt("año"));
                m.setEstado(rs.getBoolean("estado"));
                datos.add(m);
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al lista Materias activas (Clase InscripcionData) ");
        }

        return datos;
    }
    
    public List listarAlumnosActivos() {
        List<Alumno> datos = new ArrayList<>();
        String sql = "SELECT * FROM alumno WHERE estado=1";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Alumno a = new Alumno();
                a.setIdAlumno(rs.getInt("idAlumno"));
                a.setDni(rs.getInt("dni"));
                a.setApellido(rs.getString("apellido"));
                a.setNombre(rs.getString("nombre"));
                a.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                a.setEstado(rs.getBoolean("estado"));
                datos.add(a);
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al lista Alumnos activos (Clase InscripcionData) ");
        }

        return datos;
    }
}
