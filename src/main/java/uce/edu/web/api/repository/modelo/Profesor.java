package uce.edu.web.api.repository.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "profesor")
public class Profesor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prof_id")
    private Integer id;

    @Column(name = "prof_nombre")
    private String nombre;

    @Column(name = "prof_appelido")
    private String apellido;

    @Column(name = "prof_clases")
    private String[] clsaes;
    
    @Column(name = "prof_facultad")
    private String facultad;

    @Column(name = "prof_num_hijos")
    private Integer nHijos;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String[] getClsaes() {
        return clsaes;
    }

    public void setClsaes(String[] clsaes) {
        this.clsaes = clsaes;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public Integer getnHijos() {
        return nHijos;
    }

    public void setnHijos(Integer nHijos) {
        this.nHijos = nHijos;
    }

    

}
