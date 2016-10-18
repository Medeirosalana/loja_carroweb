package br.carros.com.dao;

import br.carros.com.model.Venda;

public class VendaDAO extends GenericDAO<Venda>{

    @Override
    public Class<Venda> getClassType() {
       return Venda.class;
    }

    
}
