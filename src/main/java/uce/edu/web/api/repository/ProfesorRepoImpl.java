package uce.edu.web.api.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import uce.edu.web.api.repository.modelo.Profesor;

import java.util.List;

@Transactional
@ApplicationScoped
public class ProfesorRepoImpl implements IProfesorRepo{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Profesor seleccionarPorId(Integer id) {
        return this.entityManager.find(Profesor.class, id);
    }

    @Override
    public List<Profesor> seleccionarTodos() {
        TypedQuery<Profesor> myQuery = this.entityManager.createQuery("SELECT e FROM Profesor e", Profesor.class);
        return myQuery.getResultList();
    }

    @Override
    public void actualizar(Profesor profesor) {
        this.entityManager.merge(profesor);
    }

    @Override
    public void actualizarParcial(Profesor profesor) {
        this.entityManager.merge(profesor);
    }

    @Override
    public void borrarPorId(Integer id) {
        this.entityManager.remove(this.seleccionarPorId(id));
    }

    @Override
    public void insartar(Profesor profesor) {
        this.entityManager.persist(profesor);
    }
}
