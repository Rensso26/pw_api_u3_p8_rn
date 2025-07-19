package uce.edu.web.api.controller;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import org.eclipse.microprofile.jwt.Claim;
import org.eclipse.microprofile.jwt.ClaimValue;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import uce.edu.web.api.repository.modelo.Estudiante;
import uce.edu.web.api.service.HijoService;
import uce.edu.web.api.service.IEstudianteService;
import uce.edu.web.api.service.mapper.EstudianteMapper;
import uce.edu.web.api.service.mapper.HijoMapper;
import uce.edu.web.api.service.to.EstudianteTo;
import uce.edu.web.api.service.to.HijoTo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Path("/estudiantes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EstudianteController {

    @Inject
    JsonWebToken jwt;

    @Inject
    @Claim("sub")
    ClaimValue<String> subject;

    @Inject
    private HijoService hijoService;

    @Inject
    private IEstudianteService estudianteService;

    @GET
    @Path("/{id}")
    @RolesAllowed("admin")
    @Operation(summary = "Consultar un Estudiante", description = "Consulta un estudiante mediante su ID")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultarPorIP(@PathParam("id") Integer id,@Context UriInfo uriInfo){
        EstudianteTo estu = EstudianteMapper.toTO(this.estudianteService.buscarPorId(id)) ;
        estu.buildURI(uriInfo);
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
                                           @QueryParam("provincia") String provincia, @Context UriInfo uriInfo){
        List<EstudianteTo> estuList = this.estudianteService.buscarTodos(genero).stream().map(EstudianteMapper::toTO).collect(Collectors.toList());
        System.out.println(provincia);
        return Response.status(Response.Status.ACCEPTED).entity(estuList).build();
    }

    @POST
    @Path("")
    @Operation(
    )
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response guardar(@RequestBody EstudianteTo estudianteTo){
        Estudiante estudiante = EstudianteMapper.ToEntity(estudianteTo);
        this.estudianteService.guardar(estudiante);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response actualizar(@RequestBody EstudianteTo estudianteTo, @PathParam("id") Integer id){
        estudianteTo.setId(id);
        Estudiante estudiante = EstudianteMapper.ToEntity(estudianteTo);
        this.estudianteService.actualizar(estudiante);
        return Response.status(Response.Status.OK).build();
    }

    @PATCH
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response actualizarParcialPorId(@RequestBody EstudianteTo estudianteTo, @PathParam("id") Integer id, @Context UriInfo uriInfo){
        Estudiante estudiante = this.estudianteService.buscarPorId(id);

        if (estudiante.getApellido() != null){
            estudiante.setApellido(estudianteTo.getApellido());
        }
        if (estudiante.getNombre() != null){
            estudiante.setNombre(estudianteTo.getNombre());
        }
        if (estudiante.getFechaNacimiento() != null){
            estudiante.setFechaNacimiento(estudianteTo.getFechaNacimiento());
        }
        this.estudianteService.actualizarParcial(estudiante);
        return Response.status(Response.Status.OK).build();
    }

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
    public Response obtenerHijosPorID(@PathParam("id") Integer id){
       List<HijoTo> hijos = HijoMapper.toListTO(this.hijoService.buscarPorEstudianteId(id));
        return Response.status(Response.Status.OK).entity(hijos).build();
    }

}
