/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.openjfx.poo.Model.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.openjfx.poo.Model.Notificacoes;

/**
 *
 * @author rafin
 */
public class BuscaNotificacao {
    public static Notificacoes BuscaNotificacoesBD(int id){
        Notificacoes a = null; 
        String sql = "SELECT * FROM Notificacao WHERE id = ?";
        try {
            Conexao connection = new Conexao();
            PreparedStatement st = connection.get_prepare(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                a = new Notificacoes();
                a.setiD(rs.getInt("iD"));
                a.setTipo(rs.getString("tipo"));
                a.setEstado(rs.getBoolean("Estado"));
                a.setResolvido(rs.getBoolean("Resolvido"));
                a.setDescricao(rs.getString("descricao"));
                a.setCriacao(rs.getDate("Criacao"));
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
