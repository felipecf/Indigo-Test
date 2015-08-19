/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAOS;

import com.indigo.POJOS.Usuario;

/**
 *
 * @author Felipe
 */
public interface UsuarioDAO {
    
    void insertNewUser(Usuario user);
    boolean autenticacion(String usuario, String password);
    boolean usuarioRegistrado(String nombre,String apPat, String apMat);
    
    
}
