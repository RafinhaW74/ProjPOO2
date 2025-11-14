/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.openjfx.poo.Model.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author rafin
 */
public class InsereProduto {
    public static int insereProdutoBD(float Largura, float Comprimento, float Altura, String Descricao, String LI, String Fabricante, int quantidade, float peso, String nome){
        String sql = "INSERT INTO Produto(Largura, Comprimento, Altura, Descricao, LI, Fabricante, Quantidade, Nome, Peso) VALUES(?,?,?,?,?,?,?,?,?)";
        int idGerado = -1;
        try{
            Conexao connection = new Conexao();
            PreparedStatement st = connection.get_prepare(sql);
            connection.set_param(new Object[]{Largura, Comprimento, Altura, Descricao, LI, Fabricante, quantidade, nome, peso});
            st.execute();
            
            ResultSet rs = st.getGeneratedKeys();
            if (rs.next()) {
                idGerado = rs.getInt(1);
            }
            connection.close();

        }catch(Exception erro){
            System.out.println(erro);
        }
        return idGerado;
    }
}
