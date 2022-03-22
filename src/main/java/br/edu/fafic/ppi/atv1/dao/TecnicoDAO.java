package br.edu.fafic.ppi.atv1.dao;

import br.edu.fafic.ppi.atv1.domain.Tecnico;

import java.util.List;
import java.util.UUID;

public class TecnicoDAO extends GenericDAOImpl<Tecnico>{

    @Override
    public void saveOrUpdate(Tecnico entity) {
        super.saveOrUpdate(entity);
    }

    @Override
    public void delete(Tecnico entity) {
        super.delete(entity);
    }

    @Override
    public List<Tecnico> findAll(String namedQuerry) {
        return super.findAll(namedQuerry);
    }

    @Override
    public Tecnico findById(Class<Tecnico> cl, UUID id) {
        return super.findById(cl, id);
    }

    @Override
    public Tecnico findByName(String consulta, String parametro) {
        return super.findByName(consulta, parametro);
    }

    @Override
    public String findByString(String query, String parametro) {
        return super.findByString(query, parametro);
    }
}
