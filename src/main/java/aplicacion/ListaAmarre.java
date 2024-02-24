package aplicacion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListaAmarre implements Serializable{
    
    private List<Amarre> amarres;
    
    public ListaAmarre() {
    amarres = new ArrayList<>();
    }
    
    public void setAmarres(List<Amarre> amarres) {
        this.amarres = amarres;
    }
    
    public void agregar(Amarre a) {
        if (a != null) {
            amarres.add(a);
        }
    }
    
    public Amarre elegirAmarre()
    {
        int opcion;
        int contador = 2;
        String posiblesAmarres = "Elegir Amarre \n\n[1] - Atras\n";
        
        for(Amarre a : amarres)
        {
            posiblesAmarres += "[" + contador++ + "] - " + a.getNumeroAmarre() + "\n";
        }
        
        do
        {
            opcion = EntradaSalida.leerInt(posiblesAmarres);
        } while (opcion < 1 || opcion > amarres.size()+1);
        
        if(opcion == 1){
            return null;
        }
        else{
           return amarres.get(opcion-2); 
        }
    }
}
