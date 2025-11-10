/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.openjfx.poo.Model.Dao;

/**
 *
 * @author rafin
 */
public class populaBDteste {
    public static void populaBD(){
        InsereAlfandegario.insereAlfandegarioBD("alfandegario 1", "987654", "123456", "senha1");
        InsereAlfandegario.insereAlfandegarioBD("alfandegario 2", "876543", "234567", "senha2");
        InsereAlfandegario.insereAlfandegarioBD("alfandegario 3", "765432", "345678", "senha3");
        InsereAlfandegario.insereAlfandegarioBD("alfandegario 4", "654321", "456789", "senha4");
        InsereAlfandegario.insereAlfandegarioBD("alfandegario 5", "543210", "567890", "senha5");
        
        InsereEmpresa.insereEmpresaBD("empresa 1", "senha6", "Bairro1", "Rua1", 0, "1234", "135", "098");
        InsereEmpresa.insereEmpresaBD("empresa 2", "senha7", "Bairro2", "Rua2", 0, "2345", "357", "987");
        InsereEmpresa.insereEmpresaBD("empresa 3", "senha8", "Bairro3", "Rua3", 0, "3456", "579", "876");
        InsereEmpresa.insereEmpresaBD("empresa 4", "senha9", "Bairro4", "Rua4", 0, "4567", "246", "765");
        InsereEmpresa.insereEmpresaBD("empresa 5", "senha10", "Bairro5", "Rua5", 0, "5678", "468", "654");
        
        InserePessoa_importadora.inserePessoa_importadoraBD("Pessoa 1", "senha11", "Bairro6", "Rua6", 0, "6789", "2000-09-02", "2343432" , "123789");
        InserePessoa_importadora.inserePessoa_importadoraBD("Pessoa 2", "senha12", "Bairro7", "Rua7", 0, "6789", "2000-09-02", "2883432" , "789123");
        InserePessoa_importadora.inserePessoa_importadoraBD("Pessoa 3", "senha13", "Bairro8", "Rua8", 0, "6789", "2000-09-02", "2343123" , "123456");
        InserePessoa_importadora.inserePessoa_importadoraBD("Pessoa 4", "senha14", "Bairro9", "Rua9", 0, "6789", "2000-09-02", "2398732" , "456123");
        InserePessoa_importadora.inserePessoa_importadoraBD("Pessoa 5", "senha15", "Bairro10", "Rua10", 0, "6789", "2000-09-02", "2342154" , "789456");
        
        InsereProduto.insereProdutoBD(1.2f, 3.3f, 0.4f, "Descricao 1", "456", "Fabricante 1", 5, 9, "Produto 1");
        InsereProduto.insereProdutoBD(6.1f, 2.1f, 9.4f, "Descricao 2", "656", "Fabricante 2", 3, 2, "Produto 2");
        InsereProduto.insereProdutoBD(8.2f, 1.7f, 20.0f, "Descricao 3", "766", "Fabricante 3", 1, 1, "Produto 3");
        InsereProduto.insereProdutoBD(7.0f, 5.0f, 4.8f, "Descricao 4", "986", "Fabricante 4", 2, 7, "Produto 4");
        InsereProduto.insereProdutoBD(4.9f, 66.2f, 5.6f, "Descricao 5", "412", "Fabricante 5", 7, 8, "Produto 5");
        
        InsereImportacao.insereImportacaoBD("2025-11-20", 1, "123789", null, "2025-11-20");
        InsereImportacao.insereImportacaoBD("2025-12-10", 2, "123789", null, "2025-11-22");
        InsereImportacao.insereImportacaoBD("2026-01-05", 3, null, "357", "2025-11-25");
        InsereImportacao.insereImportacaoBD("2026-04-23", 4, null, "246", "2025-11-26");
        InsereImportacao.insereImportacaoBD("2026-02-12", 5, "456123", null, "2025-11-29");
    }
}
