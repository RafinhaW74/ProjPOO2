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
public class InsereNotificacao {
    public static void insereNotificacaoBD(String descricao, String tipo, int numeroImport){
        String sql = "INSERT INTO Notificacao(descricao, tipo, numeroImportacao) VALUES(?,?,?)";
        
        try{
            Conexao connection = new Conexao();
            PreparedStatement st = connection.get_prepare(sql);
            connection.set_param(new Object[]{descricao, tipo, numeroImport});
            st.execute();
            connection.close();

        }catch(Exception erro){
            System.out.println(erro);
        }
        
    }
}
