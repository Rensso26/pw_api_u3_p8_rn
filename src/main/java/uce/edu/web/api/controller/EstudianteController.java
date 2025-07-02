package uce.edu.web.api.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import uce.edu.web.api.repository.modelo.Estudiante;
import uce.edu.web.api.service.IEstudianteService;

import java.util.List;

@Path("/estudiantes")

public class EstudianteController {

    @Inject
    private IEstudianteService estudianteService;

    @GET
    @Path("/{id}")
    @Operation(summary = "Consultar un Estudiante", description = "Consulta un estudiante mediante su ID")
    public Estudiante consultarPorIP(@PathParam("id") Integer id){
        return this.estudianteService.buscarPorId(id);
    }

//    @GET
//    @Path("")
//    @Operation(
//            summary = "Consultar  Estudiantes",
//            description = "Muestra todos los estudiantes en estado de Lista"
//    )
//    public List<Estudiante> consultarTodos(){
//        return this.estudianteService.buscarTodos();
//    }
    @GET
    @Path("")
    @Operation(
            summary = "Consultar  Estudiantes",
            description = "Muestra todos los estudiantes en estado de Lista"
    )
    public List<Estudiante> consultarTodos(@QueryParam("genero") String genero,
                                           @QueryParam("provincia") String provincia){
        System.out.println(provincia);
        return this.estudianteService.buscarTodos(genero);
    }
    @POST
    @Path("")
    @Operation(
    )
    public void guardar(@RequestBody Estudiante estudiante){
    this.estudianteService.guardar(estudiante);
    }
    @PUT
    @Path("/{id}")
    public void actualizar(@RequestBody Estudiante estudiante, @PathParam("id") Integer id){
        estudiante.setId(id);
        this.estudianteService.actualizar(estudiante);
    }

    @PATCH
    @Path("/{id}")
    public void actualizarParcialPorId(@RequestBody Estudiante estudiante, @PathParam("id") Integer id){
        estudiante.setId(id);
        Estudiante e = this.estudianteService.buscarPorId(id);
        if (estudiante.getApellido() != null){
            e.setApellido(estudiante.getApellido());
        }
        if (estudiante.getNombre() != null){
            e.setNombre(estudiante.getNombre());
        }
        if (estudiante.getFechaNacimiento() != null){
            e.setFechaNacimiento(estudiante.getFechaNacimiento());
        }
        this.estudianteService.actualizarParcial(e);

    }
    @DELETE
    @Path("/{id}")
    public void borrarPorId(@PathParam("id") Integer id){
        this.estudianteService.borrarPorId(id);
    }


}
