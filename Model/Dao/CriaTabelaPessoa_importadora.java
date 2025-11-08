/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tentandoprojetopoo2.Model.Dao;
import java.sql.PreparedStatement;
/**
 *
 * @author rafin
 */
public class CriaTabelaPessoa_importadora {
    public static void criaTabelaPessoa_importadoraBD(){
        String sql = "CREATE TABLE IF NOT EXISTS Pessoa_importadora ("
           + "Nome VARCHAR(100) NOT NULL, "
           + "Senha VARCHAR(100) NOT NULL, "
           + "Bairro VARCHAR(100), "
           + "Rua VARCHAR(100), "
           + "Numero INT, "
           + "CEP CHAR(8), "
           + "Data_Nascimento DATE NOT NULL, "
           + "RG CHAR(9) NOT NULL UNIQUE, "
           + "CPF CHAR(11) NOT NULL UNIQUE, "
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
