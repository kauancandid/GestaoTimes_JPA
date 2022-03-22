package br.edu.fafic.ppi.atv1.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.UUID;

public class GenericDAOImpl<T> implements GenericDAO<T> {

    //envocando e apontando pro persistence
    private EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("gestaotimes");
    //criando
    private EntityManager en = emf.createEntityManager();


    @Override
    public void saveOrUpdate(T entity) {

        try {
            en.getTransaction().begin();//abrindo a transação com o banco de dados
            en.merge(entity); //salvando ou atualizando dentro do banco de dados (fznd a operação em si que eu queira no banco de dados)
            en.getTransaction().commit();//fechando a transação com o banco de dados
        } catch (Exception ex) {
            en.getTransaction().rollback();//se der ruim essa linha de cod, é pra retroceder (ou faz tudo ou num faz nada)
        }

    }

    @Override
    public T findById(Class<T> cl, UUID id) {
        //buscando pela classe e id...
        return en.find(cl, id);

    }

    @Override
    public T findByName(String consulta, String parametro) {
        Query query = en.createNamedQuery(consulta);
        query.setParameter("parametro", parametro);
        return (T) query.getSingleResult();

    }

    @Override
    public String findByString(String query, String parametro) {
        Query consulta = en.createNamedQuery(query);
        consulta.setParameter("parametro", parametro);
        return consulta.getSingleResult().toString();
    }

    @Override
    public T findByEquipePlayer(String query, String parametro) {
        Query query2 = en.createNamedQuery(query);
        query2.setParameter("parametro", parametro);
        return (T) query2.getSingleResult().toString();
    }


    @Override
    public String findByCamps(String query, String parametro) {
        Query query3 = en.createNamedQuery(query);
        query3.setParameter("parametro", parametro);
        return query3.getSingleResult().toString();
    }

    @Override
    public void delete(T entity) {
        //simplesmente removendo
        en.remove(entity);

    }

    @Override
    public List<T> findAll(String namedQuerry) {
        //exibir valores da tabela, esse metodo é pra auxiliar na busca
        Query query = en.createNamedQuery(namedQuerry);
        return query.getResultList();
    }

    public List<T> findList(String namedQuerry, String parametro) {
        Query query = en.createNamedQuery(namedQuerry);
        query.setParameter("parametro", parametro);
        return query.getResultList();
    }

    public List<T> findPlayerStatus(String namedQuerry, Boolean parametro) {
        Query query = en.createNamedQuery(namedQuerry);
        query.setParameter("parametro", parametro);
        return query.getResultList();
    }

}
