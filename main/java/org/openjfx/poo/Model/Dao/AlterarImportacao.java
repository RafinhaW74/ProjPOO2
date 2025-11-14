/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.openjfx.poo.Model.Dao;

import java.sql.Date;
import java.sql.PreparedStatement;

/**
 *
 * @author rafin
 */
public class AlterarImportacao {
    public static void alteraImportacaoBD(int Numero, int NumeroProduto, String CPF_Importador, String CNPJ_Importador, String atualizacao){
        String sql = "UPDATE Importacao SET NumeroProduto = ?, CPF_Importador = ?, CNPJ_Importador = ?, Atualizacao = ? WHERE Numero = ?";
        
        try{
            Conexao connection = new Conexao();
            PreparedStatement st = connection.get_prepare(sql);
            connection.set_param(new Object[]{NumeroProduto, CPF_Importador, CNPJ_Importador, Date.valueOf(atualizacao), Numero});
            st.execute();
            connection.close();

        }catch(Exception erro){
            System.out.println(erro);
        }
        
    }
}
