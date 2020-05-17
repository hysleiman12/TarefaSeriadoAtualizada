package edu.com.serieapp.dao;

import java.util.ArrayList;
import java.util.List;

import edu.com.serieapp.modelo.SeriadoModelo;

public class SeriadoDAO {
    private static List<SeriadoModelo> listarSeriado = new ArrayList<>();
    private static Long idGerador = 1L;

    public void incluir(SeriadoModelo seriadoModelo){
        seriadoModelo.setId(idGerador++);

        listarSeriado.add(seriadoModelo);

    }
    public void excluir(SeriadoModelo seriadoModelo){
        listarSeriado.remove(seriadoModelo);
    }
    public List<SeriadoModelo> listar(){
        return listarSeriado;
    }
    public void alterar(SeriadoModelo seriadoModelo){
        for (SeriadoModelo seriadoModeloAux: listarSeriado) {
            Long idSeriado = seriadoModelo.getId();
            Long idSeriadoAux = seriadoModeloAux.getId();
            if(idSeriado == idSeriadoAux){
                listarSeriado.remove(seriadoModeloAux);
                listarSeriado.add(seriadoModelo);
                break;

            }


        }

    }



}
