package br.carros.com.model;

import br.carros.com.dao.PersistDB;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Venda implements PersistDB{

    @Id
    @GeneratedValue
 private int id;
    @Temporal(TemporalType.DATE)
    private Date dt_venda;
    @ManyToMany
    private List<CartaDeCredito> cartas;
    @ManyToOne
    private Cliente cliente;
    @ManyToMany
    private List<Carro> carro; 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDt_venda() {
        return dt_venda;
    }

    public void setDt_venda(Date dt_venda) {
        this.dt_venda = dt_venda;
    }

    public List<CartaDeCredito> getCartas() {
        return cartas;
    }

    public void setCartas(List<CartaDeCredito> cartas) {
        this.cartas = cartas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Carro> getCarro() {
        return carro;
    }

    public void setCarro(List<Carro> carro) {
        this.carro = carro;
    }

    @Override
    public String toString() {
        return "Venda{" + "id=" + id + ", dt_venda=" + dt_venda + ", cartas=" + cartas + ", cliente=" + cliente + ", carro=" + carro + '}';
    }
    
    
}
