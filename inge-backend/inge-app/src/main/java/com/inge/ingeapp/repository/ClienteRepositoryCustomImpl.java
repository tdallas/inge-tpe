package com.inge.ingeapp.repository;

import com.inge.ingeapp.controller.request.UpdateRequest;

import javax.persistence.Query;

public class ClienteRepositoryCustomImpl extends BaseRepositoryImpl implements ClienteRepositoryCustom {
    @Override
    public void updateUser(UpdateRequest updateRequest) {
        String hql = "UPDATE Cliente c SET c.direccion = :direccion, " +
                "c.email = :email, c.clave = :clave, c.telefono = :telefono WHERE c.id = :id";
        Query query = entityManager.createQuery(hql);
        query.setParameter("direccion", updateRequest.getDirecction());
        query.setParameter("email", updateRequest.getMail());
        query.setParameter("clave", updateRequest.getClave());
        query.setParameter("telefono", updateRequest.getTelefono());
        query.setParameter("id", updateRequest.getIdUser());
        query.executeUpdate();
    }
}
