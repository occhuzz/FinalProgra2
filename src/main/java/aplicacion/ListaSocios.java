package aplicacion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListaSocios implements Serializable{
    
    private List<Persona> socios;
    
    public ListaSocios() {
        socios = new ArrayList<>();
    }
    
    public void agregarSocio(Persona p) {
        if (p != null) {
        socios.add(p);
        }
    }
    
    public Socio elegirSocio()
    {
        int opcion;
        int contador = 2;
        String posiblesUsuarios = "Elegir Socio \n\n[1] - Atras\n";
        
        for(Persona p : socios)
        {
            posiblesUsuarios += "[" + contador++ + "] - " + p.nombre + "\n";
        }
        
        do
        {
            opcion = EntradaSalida.leerInt(posiblesUsuarios);
        } while (opcion < 1 || opcion > socios.size()+1);
        
        if(opcion == 1){
            return null;
        }
        else{
           return (Socio) socios.get(opcion-2); 
        }
    }
}
