package edu.com.serieapp.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.List;

import edu.com.serieapp.R;
import edu.com.serieapp.modelo.SeriadoModelo;

public class SeriadoAdapter extends BaseAdapter {
    private List<SeriadoModelo> listarSeriado;
    private Context context;

    public SeriadoAdapter(List<SeriadoModelo> listarSeriado, Context context) {
        this.listarSeriado = listarSeriado;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listarSeriado.size();
    }

    @Override
    public Object getItem(int position) {
        return listarSeriado.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        SeriadoModelo modelo = (SeriadoModelo) getItem(position);
        View viewRetorno = convertView.inflate(context, R.layout.item_listar, null);

        TextView tvId = viewRetorno.findViewById(R.id.tvId);
        tvId.setText("Id: "+ modelo.getId());

        TextView tvGenero = viewRetorno.findViewById(R.id.tvGenero);
        tvGenero.setText("Genero: "+ modelo.getGenero());

        TextView tvStatus = viewRetorno.findViewById(R.id.tvStatus);
        tvStatus.setText("Status: "+ modelo.getStatus());


        TextView tvNome = viewRetorno.findViewById(R.id.tvNome);
        tvNome.setText("Nome: "+ modelo.getNome());

        TextView tvComentario = viewRetorno.findViewById(R.id.tvComentario);
        tvComentario.setText("Comentario: "+ modelo.getComentario());

        TextView tvNota = viewRetorno.findViewById(R.id.tvNota);
        tvNota.setText("Nota: "+ modelo.getNota());

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");


        TextView tvData = viewRetorno.findViewById(R.id.tvDataLan);
        tvData.setText("Data lançamento: "+ format.format(modelo.getDatalacamento()));


        return viewRetorno;
    }
}
