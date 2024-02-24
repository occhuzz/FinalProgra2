package aplicacion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Socio extends Persona implements Serializable{

    private int dni;
    private Date fechaIngreso;
    private Date fechaCompraAmarre;
    private List<Amarre> amarres;
    private List<Embarcacion> embarcaciones;

    public Socio(String usuario, String password, String nombre, String direccion, int telefono, int dni, int dia, int mes, int anio) {
        super(usuario, password, nombre, direccion, telefono);
        this.dni = dni;
        this.fechaIngreso = new Date(anio, mes, dia);
        fechaCompraAmarre = null;
        amarres = new ArrayList<>();
        embarcaciones = new ArrayList<>();
    }

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

    public void asignarAmarre(Amarre a) {
        int dia, mes, anio;
        dia = EntradaSalida.leerInt("Ingrese Dia de Compra");
        mes = EntradaSalida.leerInt("Ingrese Mes de Compra");
        anio = EntradaSalida.leerInt("Ingrese Año de Compra");
        fechaCompraAmarre = new Date(anio, mes, dia);
        a.setFechaCompra(fechaCompraAmarre);
        amarres.add(a);
    }

    public void asignarEmbarcacion(Embarcacion e) {
        embarcaciones.add(e);
    }
    
    public void mostrarDatos(){
        EntradaSalida.mostrarString("Datos Socio:"
            + "\nUser: " + usuario
            +"\nPassword: " + password
            +"\nNombre: " + nombre
            +"\nDireccion: " + direccion
            +"\nTelefono: " + telefono
            +"\nDNI: " + dni
            +"\nFecha ingreso: " + fechaIngreso);
    }
    
    public String getNombre(){
        return nombre;
    }
}
