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
public class ExcluiPessoa_importadora {
    public static void ExcluiPessoa_importadoraBD(String CPF){
        String sql = "UPDATE Pessoa_importadora SET Estado = FALSE WHERE CPF = ?";

        try{
            Conexao connection = new Conexao();
            PreparedStatement st = connection.get_prepare(sql);
            connection.set_param(new Object[]{CPF});
            st.execute();
            connection.close();
        }catch(Exception erro){
            System.out.println(erro);
        }
    }
}
