package co.com.modelovistapresentador.login;

import co.com.modelovistapresentador.model.Credencial;
import co.com.modelovistapresentador.persistencia.Dao;

public interface Login {

    interface View{
        void validarInformacion();
        Credencial getCredenciales();
        void requerirUsuario();
        void requerirPassword();
        void rechazarCredenciales();
        void login();
    }

    interface Presenter{
        void validarInformacion();
        void requerirUsuario();
        void requerirPassword();
        void rechazarCredenciales();
        void login();
    }

    interface Model{
        void setCredenciales(Credencial credencial);
        void validarInformacion();
        void setDao(Dao dao);
    }


}
