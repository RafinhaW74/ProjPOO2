/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.openjfx.poo.Model.Dao;

import org.openjfx.poo.Model.Importacao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rafin
 */
public class ListaImportacaoPessoa {
    public static List<Importacao> listaImportacoesPessoaBD(String CPF) {
        List<Importacao> lista = new ArrayList<>();
        
        String sql = "SELECT * FROM Importacao WHERE CPF_Importador = ?";

        try {
            Conexao connection = new Conexao();
            PreparedStatement st = connection.get_prepare(sql);
            st.setString(1, CPF);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Importacao a = new Importacao();
                a.setSituacao(rs.getString("Situacao"));
                a.setNumero(rs.getInt("Numero"));
                a.setPrevisao(rs.getDate("Previsao"));
                a.setEstado(rs.getBoolean("Estado"));
                a.setImportador(BuscaPessoa_importadora.buscaPessoa_importadoraBD(rs.getString("CPF_Importador")));
                a.setProdutos(BuscaProdutos.buscaProdutosBD(rs.getInt("NumeroProduto")));
                a.setEmpresa(BuscaEmpresa.buscaEmpresa_importadoraBD(rs.getString("CNPJ_Importador")));
                a.setAtualizacao(rs.getDate("Atualizacao"));
                lista.add(a);
            }

            rs.close();
            st.close();
            connection.close();

        } catch (Exception erro) {
            System.out.println(erro);
        }

        return lista;
    }
}
