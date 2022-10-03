

package universidad_proyectotransversal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class MateriaData {
    
    private Connection con;

    public MateriaData() {
        this.con = Conexion.getConexion();
    }

    public void guardarMateria(Materia materia) {
        String sql = "INSERT INTO materia(nombre,año,estado) VALUES (?,?,?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
          
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAño());
            ps.setBoolean(3, materia.isEstado());

            ps.executeUpdate(); //envio instruccion a la BD (insert, update, delete)

            ResultSet rs = ps.getGeneratedKeys(); //ResulSet devuelve un 
            
            if(rs.next()){
                materia.setIdMateria(rs.getInt(1));
            }
            System.out.println("Materia guardada con exito");
            ps.close();

        } catch (Exception e) {
            System.out.println("Error al Agregar Materia (Clase MateriaData)\n" + e);
            
        }
    }
    
    public List <Materia> obtenerMateria() {
        
        List<Materia> datos = new ArrayList<>();
        String sql = "SELECT * FROM materia WHERE estado =1";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
           
            while (rs.next()) {
                Materia m = new Materia();
                
                m.setNombre(rs.getString("nombre"));
                m.setAño(rs.getInt("año"));
                m.setEstado(rs.getBoolean("estado"));
                
                datos.add(m);
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener las Materias(clase MateriaData) ");
        }

        return datos;
    }
    
    public void actualizarMateria(Materia materia){
        
        String sql = "UPDATE materia SET nombre=?, año=?, estado=? WHERE idMateria=?";
        
        try {
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAño());
            ps.setBoolean(3, materia.isEstado());
            ps.setInt(4, materia.getIdMateria());
            
            if(ps.executeUpdate()>0){
                JOptionPane.showMessageDialog(null, "Modificado exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "Materia no Encontrado");
            }
            
            ps.close();
         
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "Error Al modificar una Materia (Clase Materia)");   
        }
    }
    
    public Materia buscarMateria(int id) {
        Materia materia = new Materia();
        String sql = "SELECT idMateria, nombre, año FROM materia WHERE idMateria=? AND estado=1";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql); 
            ps.setInt(1, id); // seteo al sql el parametro dinamico el id
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAño(rs.getInt("año"));
                //materia.setEstado(rs.getBoolean("estado"));

            }
            ps.close();

        } catch (SQLException ex) {
            System.out.println("Error al buscar Materia(Clase Materia)");
        }

        return materia;
    }
    
    public void eliminarMateria(int id){
        String sql = "UPDATE materia SET estado=0 Where idMateria=?";
        try {
  
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
            ps.close();
            
        } catch (Exception ex) {
            System.out.println("Error al querer eliminar una Materia ");
        }
    }
}
