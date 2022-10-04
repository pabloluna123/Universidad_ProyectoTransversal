/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prueba;

import Controlador.AlumnoData;
import Controlador.MateriaData;
import Modelo.Alumno;
import Modelo.Materia;
import java.time.*;

/**
 *
 * @author Familia
 */
public class Main {

    static AlumnoData ad = new AlumnoData();

    static Alumno alu = null;

    static MateriaData md = new MateriaData();

    static Materia mate = null;

    public static void main(String[] args) {
//////////////////////////////////////////////////////////////////////////////////////
//        guardarAlumno();
//        actualizarAlumno();
//        BuscarAlumnoXId();
//        borrarAlumno();
//        obtenerAlumnos();
////////////////////////////////////////////////////////////////////////////////////
//        guardarMateria();
//        actualizarMateria();
//        BuscarMateriaXId();
//        borrarMateria();
//        obtenerMateria();
////////////////////////////////////////////////////////////////////////////////////



    }

    public static void guardarAlumno() {

        alu = new Alumno(1213, "fede", "Muñoz", LocalDate.of(1966, 01, 06), true);
        ad.guardarAlumno(alu);
    }

    public static void actualizarAlumno() {

        for (Alumno x : ad.obtenerAlumnos()) {

            alu = x;
        }

        alu.setNombre("Juan");

        ad.actualizarAlumno(alu);
    }

    public static void borrarAlumno() {

        for (Alumno x : ad.obtenerAlumnos()) {

            alu = x;
        }

        ad.borrarAlumno(alu.getIdAlumno());
    }

    public static void BuscarAlumnoXId() {

        alu = ad.BuscarAlumnoXId(1);

        System.out.println(alu.getNombre());
        System.out.println(alu.getApellido());

    }

    public static void obtenerAlumnos() {
        for (Alumno x : ad.obtenerAlumnos()) {

            System.out.println(x);
        }
    }
//////////////////////////////////////////////////////////////////////////////////

    public static void guardarMateria() {

        mate = new Materia(3, "Mecanica", true);
        md.guardarMateria(mate);
    }

    public static void actualizarMateria() {

        for (Materia x : md.obtenerMaterias()) {

            mate = x;
        }

        mate.setNombre("Mecanica 3");

        md.ActualizarMateria(mate);
    }

    public static void borrarMateria() {

        for (Materia x : md.obtenerMaterias()) {

            mate = x;
        }

        md.borrarMateria(mate.getIdMateria());
    }

    public static void BuscarMateriaXId() {

        mate = md.BuscarMateriaXId(1);

        System.out.println(mate.getNombre());
        System.out.println(mate.getAnio());

    }

    public static void obtenerMateria() {
        for (Materia x : md.obtenerMaterias()) {

            System.out.println(x);
        }
    }
    
////////////////////////////////////////////////////////////////////////////////////
    
    

}
