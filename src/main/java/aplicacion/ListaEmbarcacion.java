package aplicacion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListaEmbarcacion implements Serializable{
    
    private List<Embarcacion> embarcaciones;
    
    public ListaEmbarcacion() {
    embarcaciones = new ArrayList<>();
    }
    
    public void setEmbarcacion(List<Embarcacion> embarcaciones) {
        this.embarcaciones = embarcaciones;
    }
    
    public void agregar(Embarcacion e) {
        if (e != null) {
            embarcaciones.add(e);
        }
    }
    
    public Embarcacion elegirEmbarcacion()
    {
        int opcion;
        int contador = 2;
        String posiblesAmarres = "Elegir Embarcacion \n\n[1] - Atras\n";
        
        for(Embarcacion e : embarcaciones)
        {
            posiblesAmarres += "[" + contador++ + "] - " + e.getNombre() + "\n";
        }
        
        do
        {
            opcion = EntradaSalida.leerInt(posiblesAmarres);
        } while (opcion < 1 || opcion > embarcaciones.size()+1);
        
        if(opcion == 1){
            return null;
        }
        else{
           return embarcaciones.get(opcion-2); 
        }
    }
    
    public int obtenerCantidadEmbarcaciones() {
        return embarcaciones.size();
    }
}
