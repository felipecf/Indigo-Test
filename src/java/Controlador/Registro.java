/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import com.DAOS.UsuarioDAOimp;
import com.indigo.POJOS.Usuario;
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
public class Registro extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Usuario newUser = new Usuario();
        PrintWriter out = response.getWriter();
        
        newUser.setNombre1(request.getParameter("nombre1"));
        newUser.setNombre2(request.getParameter("nombre2"));
        newUser.setApPat(request.getParameter("apPat"));
        newUser.setApMat(request.getParameter("apMat"));
        newUser.setUsername(request.getParameter("username"));
        newUser.setPassword(request.getParameter("password"));
        newUser.setMail(request.getParameter("mail"));
        
        UsuarioDAOimp registra = new UsuarioDAOimp();
        
        if(registra.usuarioRegistrado(newUser.getNombre1(),newUser.getApPat(),newUser.getApMat())){
            out.println("<h1>Ya estas registrado!!!</h1>");
            out.println("<a href="+"index.html"+">"+"Regresar a inicio"+"</a>");
        }else{
            registra.insertNewUser(newUser);
            out.println("<h1>Usuario Registrado</h1>");
            out.println("<a href="+"index.html"+">"+"Regresar a inicio"+"</a>");
            
        }  
    }
}
