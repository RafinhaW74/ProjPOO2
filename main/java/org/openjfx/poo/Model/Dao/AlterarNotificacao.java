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
public class AlterarNotificacao {
    public static void alteraImportacaoBD(String descricao, int id, String tipo, int numeroImport, boolean resolvido){  //trocar para notifica����o
        String sql = "UPDATE Notificacao SET descricao = ?, tipo = ?, numeroImportacao = ?, Resolvido WHERE id = ?";
        
        try{
            Conexao connection = new Conexao();
            PreparedStatement st = connection.get_prepare(sql);
            connection.set_param(new Object[]{descricao, tipo, numeroImport, resolvido, id});
            st.execute();
            connection.close();

        }catch(Exception erro){
            System.out.println(erro);
        }
        
    }
}
