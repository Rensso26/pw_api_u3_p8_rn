package uce.edu.web.api.service.to;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.ws.rs.core.UriInfo;
import uce.edu.web.api.controller.ProfesorController;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class ProfesorTo {

    private Integer id;
    private String nombre;
    private String apellido;
    private String[] clsaes;
    private String facultad;
    private Integer nHijos;
    private String genero;
    public Map<String,String> _links = new HashMap<>();

    public ProfesorTo(Integer id, String nombre, String apellido, String[] clsaes, String facultad, Integer nHijos, String genero, UriInfo uriInfo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.clsaes = clsaes;
        this.facultad = facultad;
        this.nHijos = nHijos;
        this.genero = genero;

        URI TodoslosHijos = uriInfo.getBaseUriBuilder().path(ProfesorController.class).path(ProfesorController.class, "obtenerHijosPorID").build(id);
        _links.put("Hijos",TodoslosHijos.toString());
    }

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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
