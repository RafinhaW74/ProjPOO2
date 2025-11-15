/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.openjfx.poo.Model.Dao;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import java.util.Date;

/**
 *
 * @author rafin
 */
public class PopulaBDteste {
    public static void populaBD(){
        String senha = "Senha";
        Argon2 argon2 = Argon2Factory.create();
        String hash = argon2.hash(2, 65536, 2, senha);
        
        InsereAlfandegario.insereAlfandegarioBD("alfandegario 1", "987654", "123456", hash);
        InsereAlfandegario.insereAlfandegarioBD("alfandegario 2", "876543", "234567", hash);
        InsereAlfandegario.insereAlfandegarioBD("alfandegario 3", "765432", "345678", hash);
        InsereAlfandegario.insereAlfandegarioBD("alfandegario 4", "654321", "456789", hash);
        InsereAlfandegario.insereAlfandegarioBD("alfandegario 5", "543210", "567890", hash);
        
        InsereEmpresa.insereEmpresaBD("empresa 1", hash, "Bairro1", "Rua1", 0, "1234", "135", "098");
        InsereEmpresa.insereEmpresaBD("empresa 2", hash, "Bairro2", "Rua2", 0, "2345", "357", "987");
        InsereEmpresa.insereEmpresaBD("empresa 3", hash, "Bairro3", "Rua3", 0, "3456", "579", "876");
        InsereEmpresa.insereEmpresaBD("empresa 4", hash, "Bairro4", "Rua4", 0, "4567", "246", "765");
        InsereEmpresa.insereEmpresaBD("empresa 5", hash, "Bairro5", "Rua5", 0, "5678", "468", "654");
        
        InserePessoa_importadora.inserePessoa_importadoraBD("Pessoa 1", hash, "Bairro6", "Rua6", 0, "6789", new Date(), "2343432" , "123789");
        InserePessoa_importadora.inserePessoa_importadoraBD("Pessoa 2", hash, "Bairro7", "Rua7", 0, "6789",new Date(), "2883432" , "789123");
        InserePessoa_importadora.inserePessoa_importadoraBD("Pessoa 3", hash, "Bairro8", "Rua8", 0, "6789", new Date(), "2343123" , "123456");
        InserePessoa_importadora.inserePessoa_importadoraBD("Pessoa 4", hash, "Bairro9", "Rua9", 0, "6789", new Date(), "2398732" , "456123");
        InserePessoa_importadora.inserePessoa_importadoraBD("Pessoa 5", hash, "Bairro10", "Rua10", 0, "6789", new Date(), "2342154" , "789456");
        
        InsereProduto.insereProdutoBD(1.2f, 3.3f, 0.4f, "Descricao 1", "456", "Fabricante 1", 5, 9, "Produto 1");
        InsereProduto.insereProdutoBD(6.1f, 2.1f, 9.4f, "Descricao 2", "656", "Fabricante 2", 3, 2, "Produto 2");
        InsereProduto.insereProdutoBD(8.2f, 1.7f, 20.0f, "Descricao 3", "766", "Fabricante 3", 1, 1, "Produto 3");
        InsereProduto.insereProdutoBD(7.0f, 5.0f, 4.8f, "Descricao 4", "986", "Fabricante 4", 2, 7, "Produto 4");
        InsereProduto.insereProdutoBD(4.9f, 66.2f, 5.6f, "Descricao 5", "412", "Fabricante 5", 7, 8, "Produto 5");
        
        InsereImportacao.insereImportacaoBD(1, "123789", null);
        InsereImportacao.insereImportacaoBD(2, "123789", null);
        InsereImportacao.insereImportacaoBD(3, null, "357");
        InsereImportacao.insereImportacaoBD(4, null, "246");
        InsereImportacao.insereImportacaoBD(5, "456123", null);
        
        InsereNotificacao.insereNotificacaoBD("Decrição incomplete","Dado incompleto", 1);
        try{Thread.sleep(1500);}catch(Exception e){e.printStackTrace();}
        InsereNotificacao.insereNotificacaoBD("Dados errado","Dado incompleto", 1);
        try{Thread.sleep(1500);}catch(Exception e){e.printStackTrace();}
        InsereNotificacao.insereNotificacaoBD("Aguardando apgamento","Pagamento", 1);
        try{Thread.sleep(1500);}catch(Exception e){e.printStackTrace();}
        InsereNotificacao.insereNotificacaoBD("Decrição incomplete","Dado incompleto", 2);
        try{Thread.sleep(1500);}catch(Exception e){e.printStackTrace();}
        InsereNotificacao.insereNotificacaoBD("Dados errado","Dado incompleto", 2);
        try{Thread.sleep(1500);}catch(Exception e){e.printStackTrace();}
        InsereNotificacao.insereNotificacaoBD("Aguardando apgamento","Pagamento", 2);
        try{Thread.sleep(1500);}catch(Exception e){e.printStackTrace();}
        InsereNotificacao.insereNotificacaoBD("Decrição incomplete","Dado incompleto", 2);
        try{Thread.sleep(1500);}catch(Exception e){e.printStackTrace();}
        InsereNotificacao.insereNotificacaoBD("Decrição incomplete","Dado incompleto", 3);
        try{Thread.sleep(1500);}catch(Exception e){e.printStackTrace();}
        InsereNotificacao.insereNotificacaoBD("Decrição incomplete","Dado incompleto", 4);
        try{Thread.sleep(1500);}catch(Exception e){e.printStackTrace();}
        InsereNotificacao.insereNotificacaoBD("Decrição incomplete","Dado incompleto", 5);
        try{Thread.sleep(1500);}catch(Exception e){e.printStackTrace();}
        InsereNotificacao.insereNotificacaoBD("Decrição incomplete","Dado incompleto", 5);
        
        
    }
}
