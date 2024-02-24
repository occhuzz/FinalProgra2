package aplicacion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Embarcacion implements Serializable {

    private String nombre;
    private String tipo;
    private String dimensiones;
    private int matricula;
    protected Date fechaAmarrado;
    List<Socio> Socios;
    List<Amarre> Amarres;
    List<Zona> Zonas;

    public Embarcacion(String nombre, String tipo, String dimensiones, int matricula) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.dimensiones = dimensiones;
        this.matricula = matricula;
        fechaAmarrado = null;
        Socios = new ArrayList<>();
        Amarres = new ArrayList<>();
        Zonas = new ArrayList<>();
    }

    public boolean asignarSocio(Socio s) {
        if (Socios.size() < 1) {
            Socios.add(s);
            return true;
        } else {
            EntradaSalida.mostrarString("Una embarcacion sólo puede estar asignado a un único Socio");
            return false;
        }
    }

    public boolean asignarAmarre(Amarre a) {
        int dia, mes, anio;
        if (Amarres.size() < 1) {
            dia = EntradaSalida.leerInt("Ingrese Dia de Asignación");
            mes = EntradaSalida.leerInt("Ingrese Mes de Asignación");
            anio = EntradaSalida.leerInt("Ingrese Año de Asignación");
            fechaAmarrado = new Date(anio, mes, dia);
            Amarres.add(a);
            return true;
        } else {
            EntradaSalida.mostrarString("Una embarcacion sólo puede estar asignado a un único Amarre");
            return false;
        }
    }
    
    public boolean asignarZona(Zona z) {
        if (Zonas.size() < 1) {
            Zonas.add(z);
            return true;
        } else {
            EntradaSalida.mostrarString("Una embarcacion sólo puede estar asignado a una única Zona");
            return false;
        }
    }
    
    public void mostrarDatos(){
        EntradaSalida.mostrarString("Datos Embarcacion:"
            +"\nNombre: " + nombre
            +"\nTipo: " + tipo
            +"\nDimensiones: " + nombre
            +"\nMatricula: " + matricula
            +"\nFecha de Amarrado: " + fechaAmarrado
            +"\nSocio: " + datosSocio()
            +"\nAmarre: " + datosAmarre()
            +"\nZona: " + datosZona());
    }
    
    public String datosSocio(){
        String dato = "";
        for(Socio s : Socios)
        {
            dato = dato + s.getNombre() + ". ";
        }
        return dato;
    }
    
    public String datosAmarre(){
        String dato = "";
        for(Amarre a : Amarres)
        {
            dato = dato + a.getNumeroAmarre()+ ". ";
        }
        return dato;
    }
    
    public String datosZona(){
        String dato = "";
        for(Zona z : Zonas)
        {
            dato = dato + z.getLetra() + ". ";
        }
        return dato;
    }
    
    public String getNombre() {
        return nombre;
    }
}
