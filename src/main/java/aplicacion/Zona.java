package aplicacion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Zona implements Serializable{
    private char letra;
    private List<Embarcacion> embarcaciones;
    private List<Empleado> empleados;
    private int profundidad;
    private int ancho;
    private List<Amarre> amarres;
    private String tipo;

    public Zona(char letra, String tipo, int profundidad, int ancho) {
        this.letra = letra;
        embarcaciones = new ArrayList<>();
        empleados = new ArrayList<>();
        amarres = new ArrayList<>();
        this.profundidad = profundidad;
        this.ancho = ancho;
        this.tipo = tipo;
    }

    public char getLetra() {
        return letra;
    }
    
    public void asignarAmarre(Amarre a) {
        amarres.add(a);
    }
    
    public void asignarEmbarcacion(Embarcacion e) {
        embarcaciones.add(e);
    }
    
    public void asignarEmpleado(Empleado emp) {
        empleados.add(emp);
    }

    public int getCantEmbarcaciones() {
        return embarcaciones.size();
    }
    
    public Embarcacion getEmbarcacionZona(){
        int opcion;
        int contador = 2;
        String posiblesEmbarcaciones = "[1] - Ninguna\n";
        
        for(Embarcacion e : embarcaciones)
        {
            posiblesEmbarcaciones += "[" + contador++ + "] - " + e.getNombre() +"\n";
        }
        
        do
        {
            opcion = EntradaSalida.leerInt(posiblesEmbarcaciones);
        } while (opcion < 1 || opcion > embarcaciones.size()+1);
        
        if(opcion == 1){
            return null;
        }
        else{
           return embarcaciones.get(opcion-2); 
        }
    }
    
    public void mostrarDatos(){
        EntradaSalida.mostrarString("Datos Zona:"
            +"\nNumero: " + letra
            +"\nTipo: " + tipo
            +"\nProfundidad Amarre: " + profundidad
            +"\nAncho Amarre: " + ancho
            +"\nEmbarcacion: " + datosEmbarcacion()
            +"\nEmpleado: " + datosEmpleado()
            +"\nAmarre: " + datosAmarre());
    }
    
    public String datosEmbarcacion(){
        String dato = "";
        for(Embarcacion e : embarcaciones)
        {
            dato = dato + e.getNombre() + ". ";
        }
        return dato;
    }
    
    public String datosEmpleado(){
        String dato = "";
        for(Empleado e : empleados)
        {
            dato = dato + e.getNombre() + ". ";
        }
        return dato;
    }
    
    public String datosAmarre(){
        String dato = "";
        for(Amarre a : amarres)
        {
            dato = dato + a.getNumeroAmarre()+ ". ";
        }
        return dato;
    }
}
