package br.com.nrbsistemas.boaviagem;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;

public class GastoViagem extends AppCompatActivity {

    private Spinner spCategoria;
    private Button dataGasto;
    private int ano,mes,dia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gasto_viagem);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Calendar calendar = Calendar.getInstance();
        ano = calendar.get(Calendar.YEAR);
        mes = calendar.get(Calendar.MONTH);
        dia = calendar.get(Calendar.DAY_OF_MONTH);

        dataGasto = (Button)findViewById(R.id.bt_data);
        dataGasto.setText(dia+"/"+(mes+1)+"/"+ano);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,R.array.categoria_gasto,
                android.R.layout.simple_spinner_dropdown_item
        );

        spCategoria = (Spinner)findViewById(R.id.sp_categoria);
        spCategoria.setAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    public void _selecionarData(View view) {
        showDialog(view.getId());
        //Toast.makeText(this,"Selecionar data",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected Dialog onCreateDialog(int id) {

        if (R.id.bt_data == id){
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
            dataGasto.setText(ano+"/"+(mes+1)+"/"+dia);
        }
    };

    public void _salvarViagem(View view) {
        Toast.makeText(this,"Salvar viagem",Toast.LENGTH_SHORT).show();

    }

}
