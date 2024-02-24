package aplicacion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BaseUsuarios implements Serializable{

    private List<Persona> usuarios;

    public BaseUsuarios() {
        usuarios = new ArrayList<>();
    }

    public void agregarUsuario(Persona p) {
        if (p != null) {
        usuarios.add(p);
        }
    }

    public Persona buscarUsuario(String usr, String pwd)
    {
        Persona usuario = null;

        for (Persona p : usuarios)
        {
            if (p.coincidenUsrPwd(usr,pwd))
            {
                usuario = p;
                break;
            }
        }
        return usuario;
    }

    public Persona elegirUsuario()
    {
        int opcion;
        int contador = 1;
        String posiblesUsuarios = "";
        
        for(Persona p : usuarios)
        {
            posiblesUsuarios += "" + contador++ + "- " + p + "\n";
        }
        
        do
        {
            opcion = EntradaSalida.leerInt(posiblesUsuarios);
        } while (opcion < 1 || opcion > usuarios.size());
        
        return usuarios.get(opcion-1);
    }
}