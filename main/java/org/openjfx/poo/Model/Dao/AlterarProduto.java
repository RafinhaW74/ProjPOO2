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
public class AlterarProduto {
    public static void alteraProdutoBD(int Numero, float Largura, float Comprimento, float Altura, String Descricao, String LI, String Fabricante, int quantidade, float peso, String nome){
        String sql = "UPDATE Produto SET Largura = ?, Comprimento = ?, Altura = ?, Descricao = ?, LI = ?, Fabricante = ?, Quantidade = ?, Peso = ?, Nome = ? WHERE Numero = ?";
        
        try{
            Conexao connection = new Conexao();
            PreparedStatement st = connection.get_prepare(sql);
            connection.set_param(new Object[]{Largura, Comprimento, Altura, Descricao, LI, Fabricante, quantidade, Numero, peso, nome});
            st.execute();
            connection.close();

        }catch(Exception erro){
            System.out.println(erro);
        }
        
    }
}
