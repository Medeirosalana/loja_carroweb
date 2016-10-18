package br.carros.com.controller;

import br.carros.com.dao.PersistDB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


public class AbstractController<T extends PersistDB> {

    public void addInfo(String msg) {
        FacesMessage fm = new FacesMessage(msg);
        FacesContext.getCurrentInstance().addMessage(null, fm);
    }
	
}