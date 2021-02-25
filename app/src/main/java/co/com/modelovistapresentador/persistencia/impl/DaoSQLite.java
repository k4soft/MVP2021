package co.com.modelovistapresentador.persistencia.impl;

import co.com.modelovistapresentador.model.Credencial;
import co.com.modelovistapresentador.persistencia.Dao;

public class DaoSQLite implements Dao {

    @Override
    public Credencial allowAccess() {
        Credencial credencial = new Credencial();
        credencial.setUser("admin");
        credencial.setPassword("1234");
        return credencial;
    }
}
