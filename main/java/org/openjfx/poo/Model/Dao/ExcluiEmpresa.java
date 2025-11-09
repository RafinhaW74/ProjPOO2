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
public class ExcluiEmpresa {
    public static void ExcluiEmpresaBD(String CNPJ){
        String sql = "UPDATE Empresa SET Estado = FALSE WHERE CNPJ = ?";

        
        try{
            Conexao connection = new Conexao();
            PreparedStatement st = connection.get_prepare(sql);
            connection.set_param(new Object[]{CNPJ});
            st.execute();
            connection.close();
        }catch(Exception erro){
            System.out.println(erro);
        }
    }
}
