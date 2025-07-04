package uce.edu.web.api.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.UriInfo;
import uce.edu.web.api.repository.IProfesorRepo;
import uce.edu.web.api.repository.modelo.Estudiante;
import uce.edu.web.api.repository.modelo.Profesor;
import uce.edu.web.api.service.to.EstudianteTo;
import uce.edu.web.api.service.to.ProfesorTo;

import java.util.List;

@ApplicationScoped
public class ProfesorServiceimpl implements IProfesorService{

    @Inject
    private IProfesorRepo profesorRepo;


    @Override
    public ProfesorTo buscarPorId(Integer id, UriInfo uriInfo) {
        Profesor e1 = this.profesorRepo.seleccionarPorId(id);
        ProfesorTo e = new ProfesorTo(e1.getId(), e1.getNombre(), e1.getApellido(),
                e1.getClsaes(), e1.getFacultad(), e1.getnHijos(), e1.getGenero(), uriInfo);
        return e;
    }

    @Override
    public List<Profesor> buscarTodos(String genero) {
        return this.profesorRepo.seleccionarTodos(genero);
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
