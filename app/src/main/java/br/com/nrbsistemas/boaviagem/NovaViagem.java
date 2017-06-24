package br.com.nrbsistemas.boaviagem;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;

public class NovaViagem extends AppCompatActivity {

    private int ano,mes,dia;
    private Button dataSaida,dataChegada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_viagem);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Calendar calendar = Calendar.getInstance();
        ano = calendar.get(Calendar.YEAR);
        mes = calendar.get(Calendar.MONTH);
        dia = calendar.get(Calendar.DAY_OF_MONTH);



        dataChegada = (Button)findViewById(R.id.bt_dt_chegada);
        dataSaida = (Button)findViewById(R.id.bt_dt_saida);
        dataSaida.setText(ano+"/"+(mes+1)+"/"+dia);
        dataChegada.setText(ano+"/"+(mes+1)+"/"+dia);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    public void _datas(View view) {
        showDialog(view.getId());
        //Toast.makeText(this,"Selecionar data",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected Dialog onCreateDialog(int id) {

        if (R.id.bt_dt_saida == id){
            return new DatePickerDialog(this,listener,ano,mes,dia);
        }if (R.id.bt_dt_chegada== id){
            return new DatePickerDialog(this,listener,ano,mes,dia);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int daOfMonth) {
            ano = year;
            mes = monthOfYear;
            dia = daOfMonth;
            dataChegada.setText(ano+"/"+(mes+1)+"/"+dia);
            dataSaida.setText(ano+"/"+(mes+1)+"/"+dia);

        }

    };

    public void _salvarViagem(View view) {
        Toast.makeText(this,"Salvar viagem",Toast.LENGTH_SHORT).show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.novo_gasto,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.menu_novo_gasto:
                startActivity(new Intent(this,GastoViagem.class));
                break;
            case R.id.menu_remover:
                Toast.makeText(this,"Remover do banco ",Toast.LENGTH_SHORT).show();
            break;
        }

        return super.onOptionsItemSelected(item);
    }
}
