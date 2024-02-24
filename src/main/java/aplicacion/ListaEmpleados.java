package aplicacion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListaEmpleados implements Serializable{
    
    private List<Persona> empleados;
    
    public ListaEmpleados() {
        empleados = new ArrayList<>();
    }
    
    public void agregarEmpleado(Persona p) {
        if (p != null) {
        empleados.add(p);
        }
    }
    
    public Empleado elegirEmpleado()
    {
        int opcion;
        int contador = 2;
        String posiblesEmpleados = "Elegir Empleado \n\n[1] - Atras\n";
        
        for(Persona p : empleados)
        {
            posiblesEmpleados += "[" + contador++ + "] - " + p.nombre + "\n";
        }
        
        do
        {
            opcion = EntradaSalida.leerInt(posiblesEmpleados);
        } while (opcion < 1 || opcion > empleados.size()+1);
        
        if(opcion == 1){
            return null;
        }
        else{
           return (Empleado) empleados.get(opcion-2); 
        }
    }
}
