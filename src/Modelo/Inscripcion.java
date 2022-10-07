/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


/**
 *
 * @author Familia
 */
public class Inscripcion {

    private int idInscripcion;
    private int nota;
    private Materia idMateria;
    private Alumno idAlumno;
    
    public Inscripcion() {
    }

    public Inscripcion(int nota, Materia idMateria, Alumno idAlumno) {
        this.nota = nota;
        this.idMateria = idMateria;
        this.idAlumno = idAlumno;
    }

    public Inscripcion(int idInscripcion, int nota, Materia idMateria, Alumno idAlumno) {
        this.idInscripcion = idInscripcion;
        this.nota = nota;
        this.idMateria = idMateria;
        this.idAlumno = idAlumno;
    }

    public int getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(int idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public Materia getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Materia idMateria) {
        this.idMateria = idMateria;
    }

    public Alumno getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Alumno idAlumno) {
        this.idAlumno = idAlumno;
    }

    @Override
    public String toString() {
        return idAlumno + "/" + idMateria + "/" + nota;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.idInscripcion;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Inscripcion other = (Inscripcion) obj;
        if (this.idInscripcion != other.idInscripcion) {
            return false;
        }
        return true;
    }

    

    
    
    
    
    
    
    
    

    

    

    

}
