package br.carros.com.controller;

import br.carros.com.dao.VendaDAO;
import br.carros.com.model.Venda;
import java.util.List;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class VendaMBean extends AbstractController<Venda>{
    
    private Venda venda = new Venda();

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
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
        try {
            if (venda.getId()==0) {
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
