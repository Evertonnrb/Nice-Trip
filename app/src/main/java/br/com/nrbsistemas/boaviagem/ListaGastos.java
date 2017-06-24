package br.com.nrbsistemas.boaviagem;

import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Everton on 23/06/2017.
 */

public class ListaGastos extends ListActivity implements AdapterView.OnItemClickListener{

    private List<Map<String,Object>> gastos;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       String[] de  = {"data","descrisao","valor","categoria"};
        int[] para = {R.id.tx_list_gasto_data,R.id.lista_gasto_descrisao,R.id.lista_gasto_valor,R.id.ly_categoria};

        SimpleAdapter adapter = new SimpleAdapter(this,listarGastos(),R.layout.lista_gasto,de,para);

        adapter.setViewBinder(new GastoViewBinder());
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);

        /*
        setListAdapter(new ArrayAdapter<String>(
                this,android.R.layout.simple_list_item_1,listarGatos()
        ));
        ListView listView = getListView();
        listView.setOnItemClickListener(this);
        */
    }

    private List<Map<String,Object>> listarGastos(){
        gastos = new ArrayList<Map<String, Object>>();

        Map<String,Object> item = new HashMap<String, Object>();
        item.put("data","12/12/2012");
        item.put("descrisao","Diaria Hotel");
        item.put("valor","260,00");
        item.put("categoria",R.color.colorhospedagem);
        gastos.add(item);

        return  gastos;
    }

/*
    private List<String> listarGatos(){
        return Arrays.asList("Sanduba 12.44","Sanduba 12.44","Sanduba 12.44","Sanduba 12.44");
    }
*/
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Map<String,Object> map = gastos.get(i);
        String descrisao = (String) map.get("descrisao");
        String msg = ""+descrisao;
        Toast.makeText(this,""+msg,Toast.LENGTH_SHORT).show();
    }

    private String dataAnterior="";

    /**
     * Classe necessária para fazer o bind para multipla seleção
     * de como escolher as cores certas como definido
     */
    private class GastoViewBinder implements SimpleAdapter.ViewBinder{

        @Override
        public boolean setViewValue(View view, Object data, String textRepresentation) {
            if (view.getId() == R.id.tx_list_gasto_data){
                if(!dataAnterior.equals(data)){
                    TextView textView  =(TextView)view;
                    textView.setText(textRepresentation);
                    dataAnterior = textRepresentation;
                    view.setVisibility(View.VISIBLE);
                }else{
                    view.setVisibility(View.GONE);
                }
                return true;
            }
            if (view.getId() == R.id.ly_categoria){
                Integer id = (Integer) data;
                view.setBackgroundColor(getResources().getColor(id));
                return true;
            }

            return false;
        }
    }
}
