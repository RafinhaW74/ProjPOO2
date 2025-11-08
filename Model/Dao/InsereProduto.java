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
public class InsereProduto {
    public static void insereProdutoBD(float Largura, float Comprimento, float Altura, String Descricao, String LI, String Fabricante, int quantidade){
        String sql = "INSERT INTO Produto(Largura, Comprimento, Altura, Descricao, LI, Fabricante, Quantidade) VALUES(?,?,?,?,?,?,?)";
        
        try{
            Conexao connection = new Conexao();
            PreparedStatement st = connection.get_prepare(sql);
            connection.set_param(new Object[]{Largura, Comprimento, Altura, Descricao, LI, Fabricante, quantidade});
            st.execute();
            connection.close();

        }catch(Exception erro){
            System.out.println(erro);
        }
        
    }
}
