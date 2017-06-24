package br.com.nrbsistemas.boaviagem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView opcNovoGasto,opcMinhaViajens,opcNovaViagem,opcConfiguracao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id){
            case R.id.menu_sair:
                finish();
                break;
        }

        return true;
    }

    public void _selecioarOpc(View view) {
        TextView textView = (TextView) view;
        String opc = ""+textView.getText().toString();
        Toast.makeText(this,""+opc,Toast.LENGTH_SHORT).show();

        switch (view.getId()){
            case R.id.nova_viagem:
                startActivity(new Intent(this,NovaViagem.class));
                break;
            case R.id.novo_gasto:
                startActivity(new Intent(this, GastoViagem.class));
                break;
            case R.id.minha_viagens:
                startActivity(new Intent(this,ListaViagens.class));
                break;
            case R.id.configuracoes:
                Toast.makeText(this,"Vakao viado",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
