/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tentandoprojetopoo2.Model.Dao;

/**
 *
 * @author rafin
 */
public class CriaTodasTabelas {
    public static void CriaTodasTabelasBD(){
        CriaTabelaAlfandegario.criaTabelaAlfandegarioBD();
        CriaTabelaPessoa_importadora.criaTabelaPessoa_importadoraBD();
        CriaTabelaProduto.criaTabelaProdutoBD();
        CriaTabelaEmpresa.criaTabelaEmpresaBD();
        CriaTabelaImportacao.criaTabelaImportacaoBD();
    }
}
