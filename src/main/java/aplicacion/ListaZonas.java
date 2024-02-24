package aplicacion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListaZonas implements Serializable{
    
    private List<Zona> zonas;
    
    public ListaZonas() {
    zonas = new ArrayList<>();
    }
    
    public void setAmarres(List<Zona> zonas) {
        this.zonas = zonas;
    }
    
    public void agregar(Zona z) {
        if (z != null) {
            zonas.add(z);
        }
    }
    
    public Zona elegirZona()
    {
        int opcion;
        int contador = 2;
        String posiblesZonas = "Elegir Zona \n\n[1] - Atras\n";
        
        for(Zona z : zonas)
        {
            posiblesZonas += "[" + contador++ + "] - " + z.getLetra() + "\n";
        }
        
        do
        {
            opcion = EntradaSalida.leerInt(posiblesZonas);
        } while (opcion < 1 || opcion > zonas.size()+1);
        
        if(opcion == 1){
            return null;
        }
        else{
           return (Zona) zonas.get(opcion-2); 
        }
    }
}
