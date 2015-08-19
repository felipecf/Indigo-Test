package com.DAOS;

import com.indigo.POJOS.Usuario;
import com.conexion.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @author Felipe
 */

public class UsuarioDAOimp implements UsuarioDAO{
    
    private Session sesion;    
    private Transaction tx;

    @Override
    public void insertNewUser(Usuario user) {
        
        try {
            iniciaOperacion(); 
            sesion.save(user);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        }finally{
            sesion.close();
        }
    }
    
    @Override
    public boolean autenticacion(String username , String password) {
        
        Query query;
        String hql = "FROM Usuario user WHERE user.username ='" + username + "' and user.password ='" + password + "'";
        Usuario user;

        System.out.println(hql);
        
        try {
            
            iniciaOperacion();
            query = sesion.createQuery(hql);            
            user = (Usuario)query.uniqueResult();
            
            if(query.list().size() > 0 ){        
                if(user.getUsername().equals(username) || user.getPassword().equals(password)){      
                        return true;
                }else{
                    return false;
                }
            }else{
                return false;
            }
            
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        }finally{
            sesion.close();
        }

    }
    
    @Override
    public boolean usuarioRegistrado(String nombre,String apPat, String apMat ) {
        
        Query query;
        Usuario user;
        String hql = "FROM Usuario u WHERE u.nombre1='"+nombre+"' and u.apPat='"+apPat+"' and u.apMat='"+apMat+"'";
        
        System.out.println(hql);
        
        try{
            iniciaOperacion();
            query = sesion.createQuery(hql);
            user =(Usuario)query.uniqueResult();
            
            System.out.println(query.list());
            
            if(query.list().size() > 0){
                if(user.getNombre1().equals(nombre) || user.getApPat().equals(apPat) || 
                        user.getApMat().equals(apMat)){

                    return true;
                }   
                else{
                    return false;
                }      
            
            }else{
                return false;
            }
        }catch(HibernateException he){
            manejaExcepcion(he);
            throw he;
        }
    }
    
        private void iniciaOperacion() throws HibernateException
    {
        sesion = HibernateUtil.getSessionFactory().openSession();
        tx = sesion.beginTransaction();
    }

    private void manejaExcepcion(HibernateException he) throws HibernateException
    {
        tx.rollback();
        throw new HibernateException("Ocurrió un error en la capa de acceso a datos", he);
    }

}
