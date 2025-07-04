package uce.edu.web.api.service;

import jakarta.ws.rs.core.UriInfo;
import uce.edu.web.api.repository.modelo.Profesor;
import uce.edu.web.api.service.to.ProfesorTo;

import java.util.List;

public interface IProfesorService {

    public ProfesorTo buscarPorId(Integer id, UriInfo uriInfo);
    public List<Profesor> buscarTodos(String genero);
    public void actualizar(Profesor profesor);
    public void actualizarParcial(Profesor profesor);
    public void borrarPorId(Integer id);
    public void guardar(Profesor profesor);
}
