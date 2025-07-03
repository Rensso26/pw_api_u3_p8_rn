package uce.edu.web.api.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
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
    @Operation(summary = "Consultar un Profesor", description = "Consulta un profesor mediante su ID")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_XML)
    public Response consultarPorIP(@PathParam("id") Integer id){
        return Response.status(227).entity(this.profesorService.buscarPorId(id)).build() ;
    }
    @GET
    @Path("")
    @Operation(summary = "Consultar Profesores", description = "Consulta todos los profesores")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultarTodos(@QueryParam("genero") String genero,
                                         @QueryParam("provincia") String provincia){
        System.out.println(provincia);
        return Response.status(227).entity(this.profesorService.buscarTodos(genero)).build() ;
    }
    @POST
    @Path("")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response guardar(@RequestBody Profesor profesor){
        this.profesorService.guardar(profesor);
        return Response.status(227).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response actualizar(@RequestBody Profesor profesor, @PathParam("id") Integer id){
        profesor.setId(id);
        this.profesorService.actualizar(profesor);
        return Response.status(227).build();
    }

    @PATCH
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response actualizarParcialPorId(@RequestBody Profesor profesor, @PathParam("id") Integer id){
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
        return Response.status(227).build();
    }
    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response borrarPorId(@PathParam("id") Integer id){
        this.profesorService.borrarPorId(id);
        return Response.status(227).build();
    }
}