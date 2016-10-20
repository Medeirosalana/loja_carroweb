package br.carros.com.controller;

import br.carros.com.dao.CarroDAO;
import br.carros.com.dao.CartaDeCreditoDAO;
import br.carros.com.dao.ClienteDAO;
import br.carros.com.dao.VendaDAO;
import br.carros.com.model.Carro;
import br.carros.com.model.CartaDeCredito;
import br.carros.com.model.Cliente;
import br.carros.com.model.Venda;
import com.mysql.fabric.xmlrpc.Client;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean

public class VendaMBean extends AbstractController<Venda>{
    
    private Venda venda = new Venda();
    private Carro carro = new Carro();
    private CartaDeCredito carta = new CartaDeCredito();
   
    private Cliente cliente = new Cliente();

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }   
      public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

  
    
  public CartaDeCredito getCarta() {
        return carta;
    }

    public void setCarta(CartaDeCredito carta) {
        this.carta = carta;
    }
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
    public List<Venda> getListaCompleta() {
        VendaDAO dao = new VendaDAO();
        try {
            return dao.findAll();
        } finally {
            dao.close();
        }
    }

    public String salvar() {
        VendaDAO dao = new VendaDAO();
        CartaDeCreditoDAO cdao = new CartaDeCreditoDAO();
        CarroDAO cardao = new CarroDAO();
        ClienteDAO clidao = new ClienteDAO();
        try {
            if (venda.getId()==0) {
                carro = cardao.findByPrimaryKey(carro.getId());
                cliente = clidao.findByPrimaryKey(cliente.getId());
                carta = cdao.findByPrimaryKey(carta.getId());
                venda.setCarro(carro);
                venda.setCartas(carta);
                venda.setCliente(cliente);
                dao.create(venda);
            } else {
                dao.update(venda);
            }
            addInfo("Venda salva com sucesso!");
        } finally {
        venda = new Venda();

            dao.close();
        }
        return null;
    }
    

    public String selecionar(Venda venda) {
        this.venda = venda;
        return null;
    }

    public String deletar(Venda venda) {
        VendaDAO dao = new VendaDAO();
        try {
            dao.delete(venda);
            addInfo("Venda apagada com sucesso!");
        } finally {
            dao.close();
        }
        return null;
    }

  

    

  
}
