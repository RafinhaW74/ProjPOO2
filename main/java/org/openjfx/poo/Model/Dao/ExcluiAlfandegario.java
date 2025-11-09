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
public class ExcluiAlfandegario {
    public static void ExcluiAlfandegarioBD(String CPF){
        String sql = "UPDATE Alfandegario SET Estado = FALSE WHERE CPF = ?";

        try{
            Conexao connection = new Conexao();
            PreparedStatement st = connection.get_prepare(sql);
            connection.set_param(new Object[]{CPF});
            st.execute();
            connection.close();
        }catch(Exception erro){
            System.out.println(erro);
        }
    }
}
