package br.edu.fafic.ppi.atv1.dao;

import br.edu.fafic.ppi.atv1.domain.Campeonato;
import br.edu.fafic.ppi.atv1.domain.Equipe;
import br.edu.fafic.ppi.atv1.domain.Jogador;
import br.edu.fafic.ppi.atv1.domain.Tecnico;

import java.util.List;
import java.util.UUID;

public class CampeonatoDAO extends GenericDAOImpl<Campeonato>{

    @Override
    public void saveOrUpdate(Campeonato entity) {
        super.saveOrUpdate(entity);
    }

    @Override
    public void delete(Campeonato entity) {
        super.delete(entity);
    }

    @Override
    public List<Campeonato> findAll(String namedQuerry) {
        return super.findAll(namedQuerry);
    }

    @Override
    public Campeonato findById(Class<Campeonato> cl, UUID id) {
        return super.findById(cl, id);
    }

}
