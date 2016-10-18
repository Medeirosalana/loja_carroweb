package br.carros.com.dao;

import br.carros.com.model.CartaDeCredito;

public class CartaDeCreditoDAO extends GenericDAO<CartaDeCredito> {

    @Override
    public Class<CartaDeCredito> getClassType() {
        return CartaDeCredito.class; 
    }
    
}
