package com.inge.ingeapp.repository;

import javax.persistence.Query;

public class UsuarioRepositoryCustomImpl extends BaseRepositoryImpl implements UsuarioRepositoryCustom {
    @Override
    public void invalidarUsuarioByEmail(String email) {
        String hql = "UPDATE Usuario u SET u.verificado = false WHERE u.email = :email";
        Query query = entityManager.createQuery(hql);
        query.setParameter("email", email);
        query.executeUpdate();
    }
}
