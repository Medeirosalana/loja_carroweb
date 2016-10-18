package br.carros.com.controller;

import br.carros.com.dao.CarroDAO;
import br.carros.com.model.Carro;
import java.util.List;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class CarroMBean  extends AbstractController<Carro>{
     private Carro carro = new Carro();

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }
    
    public List<Carro> getListaCompleta() {
        CarroDAO dao = new CarroDAO();
        try {
            return dao.findAll();
        } finally {
            dao.close();
        }
    }

    public String salvar() {
        CarroDAO dao = new CarroDAO();
        try {
            if (carro.getId()==0) {
                dao.create(carro);
                
            } else {
                dao.update(carro);
            }
            addInfo("Carro salvo com sucesso!");
        } finally {
            carro = new Carro();
            dao.close();
        }
        return null;
    }

    public String selecionar(Carro carro) {
        this.carro = carro;
        return null;
    }

    public String deletar(Carro carro) {
        CarroDAO dao = new CarroDAO();
        try {
            dao.delete(carro);
            addInfo("Carro apagado com sucesso!");
        } finally {
            dao.close();
        }
        return null;
    }
}
