package uce.edu.web.api.service;

import uce.edu.web.api.repository.modelo.Profesor;

import java.util.List;

public interface IProfesorService {

    public Profesor buscarPorId(Integer id);
    public List<Profesor> buscarTodos();
    public void actualizar(Profesor profesor);
    public void actualizarParcial(Profesor profesor);
    public void borrarPorId(Integer id);
    public void guardar(Profesor profesor);
}
