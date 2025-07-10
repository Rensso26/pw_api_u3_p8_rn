package uce.edu.web.api.service;

import uce.edu.web.api.repository.modelo.Estudiante;

import java.util.List;

public interface IEstudianteService {

    public Estudiante buscarPorId(Integer id);
    public List<Estudiante> buscarTodos(String genero);
    public void actualizar(Estudiante estudiante);
    public void actualizarParcial(Estudiante estudiante);
    public void borrarPorId(Integer id);
    public void guardar(Estudiante estudiante);
}
