package br.carros.com.controller;

import br.carros.com.dao.ClienteDAO;
import br.carros.com.model.Cliente;
import java.util.List;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class ClienteMBean extends AbstractController<Cliente>{
    
    private Cliente cliente = new Cliente();

    public Cliente getCategoria() {
        return cliente;
    }

    public void setCategoria(Cliente cliente) {
        this.cliente = cliente;
    }

    
    
    public List<Cliente> getListaCompleta() {
        ClienteDAO dao = new ClienteDAO();
        try {
            return dao.findAll();
        } finally {
            dao.close();
        }
    }

    public String salvar() {
        ClienteDAO dao = new ClienteDAO();
        try {
            if (cliente.getId()==0) {
                dao.create(cliente);
            } else {
                dao.update(cliente);
            }
            addInfo("Cliente salvo com sucesso!");
        } finally {
        cliente = new Cliente();

            dao.close();
        }
        return null;
    }

    public String selecionar(Cliente cliente) {
        this.cliente = cliente;
        return null;
    }

    public String deletar(Cliente cliente) {
        ClienteDAO dao = new ClienteDAO();
        try {
            dao.delete(cliente);
            addInfo("Cliente apagado com sucesso!");
        } finally {
            dao.close();
        }
        return null;
    }
}
