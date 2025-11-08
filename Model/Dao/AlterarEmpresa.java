/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tentandoprojetopoo2.Model.Dao;

import java.sql.PreparedStatement;

/**
 *
 * @author rafin
 */
public class AlterarEmpresa {
    public static void alteraEmpresaBD(String CNPJ_busca, String Nome, String Senha, String Bairro, String Rua, String Numero, String CEP, String Razao_Social, String CNPJ, String Habilitacao){
        String sql = "UPDATE Empresa SET Nome = ?,Senha = ?, Bairro = ?, Rua = ?, Numero = ?, CEP = ?, Razao_Social = ?, CNPJ = ?, Habilitacao = ? WHERE CNPJ = ?";
        
        try{
            Conexao connection = new Conexao();
            PreparedStatement st = connection.get_prepare(sql);
            connection.set_param(new Object[]{Nome, Senha, Bairro, Rua, Numero, CEP, Razao_Social, CNPJ, Habilitacao, CNPJ_busca});
            st.execute();
            connection.close();

        }catch(Exception erro){
            System.out.println(erro);
        }
        
    }
}
