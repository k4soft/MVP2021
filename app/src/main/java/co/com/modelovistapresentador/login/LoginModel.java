package co.com.modelovistapresentador.login;

import co.com.modelovistapresentador.model.Credencial;

public class LoginModel implements Login.Model{

    private Login.Presenter presenter;
    private Credencial credencial;

    public LoginModel(Login.Presenter presenter){
        this.presenter = presenter;
    }



    @Override
    public void setCredenciales(Credencial credencial) {
        this.credencial = credencial;
    }

    @Override
    public void validarInformacion() {
        if("".equals(credencial.getUser())){
            presenter.requerirUsuario();
        }

        if("".equals(credencial.getPassword())){
            presenter.requerirPassword();
        }

        if(!"admin".equals(credencial.getUser()) || !"1234".equals(credencial.getPassword())){
            presenter.rechazarCredenciales();
        }else{
            presenter.login();
        }
    }
}
