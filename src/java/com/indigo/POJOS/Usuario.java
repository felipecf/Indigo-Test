package com.indigo.POJOS;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Felipe
 */

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuarios")
    private long id_Usuarios;
    private String nombre1;
    private String nombre2;
    private String apPat;
    private String apMat;
    private String username;
    private String password;
    private String mail;

    public Usuario(){}
    
    public Usuario(String nombre1, String nombre2, String apPat, String apMat, String username, String password, String mail) {
        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
        this.apPat = apPat;
        this.apMat = apMat;
        this.username = username;
        this.password = password;
        this.mail = mail;
    }

    public long getId_Usuarios() {
        return id_Usuarios;
    }

    public void setId_Usuarios(long id_Usuarios) {
        this.id_Usuarios = id_Usuarios;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getApPat() {
        return apPat;
    }

    public void setApPat(String apPat) {
        this.apPat = apPat;
    }

    public String getApMat() {
        return apMat;
    }

    public void setApMat(String apMat) {
        this.apMat = apMat;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id_Usuarios=" + id_Usuarios + ", nombre1=" + nombre1 + ", nombre2=" + nombre2 + ", apPat=" + apPat + ", apMat=" + apMat + ", username=" + username + ", password=" + password + ", mail=" + mail + '}';
    }
    
    
   
    
}
