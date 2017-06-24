package br.com.nrbsistemas.boaviagem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TelaLogin extends AppCompatActivity {

    private EditText edLogin, edSenha;
    private Button btLogar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);

        edLogin = (EditText) findViewById(R.id.ed_login);
        edSenha = (EditText) findViewById(R.id.ed_senha);
        btLogar = (Button) findViewById(R.id.bt_logar);

        btLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validar()) {
                    logar(edLogin, edSenha);

                }
            }
        });

    }

    private boolean logar(EditText login, EditText senha) {
        String login1 = edLogin.getText().toString();
        String senha1 = edSenha.getText().toString();
        if ("leitor".equals(login1) && "123".equals(senha1)) {
            startActivity(new Intent(this,MainActivity.class));
            //finish();
        }
        onRestart();
        return false;
    }

    private boolean validar() {
        if (edLogin.getText().toString().isEmpty() && edSenha.getText().toString().isEmpty()) {
            edLogin.setError(getString(R.string.campos_vazio));
            edSenha.setError(getString(R.string.campos_vazio));
        }
        return true;
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        edLogin.setText("");
        edSenha.setText("");
    }
}
