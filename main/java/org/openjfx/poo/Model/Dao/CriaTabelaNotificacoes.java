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
public class CriaTabelaNotificacoes {
    public static void criaTabelaNotificacoesBD(){
        String sql = "CREATE TABLE IF NOT EXISTS Item ("
        + "id INT AUTO_INCREMENT PRIMARY KEY, "
        + "tipo VARCHAR(50) NOT NULL, "
        + "descricao TEXT, "
        + "numeroRelacionado INT NOT NULL, "
        + "FOREIGN KEY (numeroRelacionado) REFERENCES Importacao(Numero)"
        + ")";
        
        try{
            Conexao connection = new Conexao();
            PreparedStatement st = connection.get_prepare(sql);
            st.execute();
            connection.close();
        }catch(Exception erro){
            System.out.println(erro);
        }
    }
}
