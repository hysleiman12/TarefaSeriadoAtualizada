package edu.com.serieapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import edu.com.serieapp.dao.SeriadoDAO;
import edu.com.serieapp.modelo.SeriadoModelo;

public class MainActivity extends AppCompatActivity {

    private EditText etGenero;
    private EditText etStatus;
    private EditText etNome;
    private EditText etComentario;
    private EditText etNota;
    private EditText etDataLan;



    SeriadoModelo modelo = new SeriadoModelo();
    SeriadoDAO dao = new SeriadoDAO();

    Date dataConvertida = null;
    Date atual = new Date();

    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etGenero = findViewById(R.id.etGenero);
        etStatus = findViewById(R.id.etStatus);
        etNome = findViewById(R.id.etNome);
        etComentario = findViewById(R.id.etComentario);
        etNota = findViewById(R.id.etNota);
        etDataLan = findViewById(R.id.etDataLan);

        Intent intent = getIntent();
        if(intent != null){
            SeriadoModelo modeloSelecionado = (SeriadoModelo) intent.getSerializableExtra("modeloSelecionado");
            if(modeloSelecionado != null){
                popularFormulario(modeloSelecionado);

            }

        }



    }
    private void popularFormulario(SeriadoModelo modeloSelecionado){

        etGenero.setText(modeloSelecionado.getGenero());
        etStatus.setText(modeloSelecionado.getStatus());
        etNome.setText(modeloSelecionado.getNome());
        etComentario.setText(modeloSelecionado.getComentario());
        etNota.setText(String.valueOf(modeloSelecionado.getNota()));


        etDataLan.setText(format.format(modeloSelecionado.getDatalacamento()));

        modelo.setId(modeloSelecionado.getId());

    }
    private void popularModelo(){


        modelo.setGenero(etGenero.getText().toString());
        modelo.setStatus(etStatus.getText().toString());
        modelo.setNome(etNome.getText().toString());
        modelo.setComentario(etComentario.getText().toString());
        modelo.setNota(Integer.parseInt(etNota.getText().toString()));
        try {
            dataConvertida = format.parse(etDataLan.getText().toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        modelo.setDatalacamento(dataConvertida);




    }

    public void salvar(View view){

        String paramGenero = etGenero.getText().toString();
        String paramStatus = etStatus.getText().toString();
        String paramNome = etNome.getText().toString();
        String paramComentario = etComentario.getText().toString();
        String  paramNota = etNota.getText().toString();
        String paramDataLan = etDataLan.getText().toString();

        try {
            dataConvertida = format.parse(paramDataLan);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(paramGenero.equals("") && paramStatus.equals("") && paramNome.equals("")
                && paramComentario.equals("") && paramNota.equals("")&& dataConvertida == null){

            Toast.makeText(getBaseContext(),
                    "Todos os campos estão vazios!", Toast.LENGTH_LONG).show();

        }else if(paramGenero.equals("") || paramStatus.equals("") || paramNome.equals("")
                || paramComentario.equals("") || paramNota.equals("") || dataConvertida == null){

            if(paramGenero.equals("")){

                Toast.makeText(getBaseContext(),
                        "O campo genero não pode estar vazio!", Toast.LENGTH_LONG).show();

            }else if(paramStatus.equals("")){

                Toast.makeText(getBaseContext(),
                        "O campo statu não pode estar vazio!", Toast.LENGTH_LONG).show();

            }else if(paramNome.equals("")){

                Toast.makeText(getBaseContext(),
                        "O campo nome não pode estar vazio!", Toast.LENGTH_LONG).show();

            }else if(paramComentario.equals("")){

                Toast.makeText(getBaseContext(),
                        "O campo comentario não pode estar vazio!", Toast.LENGTH_LONG).show();

            }else if(paramNota.equals("")){

                Toast.makeText(getBaseContext(),
                        "O campo nota não pode estar vazio!", Toast.LENGTH_LONG).show();

            }else if(dataConvertida == null){
                Toast.makeText(getBaseContext(),
                        "O campo data não pode está vazio!", Toast.LENGTH_LONG).show();

            }

        }else if(dataConvertida.after(atual)) {
            Toast.makeText(getBaseContext(),
                    "O campo data não pode ser maior que a data atual!", Toast.LENGTH_LONG).show();
        } else {
            popularModelo();
       if (modelo.getId() == null) {

                dao.incluir(modelo);

                Toast.makeText(getBaseContext(),
                        "Inclusão realizada com sucesso!", Toast.LENGTH_LONG).show();
                limparCampos();


            } else {
                dao.alterar(modelo);
                Toast.makeText(getBaseContext(),
                        "Alteração realizada com sucesso!", Toast.LENGTH_LONG).show();
                limparCampos();
            }
        }

    }
    public void limparCampos(){
        etGenero.setText("");
        etStatus.setText("");
        etNome.setText("");
        etComentario.setText("");
        etNota.setText("");
        etDataLan.setText("");
        modelo = new SeriadoModelo();


    }
    public void limpar(View view){
        limparCampos();
    }

    public void listar(View view){
        Intent intent = new Intent(getBaseContext(), activity_listar.class);
        startActivity(intent);


    }


}
