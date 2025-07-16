package uce.edu.web.api.service.mapper;

import uce.edu.web.api.repository.modelo.Estudiante;
import uce.edu.web.api.repository.modelo.Hijo;
import uce.edu.web.api.service.to.EstudianteTo;
import uce.edu.web.api.service.to.HijoTo;

import java.util.ArrayList;
import java.util.List;

public class HijoMapper {
    public static HijoTo toTO(Hijo hijo) {

        HijoTo hTo = new HijoTo();
        hTo.setId(hijo.getId());
        hTo.setNombre(hijo.getNombre());
        hTo.setApellido(hijo.getApellido());
        hTo.setEstudiante(hijo.getEstudiante());

        return hTo;
    }

    public static List<HijoTo> toListTO(List<Hijo> hijos) {
        List<HijoTo> listaTO = new ArrayList<>();
        for (Hijo hijo : hijos) {
            listaTO.add(toTO(hijo));
        }
        return listaTO;
    }

    public static Hijo ToEntity(HijoTo hijoTo) {

        Hijo h = new Hijo();
        h.setId(hijoTo.getId());
        h.setNombre(hijoTo.getNombre());
        h.setApellido(hijoTo.getApellido());
        h.setEstudiante(hijoTo.getEstudiante());
        return h;
    }
}
