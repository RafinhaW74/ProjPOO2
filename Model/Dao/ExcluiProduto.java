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
public class ExcluiProduto {
    public static void ExcluiProdutoBD(int Numero){
        String sql = "UPDATE Produto SET Estado = FALSE WHERE Numero = ?";
        
        try{
            Conexao connection = new Conexao();
            PreparedStatement st = connection.get_prepare(sql);
            connection.set_param(new Object[]{Numero});
            st.execute();
            connection.close();
        }catch(Exception erro){
            System.out.println(erro);
        }
    }
}
