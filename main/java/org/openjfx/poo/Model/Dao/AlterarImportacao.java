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
public class AlterarImportacao {
    public static void alteraImportacaoBD(int Numero, String Previsao, int NumeroProduto, String CPF_Importador, String CNPJ_Importador){
        String sql = "UPDATE Importacao SET Previsao = ?, NumeroProduto = ?, CPF_Importador = ?, CNPJ_Importador = ? WHERE Numero = ?";
        
        try{
            Conexao connection = new Conexao();
            PreparedStatement st = connection.get_prepare(sql);
            connection.set_param(new Object[]{Previsao, NumeroProduto, CPF_Importador, CNPJ_Importador, Numero});
            st.execute();
            connection.close();

        }catch(Exception erro){
            System.out.println(erro);
        }
        
    }
}
