/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tentandoprojetopoo2.Model.Dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author rafin
 */
public class Conexao {

    private final String URL;
    private final String USER;
    private final String PASSWORD;
    private final String DATABASE;
    private final String PORT;
    private final String HOST;
    
    private Connection conn;
    private Statement st;
    private PreparedStatement pst;
    private ResultSet rs;
    
    
    public Conexao()throws ClassNotFoundException{        
        DATABASE = "ProjetoPOO2";
        USER = "root";
        PASSWORD = "#sP@d094$8oIf23";
        PORT = "3306";
        HOST= "localhost";
        URL = "jdbc:mysql://"+HOST+":"+PORT+"/"+DATABASE;
        
        conn = null;
        st = null;
        pst = null;
        rs = null;
    }
    
    public Connection get_conn()throws SQLException{
        if(conn == null) conn = DriverManager.getConnection(URL, USER, PASSWORD);
           return conn;
    }


    public Statement get_statment() throws SQLException{
        if(st == null){
            st = get_conn().createStatement();
        }
        return st;
    }
    
    public PreparedStatement get_prepare(String sql) throws SQLException{
        if(pst == null){
            pst =  get_conn().prepareStatement(sql);
        }
        return pst;
    }
    
    public void set_param(Object[] list) throws SQLException{
        for(int i = 1; i <= list.length; i++){
            pst.setObject(i, list[i-1]);
        }
    }
    
    public ResultSet get_result()throws SQLException{
        if (rs == null){
            rs = pst.executeQuery();
        }
        return rs;
    }
    
    public void close(){
        if(conn != null){
           
            if(st != null){
                try{
                    st.close();
                }catch (SQLException e){}
            }

            if(pst != null){
                if(rs != null){
                    try{
                        rs.close();
                    }catch (SQLException e){}
                }
                try{
                    pst.close();
                }catch (SQLException e){}
            }
            
            try{
                conn.close();
            }catch (SQLException e){}
         }
    }
}
