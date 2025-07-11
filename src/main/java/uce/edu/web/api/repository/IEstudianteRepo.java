package uce.edu.web.api.repository;

import uce.edu.web.api.repository.modelo.Estudiante;
import uce.edu.web.api.repository.modelo.Profesor;

import java.util.List;


public interface IEstudianteRepo {
    public Estudiante seleccionarPorId(Integer id);
    public List<Estudiante> seleccionarTodos();
    public void actualizar(Estudiante estudiante);
    public void actualizarParcial(Estudiante estudiante);
    public void borrarPorId(Integer id);
    public void insertar(Estudiante estudiante);
    public List<Estudiante> consultarTodos(String genero);

}

