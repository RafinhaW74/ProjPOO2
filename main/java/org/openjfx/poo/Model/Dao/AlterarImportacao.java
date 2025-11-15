/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.openjfx.poo.Model.Dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import org.openjfx.poo.Model.Importacao;

/**
 *
 * @author rafin
 */
public class AlterarImportacao {
    public static void alteraImportacaoBD(Importacao importacao){
        
        String sql = "UPDATE Importacao SET NumeroProduto = ?, CPF_Importador = ?, CNPJ_Importador = ?, Atualizacao = CURRENT_TIMESTAMP, Situacao = ? WHERE Numero = ?";
       
        try{
            Conexao connection = new Conexao();
            PreparedStatement st = connection.get_prepare(sql);
            if(importacao.getImportador() != null){
                connection.set_param(new Object[]{importacao.getProdutos().getNumero() , importacao.getImportador().getCPF(), null, importacao.getSituacao() , importacao.getNumero()});
            }else{
                connection.set_param(new Object[]{importacao.getProdutos().getNumero() , null, importacao.getEmpresa().getCNPJ(), importacao.getSituacao(), importacao.getNumero()});
            }
            st.execute();
            connection.close();

        }catch(Exception erro){
            System.out.println(erro);
        }
        
    }
}
