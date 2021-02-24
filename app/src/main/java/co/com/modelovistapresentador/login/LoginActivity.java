package co.com.modelovistapresentador.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.com.modelovistapresentador.R;
import co.com.modelovistapresentador.model.Credencial;
import co.com.modelovistapresentador.welcome.WelcomeActivity;

public class LoginActivity extends AppCompatActivity implements Login.View{

    @BindView(R.id.user)
    EditText user;

    @BindView(R.id.password)
    EditText password;

    Login.Presenter presenter;
    Credencial credencial;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);
        ButterKnife.bind(this);
        initComponents();
    }

    private void initComponents() {
        presenter = new LoginPresenter(this);
        credencial = new Credencial();
    }

    @Override
    public void validarInformacion() {
       presenter.validarInformacion();
    }

    @Override
    public Credencial getCredenciales() {
        return credencial;
    }

    @Override
    public void requerirUsuario() {
        user.setError(getString(R.string.requerido));
    }

    @Override
    public void requerirPassword() {
        password.setError(getString(R.string.requerido));
    }

    @Override
    public void rechazarCredenciales() {
        Toast.makeText(getApplicationContext(),R.string.rechazo_credenciales,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void login() {
        startActivity(new Intent(this, WelcomeActivity.class));
    }

    public void enviarinformacion(View view) {
        credencial.setUser(user.getText().toString());
        credencial.setPassword(password.getText().toString());
        validarInformacion();
    }
}