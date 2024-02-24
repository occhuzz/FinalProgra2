package aplicacion;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Sistema implements Serializable {

    private BaseUsuarios usuarios;
    private ListaEmbarcacion embarcaciones;
    private ListaAmarre amarres;
    private ListaZonas zonas;
    private ListaSocios socios;
    private ListaEmpleados empleados;

    public Sistema() {
        usuarios = new BaseUsuarios();
        embarcaciones = new ListaEmbarcacion();
        amarres = new ListaAmarre();
        zonas = new ListaZonas();
        socios = new ListaSocios();
        empleados = new ListaEmpleados();
    }

    //Deserializar
    public Sistema deSerializar(String archivo) throws IOException, ClassNotFoundException {
        FileInputStream f = new FileInputStream(archivo);
        ObjectInputStream o = new ObjectInputStream(f);
        Sistema s = (Sistema) o.readObject();
        return s;
    }
    
    //Serializar
    public void serializar(String archivo) throws IOException {
        FileOutputStream f = new FileOutputStream(archivo);
        ObjectOutputStream o = new ObjectOutputStream(f);
        o.writeObject(this);
        o.close();
    }

     //Primer Arranque
    public void inicializacion() {
        EntradaSalida.mostrarString(
                "PRIMER ARRANQUE\n\n"
                + "Generando usuarios.."
        );
        Administrador a = new Administrador("admin", "admin", "Admin Alfa", "Informacion Clasificada", 43214321);
        a.setUsuarios(usuarios);
        a.setListaEmbarcaciones(embarcaciones);
        a.setListaAmarres(amarres);
        a.setListaZonas(zonas);
        a.setListaSocios(socios);
        a.setListaEmpleados(empleados);
        Empleado e = new Empleado("empleado", "empleado", "NombreEmpleado1", "DireccionEmpleado1", 12341234, 1, "Limpieza");
        Socio s = new Socio("socio", "socio", "NombreSocio1", "DireccionSocio1", 12344321, 38123123, 2020, 10, 25);

        usuarios.agregarUsuario(a);
        usuarios.agregarUsuario(e);
        usuarios.agregarUsuario(s);
        empleados.agregarEmpleado(e);
        socios.agregarSocio(s);

        EntradaSalida.mostrarString(
                "USUARIOS CARGADOS\n\n"
                + "Ya puede ingresar al sistema."
        );
    }
    
    //Arranque
    public void arrancar() {
        boolean corriendo = true;

        while (corriendo) {
            Persona u = null;

            String usuario = EntradaSalida.leerString("Ingrese su usuario");
            String password = EntradaSalida.leerPassword("Ingrese password");

            u = usuarios.buscarUsuario(usuario, password);

            if (u == null) {
                EntradaSalida.mostrarString("Usuario/contraseña inexistente");
            } else {
                corriendo = u.proceder();
            }
        }
        EntradaSalida.mostrarString("Hasta mañana");
    }
}
