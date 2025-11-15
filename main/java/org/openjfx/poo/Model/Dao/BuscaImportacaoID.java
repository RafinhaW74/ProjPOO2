/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.openjfx.poo.Model.Dao;

import org.openjfx.poo.Model.Importacao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

/**
 *
 * @author rafin
 */
public class BuscaImportacaoID {
    
    
    public static Importacao buscaImportacaoBD(int Numero) {
        Importacao a = null;
        
        String sql = "SELECT * FROM Importacao WHERE Numero = ?";

        try {
            Conexao connection = new Conexao();
            PreparedStatement st = connection.get_prepare(sql);
            st.setInt(1, Numero);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                a = new Importacao();
                a.setSituacao(rs.getString("Situacao"));
                a.setNumero(rs.getInt("Numero"));
                a.setEstado(rs.getBoolean("Estado"));
                a.setImportador(BuscaPessoa_importadora.buscaPessoa_importadoraBD(rs.getString("CPF_Importador")));
                a.setProdutos(BuscaProdutos.buscaProdutosBD(rs.getInt("NumeroProduto")));
                a.setEmpresa(BuscaEmpresa.buscaEmpresa_importadoraBD(rs.getString("CNPJ_Importador")));
                a.setAtualizacao(new Date(rs.getTimestamp("Atualizacao").getTime()));
                a.setNotificacoes(BuscaListaNotificacoes.BuscaListaNotificacoesBD(Numero));
                a.setCriacao(new Date(rs.getTimestamp("Criacao").getTime()));
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
