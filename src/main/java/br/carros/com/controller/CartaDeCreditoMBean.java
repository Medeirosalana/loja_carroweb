package br.carros.com.controller;

import br.carros.com.dao.CartaDeCreditoDAO;
import br.carros.com.model.CartaDeCredito;
import java.util.List;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class CartaDeCreditoMBean extends AbstractController<CartaDeCredito>{
    
    private CartaDeCredito carta = new CartaDeCredito();

    public CartaDeCredito getCartaDeCredito() {
        return carta;
    }

    public void setCartaDeCredito(CartaDeCredito carta) {
        this.carta = carta;
    }
    
    public List<CartaDeCredito> getListaCompleta() {
        CartaDeCreditoDAO dao = new CartaDeCreditoDAO();
        try {
            return dao.findAll();
        } finally {
            dao.close();
        }
    }

    public String salvar() {
        CartaDeCreditoDAO dao = new CartaDeCreditoDAO();
        try {
            if (carta.getId()==0) {
                dao.create(carta);
            } else {
                dao.update(carta);
            }
            addInfo("Carta de credito salva com sucesso!");
        } finally {
        carta = new CartaDeCredito();

            dao.close();
        }
        return null;
    }

    public String selecionar(CartaDeCredito carta) {
        this.carta = carta;
        return null;
    }

    public String deletar(CartaDeCredito carta) {
        CartaDeCreditoDAO dao = new CartaDeCreditoDAO();
        try {
            dao.delete(carta);
            addInfo("Carta de credito apagada com sucesso!");
        } finally {
            dao.close();
        }
        return null;
    }
}
