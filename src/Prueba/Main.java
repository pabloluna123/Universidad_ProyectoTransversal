/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prueba;

import Controlador.AlumnoData;
import Controlador.InscripcionData;
import Controlador.MateriaData;
import Modelo.Alumno;
import Modelo.Inscripcion;
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

    static InscripcionData iData = new InscripcionData();

    static Inscripcion inscri = null;

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
//        agregarInscripcion();
//        actualizarNota();
//        obtenerCursadaXId();
//        borrarInscripto();
//        MateriaNoInscripto();
//        obtenerInscriptos();

    }

    public static void guardarAlumno() {

        alu = new Alumno(1213, "Moises", "Lopez", LocalDate.of(1966, 01, 06), true);
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
    public static void agregarInscripcion() {

        alu = ad.BuscarAlumnoXId(1);
        mate = md.BuscarMateriaXId(5);

        inscri = new Inscripcion(0, mate, alu);

        iData.agregarInscripcion(inscri);
    }

    public static void actualizarNota() {
        alu = ad.BuscarAlumnoXId(1);
        mate = md.BuscarMateriaXId(5);

        iData.actualizarNota(alu, mate, 5);
    }

    public static void obtenerCursadaXId() {

        inscri = iData.obtenerCursadaXId(1, 1);///me deberia devolver federico y a matematica 1

        System.out.println(inscri.getIdAlumno().getNombre());
        System.out.println(inscri.getIdMateria().getNombre());
        System.out.println(inscri.getNota());
    }

    public static void borrarInscripto() {
        iData.borrarInscripto(1, 5);
    }

    public static void MateriaNoInscripto() {

        for (Materia x : iData.MateriaNoInscripto(1)) {
            System.out.println(x.getNombre());
        }
    }

    public static void obtenerInscriptos() {

        for (Inscripcion x : iData.obtenerInscriptos()) {
            System.out.println(x.getIdAlumno().getNombre());
            System.out.println(x.getIdMateria().getNombre());
            System.out.println(x.getNota());
        }

    }

}
