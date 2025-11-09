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
public class AlterarPessoa_importadora {
    public static void alteraPessoa_importadoraBD(String CPF_busca, String Nome, String Senha, String Bairro, String Rua, int Numero, String CEP, String Data_Nascimento, String RG, String CPF){
        String sql = "UPDATE Pessoa_importadora SET Nome = ?, Senha = ?, Bairro = ?, Rua = ?, Numero = ?, CEP = ?, Data_Nascimento = ?, RG = ?, CPF = ? WHERE CPF = ?";
        
        try{
            Conexao connection = new Conexao();
            PreparedStatement st = connection.get_prepare(sql);
            connection.set_param(new Object[]{Nome, Senha, Bairro, Rua, Numero, CEP, Data_Nascimento, RG, CPF, CPF_busca});
            st.execute();
            connection.close();

        }catch(Exception erro){
            System.out.println(erro);
        }
        
    }
}
