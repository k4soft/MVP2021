package co.com.modelovistapresentador.login.persistencia;

import co.com.modelovistapresentador.model.Credencial;
import co.com.modelovistapresentador.persistencia.Dao;

public class DaoTest implements Dao {
    @Override
    public Credencial allowAccess() {
        Credencial credencial = new Credencial();
        credencial.setUser("prueba");
        credencial.setPassword("1234*");
        return credencial;
    }
}
