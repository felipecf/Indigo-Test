package Pruebas;

import com.DAOS.UsuarioDAOimp;
import com.indigo.POJOS.Usuario;
import com.conexion.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @author Felipe
 */

public class Pruebas {
    
    public static void main(String[] args) {
        
        UsuarioDAOimp auth = new UsuarioDAOimp();
        
        Usuario user = new Usuario("Felipe","", "Cruz", "Fabian", "felipe", "1109", "felipe@gmail.com");
        
        //System.out.println(auth.autenticacion("anaid", "anne"));
        
        boolean existe = auth.usuarioRegistrado("Felipe", "Cruz", "Fabian");
        
        System.out.println("usuario exite? " + existe);
    
    }
   
}
