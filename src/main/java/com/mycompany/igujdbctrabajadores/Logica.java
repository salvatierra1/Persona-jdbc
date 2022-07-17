/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.igujdbctrabajadores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class Logica {
    
    public DefaultTableModel mostrarTrabajadores()
    {
        String []  nombresColumnas = {"DNI","NOMBRE","APELLIDOS","SUELDO","FECHA","MATRICULA"};
        String [] registros = new String[3];
        
        DefaultTableModel modelo = new DefaultTableModel(null,nombresColumnas);
        
        String sql = "SELECT * FROM persona";
        
        Connection cn = null;
        
        PreparedStatement pst = null;
        
        ResultSet rs = null;
        
        try
        {
            cn = Conexion.conectar();
            
            pst = cn.prepareStatement(sql);                        
            
            rs = pst.executeQuery();
            
            while(rs.next())
            {
                registros[0] = rs.getString("DNI");
                
                registros[1] = rs.getString("NOMBRE");
                
                registros[2] = rs.getString("APELLIDOS");
                
                registros[2] = rs.getString("SUELDO");
                
                registros[2] = rs.getString("FECHA");
                
                registros[2] = rs.getString("MATRICULA");
                
                modelo.addRow(registros);
                
            }
            
           
        }
        catch(SQLException e)
        {
            
            JOptionPane.showMessageDialog(null,"Error al conectar");
            
        }
        finally
        {
            try
            {
                if (rs != null) rs.close();
                
                if (pst != null) pst.close();
                
                if (cn != null) cn.close();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
        }
         return modelo;
    }
    
}
