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
public class InsereImportacao {
    public static void insereImportacaoBD(int NumeroProduto, String CPF_Importador, String CNPJ_Importador){
        String sql = "INSERT INTO Importacao ( NumeroProduto, CPF_Importador, CNPJ_Importador) "
           + "VALUES (?, ?, ?)";
        
        try{
            Conexao connection = new Conexao();
            PreparedStatement st = connection.get_prepare(sql);
            connection.set_param(new Object[]{ NumeroProduto, CPF_Importador, CNPJ_Importador});
            st.execute();
            connection.close();

        }catch(Exception erro){
            System.out.println(erro);
        }
        
    }
}
