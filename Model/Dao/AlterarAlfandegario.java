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
public class AlterarAlfandegario {
    public static void alteraAlfandegarioBD(String CPF_busca, String Nome, String CPF, String SIAPE, String Senha){
        String sql = "UPDATE Alfandegario SET Nome = ?,CPF = ?, SIAPE = ?, Senha = ? WHERE CPF = ?";
        
        try{
            Conexao connection = new Conexao();
            PreparedStatement st = connection.get_prepare(sql);
            connection.set_param(new Object[]{Nome, CPF, SIAPE, Senha, CPF_busca});
            st.execute();
            connection.close();

        }catch(Exception erro){
            System.out.println(erro);
        }
        
    }
}
