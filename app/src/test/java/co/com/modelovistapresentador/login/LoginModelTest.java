package co.com.modelovistapresentador.login;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import co.com.modelovistapresentador.login.persistencia.DaoTest;
import co.com.modelovistapresentador.model.Credencial;
import co.com.modelovistapresentador.persistencia.Dao;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LoginModelTest {

    @Mock
    private Login.View view;
    private Login.Presenter presenter;
    private Login.Model model;

    @Before
    public void setUp(){
        presenter = new LoginPresenter(view);
        model = new LoginModel(presenter);
    }

    @Test
    public void requerirCredenciales(){
        when(view.getCredenciales()).thenReturn(null);
        model.setCredenciales(view.getCredenciales());
        model.validarInformacion();
        verify(view).requerirUsuario();
        verify(view).requerirPassword();
    }

    @Test
    public void requerirUsuario(){
        Credencial credencial = new Credencial();
        credencial.setUser("");
        when(view.getCredenciales()).thenReturn(null);
        model.setCredenciales(view.getCredenciales());
        model.validarInformacion();
        verify(view).requerirUsuario();
    }

    @Test
    public void requerirPassword(){
        Credencial credencial = new Credencial();
        credencial.setUser("45237556");
        credencial.setPassword("");
        when(view.getCredenciales()).thenReturn(null);
        model.setCredenciales(view.getCredenciales());
        model.validarInformacion();
        verify(view).requerirPassword();
    }

    @Test
    public void rechazarCrendeciales(){
        Credencial credencial = new Credencial();
        credencial.setUser("45237556");
        credencial.setPassword("giuuiiugiug");
        when(view.getCredenciales()).thenReturn(null);
        model.setCredenciales(view.getCredenciales());
        model.validarInformacion();
        verify(view).rechazarCredenciales();
    }

    @Test
    public void permitirAcceso(){
        Credencial credencial = new Credencial();
        credencial.setUser("prueba");
        credencial.setPassword("1234*");
        when(view.getCredenciales()).thenReturn(credencial);
        model.setCredenciales(view.getCredenciales());
        Dao dao = new DaoTest();
        model.setDao(dao);
        model.validarInformacion();
        verify(view).login();
    }

}