package uce.edu.web.api.service;

import jakarta.ws.rs.core.UriInfo;
import uce.edu.web.api.repository.modelo.Estudiante;
import uce.edu.web.api.service.to.EstudianteTo;

import java.util.List;

public interface IEstudianteService {

    public EstudianteTo buscarPorId(Integer id, UriInfo uriInfo);
    public List<Estudiante> buscarTodos(String genero);
    public void actualizar(Estudiante estudiante);
    public void actualizarParcial(Estudiante estudiante);
    public void borrarPorId(Integer id);
    public void guardar(Estudiante estudiante);
}
