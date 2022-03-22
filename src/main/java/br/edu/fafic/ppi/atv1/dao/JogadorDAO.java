package br.edu.fafic.ppi.atv1.dao;

import br.edu.fafic.ppi.atv1.domain.Jogador;

import java.util.List;
import java.util.UUID;

public class JogadorDAO extends GenericDAOImpl<Jogador> {

    @Override
    public void saveOrUpdate(Jogador entity) {
        super.saveOrUpdate(entity);
    }

    @Override
    public void delete(Jogador entity) {
        super.delete(entity);
    }

    @Override
    public List<Jogador> findAll(String namedQuerry) {
        return super.findAll(namedQuerry);
    }

    @Override
    public Jogador findById(Class<Jogador> cl, UUID id) {
        return super.findById(cl, id);
    }

    @Override
    public Jogador findByName(String consulta, String parametro) {
        return super.findByName(consulta, parametro);
    }


    @Override
    public String findByString(String query, String parametro) {
        return super.findByString(query, parametro);
    }
}
