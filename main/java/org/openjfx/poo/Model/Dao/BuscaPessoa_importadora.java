/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.openjfx.poo.Model.Dao;

import org.openjfx.poo.Model.Pessoa_importadora;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author rafin
 */
public class BuscaPessoa_importadora {
    public static Pessoa_importadora buscaPessoa_importadoraBD(String CPF) {
        Pessoa_importadora a = null;
        String sql = "SELECT * FROM Pessoa_importadora WHERE CPF = ?";

        try {
            Conexao connection = new Conexao();
            PreparedStatement st = connection.get_prepare(sql);
            st.setString(1, CPF );
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                a = new Pessoa_importadora();
                a.setCPF(rs.getString("CPF"));
                a.setRG(rs.getString("RG"));
                a.setNome(rs.getString("Nome"));
                a.setSenha(rs.getString("Senha"));
                a.setEstado(rs.getBoolean("Estado"));
                a.setNumero(rs.getInt("Numero"));
                a.setBairro(rs.getString("Bairro"));
                a.setCep(rs.getString("CEP"));
                a.setRua(rs.getString("Rua"));
                a.setData_nascimento(rs.getDate("Data_Nascimento"));
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
