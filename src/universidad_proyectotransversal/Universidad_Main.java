
package universidad_proyectotransversal;

import java.time.LocalDate;
import java.util.List;


public class Universidad_Main {

    
    public static void main(String[] args) {
        
        AlumnoData ad = new AlumnoData();
        MateriaData md = new MateriaData();
        InscripcionData id = new InscripcionData();
        
        Alumno pablo = new Alumno (123213,"Luna","Pablo Gaston",LocalDate.of(1992, 8, 8),true);
        Materia analisis1 = new Materia ("Analisis1", 1, true);
        Inscripcion inscripcion = new Inscripcion();
        
        // ad.guardarAlumno(pablo);
            
        ad.obtenerAlumnos().forEach(alumno->{
            System.out.println(alumno);  //mostamos el toString() de la clase Alumno  
        });
        
        System.out.println("\n" +ad.buscarAlumno(2)+"\n");       
        //ad.eliminarAlumno(4);    
        //md.guardarMateria(analisis1);
        
        /*md.obtenerMateria().forEach(materia->{
            System.out.println(materia);  //mostamos el toString() de la clase Materia            
        });  */
        
        //md.eliminarMateria(5); //eliminado logico de bd materia
        //System.out.println("\n"+md.buscarMateria(1));
          
        List<Alumno> alumnos = id.listarAlumnosActivos(); 
        List<Materia> materias = id.listarMateriasActivas();
          
    }
    
}
