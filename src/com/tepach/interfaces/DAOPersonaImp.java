package com.tepach.interfaces;

import com.tepach.bean.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.sql.DataSource;
import javax.swing.JOptionPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DAOPersonaImp implements DAOPersona {

    @Autowired
    private DataSource dataSource;
    private Connection con = null;
    private String sql;
    private PreparedStatement ps;

    @Override
    public void registrar(Persona persona) throws Exception {
        sql = "Insert into persona values(?,?,?,?,?)";
        try {
            con = dataSource.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, persona.getId());
            ps.setString(2, persona.getNombre());
            ps.setString(3, persona.getApodo());
            ps.setString(4, persona.getPais().getNombre());
            ps.setString(5, persona.getPais().getCiudad().getNombre());
            int a=ps.executeUpdate();
            if (a==0) {
                JOptionPane.showMessageDialog(null, "No se ingreso ningún Registro","Error",JOptionPane.INFORMATION_MESSAGE);
            }
            ps.close();
        } catch (Exception e) {
            throw e;
        } finally {
             if (con != null) {
                con.close();
            }
        }

    }

    @Override
    public void actualizar(Persona persona) throws Exception {
        sql = "UPDATE persona SET nombre = ?, alias = ?, pais = ?, cuidad = ? WHERE id=?";
        try {
            con = dataSource.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1, persona.getNombre());
            ps.setString(2, persona.getApodo());
            ps.setString(3, persona.getPais().getNombre());
            ps.setString(4, persona.getPais().getCiudad().getNombre());
            ps.setInt(5, persona.getId());
            int a=ps.executeUpdate();
            if (a==0) {
                JOptionPane.showMessageDialog(null, "No se actualizo ningún Registro","Error",JOptionPane.INFORMATION_MESSAGE);
            }
            ps.close();
        } catch (Exception e) {
            throw e;
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    @Override
    public void eliminar(Persona persona) throws Exception {
        sql="DELETE FROM persona WHERE id=?";
        try{
        con=dataSource.getConnection();
        ps=con.prepareStatement(sql);
        ps.setInt(1, persona.getId());
        int a=ps.executeUpdate();
            if (a==0) {
                JOptionPane.showMessageDialog(null, "No se elimino ningún Registro","Error",JOptionPane.INFORMATION_MESSAGE);
            }
        ps.close();
        }catch(Exception e){
        throw e;
        }finally{
            if (con != null) {
                con.close();
            }
        }
    }

}
