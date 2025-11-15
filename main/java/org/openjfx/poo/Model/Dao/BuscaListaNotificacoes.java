/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.openjfx.poo.Model.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import org.openjfx.poo.Model.Notificacoes;
import org.openjfx.poo.Model.Importacao;
import java.util.Date;

import java.util.List;

/**
 *
 * @author rafin
 */
public class BuscaListaNotificacoes {
    public static List<Notificacoes> BuscaListaNotificacoesBD(int numeroImport){
        Notificacoes a = null;
        List<Notificacoes> noti = new ArrayList<>();
        String sql = "SELECT * FROM Notificacao WHERE numeroImportacao = ?";
        try {
            Conexao connection = new Conexao();
            PreparedStatement st = connection.get_prepare(sql);
            st.setInt(1, numeroImport);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                a = new Notificacoes();
                a.setiD(rs.getInt("iD"));
                a.setTipo(rs.getString("tipo"));
                a.setEstado(rs.getBoolean("Estado"));
                a.setResolvido(rs.getBoolean("Resolvido"));
                a.setDescricao(rs.getString("descricao"));
                a.setCriacao(new Date(rs.getTimestamp("Criacao").getTime()));
                noti.add(a);
            }

            rs.close();
            st.close();
            connection.close();

        } catch (Exception erro) {
            System.out.println(erro);
        }
        
        return noti;
    }
}
