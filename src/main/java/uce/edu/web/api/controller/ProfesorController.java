package uce.edu.web.api.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import uce.edu.web.api.repository.modelo.Profesor;
import uce.edu.web.api.service.IProfesorService;

import java.util.List;

@Path("/profesores")
public class ProfesorController {

    @Inject
    private IProfesorService profesorService;

    @GET
    @Path("/{id}")
    public Profesor consultarPorIP(@PathParam("id") Integer id){
        return this.profesorService.buscarPorId(id);
    }
    @GET
    @Path("")
    public List<Profesor> consultarTodos(){
        return this.profesorService.buscarTodos();
    }
    @POST
    @Path("")
    public void guardar(@RequestBody Profesor profesor){
        this.profesorService.guardar(profesor);
    }
    @PUT
    @Path("/{id}")
    public void actualizar(@RequestBody Profesor profesor, @PathParam("id") Integer id){
        profesor.setId(id);
        this.profesorService.actualizar(profesor);
    }

    @PATCH
    @Path("/{id}")
    public void actualizarParcialPorId(@RequestBody Profesor profesor, @PathParam("id") Integer id){
        profesor.setId(id);
        Profesor e = this.profesorService.buscarPorId(id);
        if (profesor.getApellido() != null){
            e.setApellido(profesor.getApellido());
        }
        if (profesor.getNombre() != null){
            e.setNombre(profesor.getNombre());
        }
        if (profesor.getClsaes() != null){
            e.setClsaes(profesor.getClsaes());
        }
        if (profesor.getFacultad() != null){
            e.setFacultad(profesor.getFacultad());
        }
        if (profesor.getnHijos() != null){
            e.setnHijos(profesor.getnHijos());
        }
        this.profesorService.actualizar(e);
    }
    @DELETE
    @Path("/{id}")
    public void borrarPorId(@PathParam("id") Integer id){
        this.profesorService.borrarPorId(id);
    }
}