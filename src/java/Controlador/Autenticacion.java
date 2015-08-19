/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import com.DAOS.UsuarioDAOimp;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Felipe
 */
public class Autenticacion extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String user, pass;
        
        UsuarioDAOimp auth = new UsuarioDAOimp();
        
        PrintWriter out = response.getWriter();
        
        user = request.getParameter("username");
        pass = request.getParameter("password");
        
        boolean existe = auth.autenticacion(user, pass);

        if(existe == true){

            out.println("<h1>Bienvenido " + user + "</h1>");
        }else{
            out.println("<h1>Usuario No registrado</h1>");
            out.println("<a href="+"index.html"+">"+"Inicio"+"</a>");
            out.println("<a href="+"views/Registro.html"+">"+"Registro"+"</a>");
        }
        
        
        
        
    }

}
