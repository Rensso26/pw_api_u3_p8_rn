package uce.edu.web.api.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import uce.edu.web.api.repository.IProfesorRepo;
import uce.edu.web.api.repository.modelo.Profesor;

import java.util.List;

@ApplicationScoped
public class ProfesorServiceimpl implements IProfesorService{

    @Inject
    private IProfesorRepo profesorRepo;


    @Override
    public Profesor buscarPorId(Integer id) {
        return this.profesorRepo.seleccionarPorId(id);
    }

    @Override
    public List<Profesor> buscarTodos() {
        return this.profesorRepo.seleccionarTodos();
    }

    @Override
    public void actualizar(Profesor profesor) {
        this.profesorRepo.actualizar(profesor);
    }

    @Override
    public void actualizarParcial(Profesor profesor) {
        this.profesorRepo.actualizarParcial(profesor);
    }

    @Override
    public void borrarPorId(Integer id) {
        this.profesorRepo.borrarPorId(id);
    }

    @Override
    public void guardar(Profesor profesor) {
        this.profesorRepo.insartar(profesor);
    }
}
