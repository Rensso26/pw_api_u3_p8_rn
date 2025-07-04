package uce.edu.web.api.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import uce.edu.web.api.repository.modelo.Estudiante;
import uce.edu.web.api.repository.modelo.Hijo;
import uce.edu.web.api.repository.modelo.LocalDateTimeAdapter;
import uce.edu.web.api.service.IEstudianteService;
import uce.edu.web.api.service.to.EstudianteTo;

import java.util.ArrayList;
import java.util.List;

@Path("/estudiantes")
public class EstudianteController {

    @Inject
    private IEstudianteService estudianteService;

    @GET
    @Path("/{id}")
    @Operation(summary = "Consultar un Estudiante", description = "Consulta un estudiante mediante su ID")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_XML)
    public Response consultarPorIP(@PathParam("id") Integer id,@Context UriInfo uriInfo){

        EstudianteTo estu = this.estudianteService.buscarPorId(id,uriInfo);

        return Response.status(227).entity(estu).build();
    }

    @GET
    @Path("")
    @Operation(
            summary = "Consultar  Estudiantes",
            description = "Muestra todos los estudiantes en estado de Lista"
    )
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultarTodos(@QueryParam("genero") String genero,
                                           @QueryParam("provincia") String provincia){
        System.out.println(provincia);
        return Response.status(Response.Status.ACCEPTED).entity(this.estudianteService.buscarTodos(genero)).build();

    }
    @POST
    @Path("")
    @Operation(
    )
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response guardar(@RequestBody Estudiante estudiante){
    this.estudianteService.guardar(estudiante);
        return Response.status(Response.Status.ACCEPTED).build();
    }
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response actualizar(@RequestBody Estudiante estudiante, @PathParam("id") Integer id){
        estudiante.setId(id);
        this.estudianteService.actualizar(estudiante);
        return Response.status(Response.Status.OK).build();
    }

//    @PATCH
//    @Path("/{id}")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response actualizarParcialPorId(@RequestBody Estudiante estudiante, @PathParam("id") Integer id, @Context UriInfo uriInfo){
//        estudiante.setId(id);
//        Estudiante e = this.estudianteService.buscarPorId(id,);
//        if (estudiante.getApellido() != null){
//            e.setApellido(estudiante.getApellido());
//        }
//        if (estudiante.getNombre() != null){
//            e.setNombre(estudiante.getNombre());
//        }
//        if (estudiante.getFechaNacimiento() != null){
//            e.setFechaNacimiento(estudiante.getFechaNacimiento());
//        }
//        this.estudianteService.actualizarParcial(e);
//        return Response.status(Response.Status.OK).build();
//    }
    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response borrarPorId(@PathParam("id") Integer id){
        this.estudianteService.borrarPorId(id);
        return Response.status(Response.Status.OK).build();
    }

    @GET
    @Path("/{id}/hijos")
    public List<Hijo> obtenerHijosPorID(@PathParam("id") Integer id){
        Hijo h1 = new Hijo();
        h1.setNombre("pepito");

        Hijo h2 = new Hijo();
        h2.setNombre("pepito");

        List<Hijo> hijos = new ArrayList<>();
        hijos.add(h1);
        hijos.add(h2);

        return hijos;
    }

}
