package uce.edu.web.api.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.UriInfo;
import uce.edu.web.api.repository.IEstudianteRepo;
import uce.edu.web.api.repository.modelo.Estudiante;
import uce.edu.web.api.service.to.EstudianteTo;

import java.util.List;

@ApplicationScoped
public class EstudianteServiceimpl implements IEstudianteService{

    @Inject
    private IEstudianteRepo estudianteRepo;


    @Override
    public EstudianteTo buscarPorId(Integer id, UriInfo uriInfo) {
        Estudiante e1 = this.estudianteRepo.seleccionarPorId(id);
        EstudianteTo e = new EstudianteTo(e1.getId(), e1.getNombre(), e1.getApellido(),
                e1.getFechaNacimiento(), e1.getGenero(), uriInfo);
        return e;
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
