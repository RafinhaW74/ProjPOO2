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
public class CriaTabelaImportacao {
    public static void criaTabelaImportacaoBD() {
        String sql = "CREATE TABLE IF NOT EXISTS Importacao ("
        + "Numero INT AUTO_INCREMENT PRIMARY KEY, "
        + "Previsao DATE NOT NULL, "
        + "NumeroProduto INT NOT NULL, "
        + "Situacao VARCHAR(30) DEFAULT 'Em análise', "
        + "CPF_Importador CHAR(11) NULL, "
        + "CNPJ_Importador CHAR(14) NULL, "
        + "Estado BOOLEAN DEFAULT TRUE, "
        + "FOREIGN KEY (NumeroProduto) REFERENCES Produto(Numero), "
        + "FOREIGN KEY (CPF_Importador) REFERENCES Pessoa_importadora(CPF), "
        + "FOREIGN KEY (CNPJ_Importador) REFERENCES Empresa(CNPJ), "
        + "CHECK ( (CPF_Importador IS NULL) OR (CNPJ_Importador IS NULL) )"
        + ")";

        try {
            Conexao connection = new Conexao();
            PreparedStatement st = connection.get_prepare(sql);
            st.executeUpdate();
            st.close();
            connection.close();
        } catch (Exception erro) {
            System.out.println(erro);
        }
    }

}
