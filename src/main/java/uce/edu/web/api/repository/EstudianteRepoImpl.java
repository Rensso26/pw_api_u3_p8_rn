package uce.edu.web.api.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import uce.edu.web.api.repository.modelo.Estudiante;

import java.util.List;

@Transactional
@ApplicationScoped
public class EstudianteRepoImpl implements IEstudianteRepo {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Estudiante seleccionarPorId(Integer id) {
        return this.entityManager.find(Estudiante.class, id);
    }

    @Override
    public List<Estudiante> seleccionarTodos() {
        return List.of();
    }

    @Override
    public List<Estudiante> consultarTodos(String genero) {
        TypedQuery<Estudiante> myQuery = this.entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.genero =:genero", Estudiante.class);
        myQuery.setParameter("genero", genero);
        return myQuery.getResultList();
    }

    @Override
    public void actualizar(Estudiante estudiante) {
        this.entityManager.merge(estudiante);
    }

    @Override
    public void actualizarParcial(Estudiante estudiante) {
        this.entityManager.merge(estudiante);
    }

    @Override
    public void borrarPorId(Integer id) {
        this.entityManager.remove(this.seleccionarPorId(id));
    }

    @Override
    public void insertar(Estudiante estudiante) {
        this.entityManager.persist(estudiante);
    }
}
