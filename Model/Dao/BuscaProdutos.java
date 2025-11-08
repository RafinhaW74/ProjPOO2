/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tentandoprojetopoo2.Model.Dao;

import com.mycompany.tentandoprojetopoo2.Model.Produtos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author rafin
 */
public class BuscaProdutos {
    public static Produtos buscaProdutosBD(int Numero) {
        Produtos a = new Produtos();
        String sql = "SELECT * FROM Produto WHERE Numero = ?";

        try {
            Conexao connection = new Conexao();
            PreparedStatement st = connection.get_prepare(sql);
            st.setInt(1, Numero );
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                a.setEstado(rs.getBoolean("Estado"));
                a.setNumero(rs.getInt("Numero"));
                a.setLargura(rs.getFloat("Largura"));
                a.setComprimento(rs.getFloat("Comprimento"));
                a.setAltura(rs.getFloat("Altura"));
                a.setQuantidade(rs.getInt("Quantidade"));
                a.setLI(rs.getString("LI"));
                a.setDescricao(rs.getString("Descricao"));
                a.setFabricante(rs.getString("Fabricante"));
            }

            rs.close();
            st.close();
            connection.close();

        } catch (Exception erro) {
            System.out.println(erro);
        }

        return a;
    }
}
