package aplicacion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Empleado extends Persona implements Serializable{
    private int codigo;
    private String especialidad;
    private List<Zona> zonas;
    private List<Embarcacion> embarcaciones;
    private int cantEmbarcaciones;

    public Empleado(String usuario, String password, String nombre, String direccion, int telefono, int codigo, String especialidad) {
        super(usuario, password, nombre, direccion, telefono);
        this.codigo = codigo;
        this.especialidad = especialidad;
        zonas = new ArrayList<>();
        embarcaciones = new ArrayList<>();
        cantEmbarcaciones = 0;
    }

    //--------------------------------------------------------------------------
    //PROCEDER
    @Override
    public boolean proceder() {
        
        boolean cerrar = false, continuar = true;
        while (!cerrar) {
            char op;
            do {
                op = EntradaSalida.leerChar(
                        "MENÚ EMPLEADO\n\n"
                        + "[1] Mostrar datos\n"
                        + "[2] Cerrar sesión\n");
            } while (op < '1' || op > '2');

            switch (op) {
                case '1':
                    this.mostrarDatos();
                    break;
                case '2':
                    EntradaSalida.mostrarString("Saliendo..");
                    cerrar = true;
                    continuar = true;
                    break;
            }
        }
        return continuar;
    }
    
    //FIN PROCEDER
    //--------------------------------------------------------------------------
    //MOSTRAR DATOS
    public void mostrarDatos(){
        EntradaSalida.mostrarString("Datos Empleado:"
            + "\nUser: " + usuario
            +"\nPassword: " + password
            +"\nNombre: " + nombre
            +"\nDireccion: " + direccion
            +"\nTelefono: " + telefono
            +"\nCodigo: " + codigo
            +"\nEspecialidad: " + especialidad
            +"\nZonas: " + datosZona()
            +"\nCantidad Embarcaciones: " + cantEmbarcaciones);
    }
    
    public String datosZona(){
        String dato = "";
        for(Zona z : zonas)
        {
            dato = dato + z.getLetra() + ". ";
        }
        return dato;
    }
    //FIN MOSTRAR DATOS
    //--------------------------------------------------------------------------
    
    public void asignarZona(Zona z) {
        zonas.add(z);
    }
    
    public void asignarEmbarcacion(Embarcacion e) {
        if(e != null){
            this.cantEmbarcaciones += 1;
            this.embarcaciones.add(e);
            EntradaSalida.mostrarString("Empleado asignado a Embarcacion correctamente");
        }
    }

    public String getNombre() {
        return nombre;
    }
}
