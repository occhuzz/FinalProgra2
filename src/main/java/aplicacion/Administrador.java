package aplicacion;

public class Administrador extends Persona {

    private BaseUsuarios usuarios;
    private ListaEmbarcacion embarcaciones;
    private ListaAmarre amarres;
    private ListaZonas zonas;
    private ListaSocios socios;
    private ListaEmpleados empleados;

    public Administrador(String usuario, String password, String nombre, String direccion, int telefono) {
        super(usuario, password, nombre, direccion, telefono);
    }

    @Override
    public boolean proceder() {
        boolean cerrar = false, continuar = true;
        while (!cerrar) {
            char op;
            do {
                op = EntradaSalida.leerChar(
                        "MENÚ ENCARGADO\n\n"
                        + "[1] Altas\n"
                        + "[2] Asignaciones\n"
                        + "[3] Mostrar datos\n"
                        + "[4] Cerrar sesión\n"
                        + "[5] Salir\n");
            } while (op < '1' || op > '5');

            switch (op) {
                case '1':
                    this.menuAlta();
                    break;
                case '2':
                    this.menuAsignacion();
                    break;
                case '3':
                    this.mostrarDatos();
                    break;
                case '4':
                    EntradaSalida.mostrarString("Saliendo..");
                    cerrar = true;
                    continuar = true;
                    break;
                case '5':
                    EntradaSalida.mostrarString("Adios");
                    cerrar = true;
                    continuar = false;
                    break;
            }
        }
        return continuar;
    }

    //--------------------------------------------------------------------------
    //ALTA
    private void menuAlta() {
        char op;
        do {
            op = EntradaSalida.leerChar(
                    "MENÚ ALTA ENCARGADO\n\n"
                    + "[1] Alta - Socio\n"
                    + "[2] Alta - Empleado\n"
                    + "[3] Alta - Embarcación\n"
                    + "[4] Alta - Amarre\n"
                    + "[5] Alta - Zona\n"
                    + "[6] Atras\n");
        } while (op < '1' || op > '6');

        switch (op) {
            case '1':
                this.altaSocio();
                break;
            case '2':
                this.altaEmpleado();
                break;
            case '3':
                this.altaEmbarcacion();
                break;
            case '4':
                this.altaAmarre();
                break;
            case '5':
                this.altaZona();
                break;
            case '6':
                break;
        }
    }

    private void altaSocio() {
        String usuario, password, nombre, direccion;
        int telefono, dni, dia, mes, anio;

        usuario = EntradaSalida.leerString("Ingrese usuario del Socio");
        password = EntradaSalida.leerString("Ingrese password del Socio");
        nombre = EntradaSalida.leerString("Ingrese nombre");
        direccion = EntradaSalida.leerString("Ingrese direccion");
        telefono = EntradaSalida.leerInt("Ingrese telefono");
        dni = EntradaSalida.leerInt("Ingrese DNI");
        dia = EntradaSalida.leerInt("Ingrese Dia de ingreso");
        mes = EntradaSalida.leerInt("Ingrese Mes de ingreso");
        anio = EntradaSalida.leerInt("Ingrese Año de ingreso");

        Socio s = new Socio(usuario, password, nombre, direccion, telefono, dni, dia, mes - 1, anio - 1900);
        usuarios.agregarUsuario(s);
        EntradaSalida.mostrarString("Socio cargado correctamente");
    }

    private void altaEmpleado() {
        String usuario, password, nombre, direccion, especialidad;
        int telefono, codigo;
        usuario = EntradaSalida.leerString("Ingrese usuario del Empleado");
        password = EntradaSalida.leerString("Ingrese password del Empleado");
        nombre = EntradaSalida.leerString("Ingrese nombre");
        direccion = EntradaSalida.leerString("Ingrese direccion");
        telefono = EntradaSalida.leerInt("Ingrese telefono");
        codigo = EntradaSalida.leerInt("Ingrese codigo");
        especialidad = EntradaSalida.leerString("Ingrese especialidad");

        Empleado e = new Empleado(usuario, password, nombre, direccion, telefono, codigo, especialidad);
        usuarios.agregarUsuario(e);

        EntradaSalida.mostrarString("Empleado cargado correctamente");
    }

    private void altaEmbarcacion() {
        String nombre, tipo, dimensiones;
        int matricula;

        nombre = EntradaSalida.leerString("Ingrese nombre de la Embarcacion");
        tipo = EntradaSalida.leerString("Ingrese tipo de embarcacion");
        dimensiones = EntradaSalida.leerString("Ingrese dimensiones");
        matricula = EntradaSalida.leerInt("Ingrese matricula");

        Embarcacion e = new Embarcacion(nombre, tipo, dimensiones, matricula);
        embarcaciones.agregar(e);
        EntradaSalida.mostrarString("Embarcacion cargada correctamente");
    }

    private void altaAmarre() {
        int numeroAmarre, contadorAgua, contadorLuz;
        boolean mantenimiento;

        numeroAmarre = EntradaSalida.leerInt("Ingrese numero de amarre");
        contadorAgua = EntradaSalida.leerInt("Ingrese valor del contador de Agua");
        contadorLuz = EntradaSalida.leerInt("Ingrese valor del contador de Luz");
        mantenimiento = EntradaSalida.leerBoolean("Posee servicio de mantenimiento contratado? Si - No");

        Amarre a = new Amarre(numeroAmarre, contadorAgua, contadorLuz, mantenimiento);
        amarres.agregar(a);
        EntradaSalida.mostrarString("Amarre cargado correctamente");
    }

    private void altaZona() {
        char letra;
        String tipo;
        int profundidad, ancho;
        
        letra = EntradaSalida.leerChar("Ingrese letra de la Zona");
        tipo = EntradaSalida.leerString("Ingrese tipo de embarcaciones");
        profundidad = EntradaSalida.leerInt("Ingrese profundidad de los Amarres");
        ancho = EntradaSalida.leerInt("Ingrese ancho de los Amarres");
        Zona z = new Zona(letra, tipo, profundidad, ancho);
        
        zonas.agregar(z);
        EntradaSalida.mostrarString("Zona cargada correctamente");
    }

    //FIN ALTA
    //--------------------------------------------------------------------------
    //ASIGNACION
    private void menuAsignacion() {
        char op;
        do {
            op = EntradaSalida.leerChar(
                    "MENÚ ASIGNAR ENCARGADO\n\n"
                    + "[1] Asignar - Socio a Amarre\n"
                    + "[2] Asignar - Socio a Embarcación\n"
                    + "[3] Asignar - Amarre a Embarcación\n"
                    + "[4] Asignar - Amarre a Zona\n"
                    + "[5] Asignar - Embarcación a Zona\n"
                    + "[6] Asignar - Empleado a Zona\n"
                    + "[7] Atras\n");
        } while (op < '1' || op > '7');

        switch (op) {
            case '1':
                this.asignarSocioAmarre();
                break;
            case '2':
                this.asignarSocioEmbarcacion();
                break;
            case '3':
                this.asignarAmarreEmbarcacion();
                break;
            case '4':
                this.asignarAmarreZona();
                break;
            case '5':
                this.asignarEmbarcacionZona();
                break;
            case '6':
                this.asignarEmpleadoZona();
                break;
            case '7':
                break;
        }
    }

    private void asignarSocioAmarre() {
        Socio s = socios.elegirSocio();
        Amarre a = amarres.elegirAmarre();

        if (s != null && a != null) {
            if (a.asignarSocio(s) == false) {
                EntradaSalida.mostrarString("Error al asignar");
            } else {
                s.asignarAmarre(a);
                EntradaSalida.mostrarString("Socio asignado a Amarre correctamente");
            }
        }
    }
    
    private void asignarSocioEmbarcacion() {
        Socio s = socios.elegirSocio();
        Embarcacion e = embarcaciones.elegirEmbarcacion();

        if (s != null && e != null) {
            if (e.asignarSocio(s) == false) {
                EntradaSalida.mostrarString("Error al asignar");
            } else {
                s.asignarEmbarcacion(e);
                EntradaSalida.mostrarString("Socio asignado a Amarre correctamente");
            }
        }
    }

    private void asignarAmarreEmbarcacion() {
        Amarre a = amarres.elegirAmarre();
        Embarcacion e = embarcaciones.elegirEmbarcacion();

        if (a != null && e != null) {
            if (e.asignarAmarre(a) == false || a.asignarEmbarcacion(e) == false) {
                EntradaSalida.mostrarString("Error al asignar");
            } else {
                EntradaSalida.mostrarString("Amarre asignado a Embarcación correctamente");
            }
        }
    }
    
    private void asignarAmarreZona() {
        Amarre a = amarres.elegirAmarre();
        Zona z = zonas.elegirZona();

        if (a != null && z != null) {
            if (a.asignarZona(z) == false) {
                EntradaSalida.mostrarString("Error al asignar");
            } else {
                z.asignarAmarre(a);
                EntradaSalida.mostrarString("Amarre asignado a Zona correctamente");
            }
        }
    }
    
    private void asignarEmbarcacionZona() {
        Embarcacion e = embarcaciones.elegirEmbarcacion();
        Zona z = zonas.elegirZona();

        if (e != null && z != null) {
            if (e.asignarZona(z) == false) {
                EntradaSalida.mostrarString("Error al asignar");
            } else {
                z.asignarEmbarcacion(e);
                EntradaSalida.mostrarString("Embarcacion asignada a Zona correctamente");
            }
        }
    }
    
    private void asignarEmpleadoZona() {
        Empleado emp = empleados.elegirEmpleado();
        Zona z = zonas.elegirZona();
        Embarcacion e = null;
        if(z != null){
            e = z.getEmbarcacionZona();
        }

        if (emp != null && z != null) {
            emp.asignarZona(z);
            emp.asignarEmbarcacion(e);
            z.asignarEmpleado(emp);
            EntradaSalida.mostrarString("Empleado asignado a Zona correctamente");
        }
    }
    //FIN ASIGNACION
    //--------------------------------------------------------------------------
    //MOSTRAR DATOS   
    private void mostrarDatos() {
        char op;
        do {
            op = EntradaSalida.leerChar(
                    "MENÚ DATOS ENCARGADO\n\n"
                    + "[1] Datos - Administrador\n"
                    + "[2] Datos - Socio\n"
                    + "[3] Datos - Empleado\n"
                    + "[4] Datos - Embarcación\n"
                    + "[5] Datos - Amarre\n"
                    + "[6] Datos - Zona\n"
                    + "[7] Atras\n");
        } while (op < '1' || op > '7');

        switch (op) {
            case '1':
                this.datosAdmin();
                break;
            case '2':
                this.datosSocio();
                break;
            case '3':
                this.datosEmpleado();
                break;
            case '4':
                this.datosEmbarcacion();
                break;
            case '5':
                this.datosAmarre();
                break;
            case '6':
                this.datosZona();
                break;
            case '7':
                break;
        }
    }
    
    private void datosAdmin(){
        EntradaSalida.mostrarString("Nombre: " + nombre + "\nDireccion: " + direccion + "\nTelefono: " + telefono);
    }
    
    private void datosSocio(){
        Socio s = socios.elegirSocio();
        if(s != null)
        {
            s.mostrarDatos();
        }
    }
    
    private void datosEmpleado(){
        Empleado e = empleados.elegirEmpleado();
        if(e != null)
        {
            e.mostrarDatos();
        }
    }
    
    private void datosEmbarcacion(){
        Embarcacion e = embarcaciones.elegirEmbarcacion();
        if(e != null)
        {
            e.mostrarDatos();
        }
    }
    
    private void datosAmarre(){
        Amarre a = amarres.elegirAmarre();
        if(a != null)
        {
            a.mostrarDatos();
        }
    }
    
    private void datosZona(){
        Zona z = zonas.elegirZona();
        if(z != null)
        {
            z.mostrarDatos();
        }
    }
    //FIN MOSTRAR DATOS
    //--------------------------------------------------------------------------
    //GETTERS & SETTERS
    public void setUsuarios(BaseUsuarios usuarios) {
        this.usuarios = usuarios;
    }

    public void setListaEmbarcaciones(ListaEmbarcacion embarcaciones) {
        this.embarcaciones = embarcaciones;
    }

    public void setListaAmarres(ListaAmarre amarres) {
        this.amarres = amarres;
    }

    public void setListaZonas(ListaZonas zonas) {
        this.zonas = zonas;
    }

    public void setListaSocios(ListaSocios socios) {
        this.socios = socios;
    }

    public void setListaEmpleados(ListaEmpleados empleados) {
        this.empleados = empleados;
    }
    //FIN GETTERS & SETTERS
    //--------------------------------------------------------------------------
}
