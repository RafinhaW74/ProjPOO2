/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.openjfx.poo.Model.Dao;

import java.sql.PreparedStatement;
import org.openjfx.poo.Model.Empresa_importadora;

/**
 *
 * @author rafin
 */
public class InsereEmpresa {
    public static void insereEmpresaBD(Empresa_importadora empresa){
        String Nome = empresa.getNome();
        String Senha = empresa.getSenha();
        String Bairro = empresa.getBairro();
        String Rua = empresa.getRua();
        int Numero = empresa.getNumero();
        String CEP = empresa.getCep();
        String CNPJ = empresa.getCNPJ();
        String Habilitacao = empresa.getHabilitacao();
        String sql = "INSERT INTO Empresa(Nome, Senha, Bairro, Rua, Numero, CEP, CNPJ, Habilitacao) VALUES(?,?,?,?,?,?,?,?)";
        
        try{
            Conexao connection = new Conexao();
            PreparedStatement st = connection.get_prepare(sql);
            connection.set_param(new Object[]{Nome, Senha, Bairro, Rua, Numero, CEP, CNPJ, Habilitacao});
            st.execute();
            connection.close();

        }catch(Exception erro){
            System.out.println(erro);
        }
        
    }
}
