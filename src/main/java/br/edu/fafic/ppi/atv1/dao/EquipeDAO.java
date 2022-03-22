package br.edu.fafic.ppi.atv1.dao;

import br.edu.fafic.ppi.atv1.domain.Equipe;
import br.edu.fafic.ppi.atv1.domain.Jogador;
import br.edu.fafic.ppi.atv1.domain.Tecnico;

import java.util.List;
import java.util.UUID;

public class EquipeDAO extends GenericDAOImpl<Equipe>{

    @Override
    public void saveOrUpdate(Equipe entity) {
        super.saveOrUpdate(entity);
    }

    @Override
    public void delete(Equipe entity) {
        super.delete(entity);
    }

    @Override
    public List<Equipe> findAll(String namedQuerry) {
        return super.findAll(namedQuerry);
    }

    @Override
    public Equipe findById(Class<Equipe> cl, UUID id) {
        return super.findById(cl, id);
    }

    @Override
    public Equipe findByName(String consulta, String parametro) {
        return super.findByName(consulta, parametro);
    }

    @Override
    public Equipe findByEquipePlayer(String consulta, String parametro) {
        return super.findByEquipePlayer(consulta, parametro);
    }

    @Override
    public String findByString(String query, String parametro) {
        return super.findByString(query, parametro);
    }

    @Override
    public List<Equipe> findList(String namedQuerry, String parametro) {
        return super.findList(namedQuerry, parametro);
    }


    public List<Equipe> listByName(String consulta, String parametro){
        return super.findList(consulta, parametro);
    }
}