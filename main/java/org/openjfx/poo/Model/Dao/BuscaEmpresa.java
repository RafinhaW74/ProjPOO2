/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.openjfx.poo.Model.Dao;

import org.openjfx.poo.Model.Empresa_importadora;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author rafin
 */
public class BuscaEmpresa {
    public static Empresa_importadora buscaEmpresa_importadoraBD(String CNPJ) {
        Empresa_importadora a = new Empresa_importadora();
        String sql = "SELECT * FROM Empresa WHERE CNPJ = ?";

        try {
            Conexao connection = new Conexao();
            PreparedStatement st = connection.get_prepare(sql);
            st.setString(1, CNPJ );
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                a.setCNPJ(rs.getString("CNPJ"));
                a.setRazao_social(rs.getString("Razao_social"));
                a.setNome(rs.getString("Nome"));
                a.setSenha(rs.getString("Senha"));
                a.setEstado(rs.getBoolean("Estado"));
                a.setNumero(rs.getInt("Numero"));
                a.setBairro(rs.getString("Bairro"));
                a.setCep(rs.getString("CEP"));
                a.setRua(rs.getString("Rua"));
                a.setHabilitacao(rs.getString("Habilitacao"));
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
