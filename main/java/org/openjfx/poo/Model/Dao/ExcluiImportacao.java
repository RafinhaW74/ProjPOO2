/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.openjfx.poo.Model.Dao;

import java.sql.PreparedStatement;
import org.openjfx.poo.Model.Importacao;

/**
 *
 * @author rafin
 */
public class ExcluiImportacao {
    public static void ExcluiImportacaoBD(Importacao importacao){
        String sql = "UPDATE Importacao SET Estado = FALSE WHERE Numero = ?";

        try{
            Conexao connection = new Conexao();
            PreparedStatement st = connection.get_prepare(sql);
            connection.set_param(new Object[]{importacao.getNumero()});
            st.execute();
            connection.close();
        }catch(Exception erro){
            System.out.println(erro);
        }
    }
}
