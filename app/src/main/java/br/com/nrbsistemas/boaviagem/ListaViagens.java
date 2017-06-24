package br.com.nrbsistemas.boaviagem;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Everton on 23/06/2017.
 */

public class ListaViagens extends ListActivity implements AdapterView.OnItemClickListener{

    private List<Map<String,Object>> viagens;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        String[] de= {"imagem","destino","data","valor"};
        int[] para = {R.id.iv_list_tipo_viagem,R.id.ed_list_destino,R.id.ed_list_data,R.id.ed_list_valor};

        SimpleAdapter adapter = new SimpleAdapter(this,listarViagens(),R.layout.lista_viagem,de,para);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);

       /*
        setListAdapter(new ArrayAdapter<String>(
                this,android.R.layout.simple_list_item_1,listarViagens()
        ));*/

        ListView listView = getListView();
        listView.setOnItemClickListener(this);
    }

    private List<Map<String,Object>> listarViagens(){
        viagens = new ArrayList<Map<String, Object>>();

        Map<String,Object> item = new HashMap<String, Object>();
        item.put("imagem",R.drawable.ic_business_center_black_24dp);
        item.put("destino","São paulo");
        item.put("data","01/02/2012 a 11/02/2013");
        item.put("valor","1234,99");
        viagens.add(item);

        item = new HashMap<String, Object>();
        item.put("imagem",R.drawable.ic_wb_sunny_black_24dp);
        item.put("destino","New York");
        item.put("data","01/02/2012 a 11/02/2013");
        item.put("valor","1234,99");
        viagens.add(item);

        return viagens;
    }
    /*
    private List<String> listarViagens(){
        return Arrays.asList("São Paulo","Maceio","Alagoas","Curitiba","Bonito");
    }*/

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

        Map<String,Object> map = viagens.get(position);
        String destino = (String) map.get("destino");
        Toast.makeText(this,""+destino,Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this,ListaGastos.class));
    }
}
