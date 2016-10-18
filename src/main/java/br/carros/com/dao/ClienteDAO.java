package br.carros.com.dao;

import br.carros.com.model.Cliente;

public class ClienteDAO extends GenericDAO<Cliente> {

    @Override
    public Class<Cliente> getClassType() {
       return Cliente.class;
    }
    
}
