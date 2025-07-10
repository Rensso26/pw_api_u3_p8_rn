package uce.edu.web.api.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import uce.edu.web.api.repository.IEstudianteRepo;
import uce.edu.web.api.repository.modelo.Estudiante;

import java.util.List;

@ApplicationScoped
public class EstudianteServiceimpl implements IEstudianteService{

    @Inject
    private IEstudianteRepo estudianteRepo;


    @Override
    public Estudiante buscarPorId(Integer id) {
        Estudiante e1 = this.estudianteRepo.seleccionarPorId(id);
        return e1;
    }

    @Override
    public List<Estudiante> buscarTodos(String genero) {
       return this.estudianteRepo.consultarTodos(genero);
    }

    @Override
    public void actualizar(Estudiante estudiante) {
        this.estudianteRepo.actualizar(estudiante);
    }

    @Override
    public void actualizarParcial(Estudiante estudiante) {
        this.estudianteRepo.actualizarParcial(estudiante);
    }

    @Override
    public void borrarPorId(Integer id) {
        this.estudianteRepo.borrarPorId(id);
    }

    @Override
    public void guardar(Estudiante estudiante) {
        this.estudianteRepo.insertar(estudiante);
    }
}
