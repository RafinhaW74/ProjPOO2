/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.openjfx.poo.Model.Dao;

import java.sql.PreparedStatement;
import org.openjfx.poo.Model.Produtos;

/**
 *
 * @author rafin
 */
public class AlterarProduto {
    public static void alteraProdutoBD(Produtos prod){
        String sql = "UPDATE Produto SET Largura = ?, Comprimento = ?, Altura = ?, Descricao = ?, LI = ?, Fabricante = ?, Quantidade = ?, Peso = ?, Nome = ? WHERE Numero = ?";
        
        try{
            Conexao connection = new Conexao();
            PreparedStatement st = connection.get_prepare(sql);
            connection.set_param(new Object[]{prod.getLargura(), prod.getComprimento(), prod.getAltura(), prod.getDescricao(), prod.getLI(), prod.getFabricante(), prod.getQuantidade(), prod.getPeso(),prod.getNome(),prod.getNumero()});
            st.execute();
            connection.close();

        }catch(Exception erro){
            System.out.println(erro);
        }
        
    }
}
