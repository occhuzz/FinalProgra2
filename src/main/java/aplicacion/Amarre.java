package aplicacion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Amarre implements Serializable {

    private int numeroAmarre;
    protected int contadorAgua, contadorLuz;
    protected boolean mantenimiento;
    private List<Embarcacion> embarcacionAmarre;
    private List<Socio> socioAmarre;
    private List<Zona> zonaAmarre;
    private Date fechaCompra;

    public Amarre(int numeroAmarre, int contadorAgua, int contadorLuz, boolean mantenimiento) {
        this.numeroAmarre = numeroAmarre;
        this.contadorAgua = contadorAgua;
        this.contadorLuz = contadorLuz;
        this.mantenimiento = mantenimiento;
        embarcacionAmarre = new ArrayList<>();
        socioAmarre = new ArrayList<>();
        zonaAmarre = new ArrayList<>();
        fechaCompra = null;
    }

    public boolean asignarSocio(Socio s) {
        if (socioAmarre.size() < 1) {
            socioAmarre.add(s);
            return true;
        } else {
            EntradaSalida.mostrarString("Un amarre sólo puede estar asignado a un único Socio");
            return false;
        }
    }

    public boolean asignarEmbarcacion(Embarcacion e) {
        if (embarcacionAmarre.size() < 1) {
            embarcacionAmarre.add(e);
            return true;
        } else {
            EntradaSalida.mostrarString("Un amarre sólo puede estar asignado a una única Embarcación");
            return false;
        }
    }

    public boolean asignarZona(Zona z) {
        if (zonaAmarre.size() < 1) {
            zonaAmarre.add(z);
            return true;
        } else {
            EntradaSalida.mostrarString("Un amarre sólo puede estar asignado a una única Zona");
            return false;
        }
    }
    
    public void setFechaCompra(Date fechaCompra){
        this.fechaCompra = fechaCompra;
    }

    public int getNumeroAmarre() {
        return numeroAmarre;
    }
    
    public void mostrarDatos(){
        EntradaSalida.mostrarString("Datos Amarre:"
            +"\nNumero: " + numeroAmarre
            +"\nContador Agua: " + contadorAgua
            +"\nContador Luz: " + contadorLuz
            +"\nMantenimiento: " + mantenimiento
            +"\nFecha de Compra: " + fechaCompra
            +"\nEmbarcacion: " + datosEmbarcacion()
            +"\nSocio: " + datosSocio()
            +"\nZona: " + datosZona());
    }
    
    public String datosEmbarcacion(){
        String dato = "";
        for(Embarcacion e : embarcacionAmarre)
        {
            dato = dato + e.getNombre() + ". ";
        }
        return dato;
    }
    
    public String datosSocio(){
        String dato = "";
        for(Socio s : socioAmarre)
        {
            dato = dato + s.getNombre() + ". ";
        }
        return dato;
    }
    
    public String datosZona(){
        String dato = "";
        for(Zona z : zonaAmarre)
        {
            dato = dato + z.getLetra() + ". ";
        }
        return dato;
    }
}
