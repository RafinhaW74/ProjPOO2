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
public class CriaTabelaProduto {
    
    public static void criaTabelaProdutoBD() {
    String sql = "CREATE TABLE IF NOT EXISTS Produto ("
           + "Numero INT AUTO_INCREMENT PRIMARY KEY, "
           + "Nome VARCHAR(50), "
           + "Peso DECIMAL(10,2) NOT NULL, "
           + "Largura DECIMAL(10,2) NOT NULL, "
           + "Comprimento DECIMAL(10,2) NOT NULL, "
           + "Altura DECIMAL(10,2) NOT NULL, "
           + "Descricao TEXT NOT NULL, "
           + "LI VARCHAR(50), "
           + "Fabricante VARCHAR(255) NOT NULL, "
           + "Quantidade INT, "
           + "Estado BOOLEAN DEFAULT TRUE"
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
