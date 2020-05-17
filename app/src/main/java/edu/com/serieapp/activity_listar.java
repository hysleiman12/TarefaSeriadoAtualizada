package edu.com.serieapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import edu.com.serieapp.adapter.SeriadoAdapter;
import edu.com.serieapp.dao.SeriadoDAO;
import edu.com.serieapp.modelo.SeriadoModelo;

public class activity_listar extends AppCompatActivity {
    private ListView lvListar;
    private SeriadoDAO dao = new SeriadoDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);

        lvListar = findViewById(R.id.lvListar);

        lvListar.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SeriadoModelo modeloSelecionado = (SeriadoModelo) parent.getItemAtPosition(position);

                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                intent.putExtra("modeloSelecionado", modeloSelecionado);
                startActivity(intent);

            }
        });

        lvListar.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                SeriadoModelo modeloSelecionado = (SeriadoModelo) parent.getItemAtPosition(position);
                dao.excluir(modeloSelecionado);
                carreagarListar();


                return false;
            }
        });






    }

    @Override
    protected void onResume() {
        super.onResume();
        carreagarListar();

    }
    private void carreagarListar(){
        SeriadoAdapter  adapter = new SeriadoAdapter(dao.listar(), getBaseContext());
        lvListar.setAdapter(adapter);
    }
}
