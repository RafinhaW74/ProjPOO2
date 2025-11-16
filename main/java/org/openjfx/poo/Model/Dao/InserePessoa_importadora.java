/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.openjfx.poo.Model.Dao;

import java.sql.PreparedStatement;
import java.util.Date;
import org.openjfx.poo.Model.Pessoa_importadora;


/**
 *
 * @author rafin
 */
public class InserePessoa_importadora {
    public static void inserePessoa_importadoraBD(Pessoa_importadora pessoa){
        String Nome = pessoa.getNome();
        String Senha = pessoa.getSenha();
        String Bairro = pessoa.getBairro();
        String Rua = pessoa.getRua();
        int Numero = pessoa.getNumero();
        String CEP = pessoa.getCep();
        Date Data_Nascimento = pessoa.getData_nascimento();
        String RG = pessoa.getRG();
        String CPF = pessoa.getCPF();
        
        String sql = "INSERT INTO Pessoa_importadora(Nome, Senha, Bairro, Rua, Numero, CEP, Data_Nascimento, RG, CPF) VALUES(?,?,?,?,?,?,?,?,?)";
        try{
            Conexao connection = new Conexao();
            PreparedStatement st = connection.get_prepare(sql);
            connection.set_param(new Object[]{Nome, Senha, Bairro, Rua, Numero, CEP, Data_Nascimento, RG, CPF});
            st.execute();
            connection.close();

        }catch(Exception erro){
            System.out.println(erro);
        }
        
    }
}
