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
public class InsereAlfandegario {
    public static void insereAlfandegarioBD(String Nome, String CPF, String SIAPE, String Senha){
        String sql = "INSERT INTO Alfandegario(Nome,CPF, SIAPE, Senha) VALUES(?,?,?,?)";
        
        try{
            Conexao connection = new Conexao();
            PreparedStatement st = connection.get_prepare(sql);
            connection.set_param(new Object[]{Nome, CPF, SIAPE, Senha});
            st.execute();
            connection.close();

        }catch(Exception erro){
            System.out.println(erro);
        }
        
    }
}
