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
public class InsereEmpresa {
    public static void insereEmpresaBD(String Nome, String Senha, String Bairro, String Rua, int Numero, String CEP, String CNPJ, String Habilitacao){
        String sql = "INSERT INTO Empresa(Nome, Senha, Bairro, Rua, Numero, CEP, CNPJ, Habilitacao) VALUES(?,?,?,?,?,?,?,?)";
        
        try{
            Conexao connection = new Conexao();
            PreparedStatement st = connection.get_prepare(sql);
            connection.set_param(new Object[]{Nome, Senha, Bairro, Rua, Numero, CEP, CNPJ, Habilitacao});
            st.execute();
            connection.close();

        }catch(Exception erro){
            System.out.println(erro);
        }
        
    }
}
