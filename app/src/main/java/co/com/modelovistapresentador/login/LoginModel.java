package co.com.modelovistapresentador.login;

import co.com.modelovistapresentador.model.Credencial;
import co.com.modelovistapresentador.persistencia.Dao;

public class LoginModel implements Login.Model{

    private Login.Presenter presenter;
    private Credencial credencial;
    private Dao dao;

    public LoginModel(Login.Presenter presenter){
        this.presenter = presenter;
    }



    @Override
    public void setCredenciales(Credencial credencial) {
        if(credencial == null){
            credencial = new Credencial();
        }
        this.credencial = credencial;
    }

    @Override
    public void validarInformacion() {

        if(userIsValid()){
            presenter.requerirUsuario();
        }

        if(passIsValid()){
            presenter.requerirPassword();
        }

        if(credencialsValid()){
            presenter.rechazarCredenciales();
        }else{
            presenter.login();
        }
    }

    @Override
    public void setDao(Dao dao) {
        this.dao = dao;
    }

    private boolean credencialsValid() {
        return !dao.allowAccess().getUser().equals(credencial.getUser()) || !dao.allowAccess().getPassword().equals(credencial.getPassword());
    }

    private boolean passIsValid() {
        return credencial.getPassword() == null || "".equals(credencial.getPassword());
    }

    private boolean userIsValid() {
        return credencial.getUser() == null || "".equals(credencial.getUser());
    }
}
