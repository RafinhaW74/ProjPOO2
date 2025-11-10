/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.openjfx.poo.Model.Dao;
import java.sql.PreparedStatement;
/**
 *
 * @author rafin
 */
public class CriaTabelaAlfandegario {
    
    public static void criaTabelaAlfandegarioBD(){
        String sql = "CREATE TABLE IF NOT EXISTS Alfandegario ("
           + "Nome VARCHAR(255) NOT NULL, "
           + "CPF CHAR(11) NOT NULL UNIQUE, "
           + "SIAPE CHAR(7) NOT NULL UNIQUE, "
           + "Senha VARCHAR(50) NOT NULL, "
           + "Estado BOOLEAN DEFAULT TRUE, "
           + "PRIMARY KEY (CPF)"
           + ")";
        
        try{
            Conexao connection = new Conexao();
            PreparedStatement st = connection.get_prepare(sql);
            st.execute();
            connection.close();
        }catch(Exception erro){
            System.out.println(erro);
        }
    }
    

}
