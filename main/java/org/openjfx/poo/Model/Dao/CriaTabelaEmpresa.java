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
public class CriaTabelaEmpresa {
    public static void criaTabelaEmpresaBD(){
        String sql = "CREATE TABLE IF NOT EXISTS Empresa ("
           + "Nome VARCHAR(100) NOT NULL, "
           + "Senha VARCHAR(100) NOT NULL, "
           + "Bairro VARCHAR(100), "
           + "Rua VARCHAR(100), "
           + "Numero INT, "
           + "CEP CHAR(8), "
           + "Razao_Social VARCHAR(150) NOT NULL, "
           + "CNPJ CHAR(14) NOT NULL UNIQUE, "
           + "Habilitacao VARCHAR(50), "
           + "Estado BOOLEAN DEFAULT TRUE, "
           + "PRIMARY KEY (CNPJ)"
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
