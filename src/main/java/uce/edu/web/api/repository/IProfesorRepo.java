package uce.edu.web.api.repository;

import uce.edu.web.api.repository.modelo.Profesor;

import java.util.List;


public interface IProfesorRepo {
     public Profesor seleccionarPorId(Integer id);
     public List<Profesor> seleccionarTodos();
     public void actualizar(Profesor profesor);
     public void actualizarParcial(Profesor profesor);
     public void borrarPorId(Integer id);
     public void insartar(Profesor profesor);

}
