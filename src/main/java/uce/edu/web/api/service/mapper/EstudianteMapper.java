package uce.edu.web.api.service.mapper;

import uce.edu.web.api.repository.modelo.Estudiante;
import uce.edu.web.api.service.to.EstudianteTo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EstudianteMapper {


    public static EstudianteTo toTO(Estudiante estudiante) {

        EstudianteTo eTo = new EstudianteTo();
        eTo.setId(estudiante.getId());
        eTo.setNombre(estudiante.getNombre());
        eTo.setApellido(estudiante.getApellido());
        eTo.setFechaNacimiento(estudiante.getFechaNacimiento());
        eTo.setGenero(estudiante.getGenero());

        return eTo;
    }

    public static List<EstudianteTo> toListTO(List<Estudiante> estudiantes) {
        List<EstudianteTo> listaTO = new ArrayList<>();
        for (Estudiante est : estudiantes) {
            listaTO.add(toTO(est));
        }
        return listaTO;
    }

    public static Estudiante ToEntity(EstudianteTo estudianteTo) {

        Estudiante e = new Estudiante();
        e.setId(estudianteTo.getId());
        e.setNombre(estudianteTo.getNombre());
        e.setFechaNacimiento(estudianteTo.getFechaNacimiento());
        e.setApellido(estudianteTo.getApellido());
        e.setGenero(estudianteTo.getGenero());
        return e;
    }
}
