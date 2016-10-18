package br.carros.com.dao;

import br.carros.com.model.Carro;

public class CarroDAO extends GenericDAO<Carro>{

    @Override
    public Class<Carro> getClassType() {
        return Carro.class;
    }
    
}
