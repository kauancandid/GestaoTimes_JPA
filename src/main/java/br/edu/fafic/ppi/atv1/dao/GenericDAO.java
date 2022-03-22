package br.edu.fafic.ppi.atv1.dao;

import java.util.List;
import java.util.UUID;

public interface GenericDAO <T>{

    //save or update
    void saveOrUpdate(T entity);

    //del
    void delete(T entity);
    List<T> findAll(String namedQuerry);

    T findById(Class<T> cl, UUID id);

    T findByName(String query, String parametro);

    String findByString(String query, String parametro);

    T findByEquipePlayer(String query, String parametro);


    String findByCamps(String query, String parametro);

}