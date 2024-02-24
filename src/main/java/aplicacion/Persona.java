package aplicacion;

import java.io.Serializable;

public abstract class Persona implements Serializable {

    protected String nombre;
    protected String direccion;
    protected int telefono;
    protected String usuario;
    protected String password;
    
    public Persona(String usuario, String password, String nombre, String direccion, int telefono)
    {
        this.usuario = usuario;
        this.password = password;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }
    
    public boolean coincidenUsrPwd(String usr, String pwd)
    {
        return this.usuario.equalsIgnoreCase(usr) && this.password.equals(pwd);
    }
    
    public abstract boolean proceder();
}
