package org.openjfx.poo.Model.Dao;

import org.openjfx.poo.Model.Alfandegario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class BuscaAlfandegario {

    public static Alfandegario buscaAlfandegarioBD(String CPF) {
        Alfandegario a = new Alfandegario();
        String sql = "SELECT * FROM Alfandegario WHERE CPF = ?";

        try {
            Conexao connection = new Conexao();
            PreparedStatement st = connection.get_prepare(sql);
            st.setString(1, CPF);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                a.setCPF(rs.getString("CPF"));
                a.setSIAPE(rs.getString("SIAPE"));
                a.setNome(rs.getString("Nome"));
                a.setSenha(rs.getString("Senha"));
                a.setEstado(rs.getBoolean("Estado"));
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
