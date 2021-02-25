package co.com.modelovistapresentador.login;

import co.com.modelovistapresentador.persistencia.impl.DaoSQLite;

public class LoginPresenter implements Login.Presenter {

    private Login.View view;
    private Login.Model model;

    public LoginPresenter(Login.View view){
        this.view = view;
        model = new LoginModel(this);
    }

    @Override
    public void validarInformacion() {
        if(view != null){
            model.setDao(new DaoSQLite());
            model.setCredenciales(view.getCredenciales());
            model.validarInformacion();
        }
    }

    @Override
    public void requerirUsuario() {
       if(view != null){
           view.requerirUsuario();
       }
    }

    @Override
    public void requerirPassword() {
        if(view != null){
            view.requerirPassword();
        }
    }

    @Override
    public void rechazarCredenciales() {
        if(view != null){
            view.rechazarCredenciales();
        }
    }

    @Override
    public void login() {
        if(view != null){
            view.login();
        }
    }
}
