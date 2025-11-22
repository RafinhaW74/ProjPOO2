/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.openjfx.poo.Model.Dao;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import java.sql.PreparedStatement;
import java.time.LocalDate;

import java.util.Calendar;
import java.util.Date;
import org.openjfx.poo.Model.*;
import org.openjfx.poo.Model.Service.DateManipulation;

/**
 *
 * @author valuc
 */
public class DataTest {
    public static void Insert(){
        System.out.println("Inserindo dados");
        String senha = "Senha";
        Argon2 argon2 = Argon2Factory.create();
        

        
        Alfandegario alf1 = new Alfandegario("João Silva", argon2.hash(2, 65536, 2, senha), "12345678901", "10001");
        Alfandegario alf2 = new Alfandegario("Maria Oliveira", argon2.hash(2, 65536, 2, senha), "98765432109", "10002");
        Alfandegario alf3 = new Alfandegario("Pedro Costa", argon2.hash(2, 65536, 2, senha), "11122233344", "10003");
        Alfandegario alf4 = new Alfandegario("Ana Santos", argon2.hash(2, 65536, 2, senha), "55566677788", "10004");
        Alfandegario alf5 = new Alfandegario("Ricardo Souza", argon2.hash(2, 65536, 2, senha), "00011122233", "10005");

        InsereAlfandegario.insereAlfandegarioBD(alf1);
        InsereAlfandegario.insereAlfandegarioBD(alf2);
        InsereAlfandegario.insereAlfandegarioBD(alf3);
        InsereAlfandegario.insereAlfandegarioBD(alf4);
        InsereAlfandegario.insereAlfandegarioBD(alf5);
        
        Date dataNasc1 = DateManipulation.CreateDate(2005, 01, 20); 
        Date dataNasc2 = DateManipulation.CreateDate(85, 4, 20); 
        Date dataNasc3 = DateManipulation.CreateDate(78, 10, 30); 
        Date dataNasc4 = DateManipulation.CreateDate(100, 2, 1); 
        Date dataNasc5 = DateManipulation.CreateDate(95, 7, 10); 
        
        Pessoa_importadora pf1 = new Pessoa_importadora(dataNasc1, "12345678", "44455566677", "Av. Central", "Centro", 100, "01000001", "Carlos Lima", argon2.hash(2, 65536, 2, senha));
        Pessoa_importadora pf2 = new Pessoa_importadora(dataNasc2, "87654321", "88899900011", "Rua B", "Santana", 250, "02000002", "Fernanda Reis", argon2.hash(2, 65536, 2, senha));
        Pessoa_importadora pf3 = new Pessoa_importadora(dataNasc3, "34567890", "22233344455", "Alameda C", "Vila Nova", 45, "03000003", "Gustavo Alves", argon2.hash(2, 65536, 2, senha));
        Pessoa_importadora pf4 = new Pessoa_importadora(dataNasc4, "90123456", "66677788899", "Estr. D", "Laranjeiras", 780, "04000004", "Helena Melo", argon2.hash(2, 65536, 2, senha));
        Pessoa_importadora pf5 = new Pessoa_importadora(dataNasc5, "56789012", "10120230340", "Pç. E", "Bela Vista", 12, "05000005", "Igor Rocha", argon2.hash(2, 65536, 2, senha));

        InserePessoa_importadora.inserePessoa_importadoraBD(pf1);
        InserePessoa_importadora.inserePessoa_importadoraBD(pf2);
        InserePessoa_importadora.inserePessoa_importadoraBD(pf3);
        InserePessoa_importadora.inserePessoa_importadoraBD(pf4);
        InserePessoa_importadora.inserePessoa_importadoraBD(pf5);

        Empresa_importadora pj1 = new Empresa_importadora("00111222000133", "Av. Paulista", "Bela Cintra", 1500, "10000100", "Importex Ltda", argon2.hash(2, 65536, 2, senha), "Ouro");
        Empresa_importadora pj2 = new Empresa_importadora("33444555000166", "R. do Comércio", "Centro", 50, "20000200", "Global Trade SA", argon2.hash(2, 65536, 2, senha), "Prata");
        Empresa_importadora pj3 = new Empresa_importadora("66777888000199", "Estr. Principal", "Indústria", 980, "30000300", "E-Commerce BR", argon2.hash(2, 65536, 2, senha), "Bronze");
        Empresa_importadora pj4 = new Empresa_importadora("99000111000122", "Av. Inovação", "Tecnologia", 321, "40000400", "Tech Imports", argon2.hash(2, 65536, 2, senha), "Ouro");
        Empresa_importadora pj5 = new Empresa_importadora("11222333000155", "R. dos Galpões", "Logística", 55, "50000500", "Logística Rápida", argon2.hash(2, 65536, 2, senha), "Prata");
    
        InsereEmpresa.insereEmpresaBD(pj1);
        InsereEmpresa.insereEmpresaBD(pj2);
        InsereEmpresa.insereEmpresaBD(pj3);
        InsereEmpresa.insereEmpresaBD(pj4);
        InsereEmpresa.insereEmpresaBD(pj5);
    
        Produtos prod1 = new Produtos(1, 35.0f, 2.5f, 25.0f, "Laptop de alto desempenho.", "LI12345", "TechCorp", 50, 2.5f, "Notebook X");
        Produtos prod2 = new Produtos(2, 8.0f, 1.0f, 16.0f, "Celular 5G com câmera dupla.", "LI67890", "MobileBest", 200, 0.2f, "Smartphone Y");
        Produtos prod3 = new Produtos(3, 15.0f, 10.0f, 12.0f, "Câmera digital profissional.", "LI11223", "PhotoPro", 80, 0.6f, "Câmera Z");
        Produtos prod4 = new Produtos(4, 20.0f, 0.7f, 30.0f, "Tablet para uso educacional.", "LI33445", "PadGlobal", 120, 0.8f, "Tablet W");
        Produtos prod5 = new Produtos(5, 5.0f, 3.0f, 5.0f, "Fone de ouvido sem fio.", "LI55667", "AudioFix", 300, 0.05f, "Fone Bluetooth");
    
        InsereProduto.insereProdutoBD(prod1);
        InsereProduto.insereProdutoBD(prod2);
        InsereProduto.insereProdutoBD(prod3);
        InsereProduto.insereProdutoBD(prod4);
        InsereProduto.insereProdutoBD(prod5);

        Date dataImportaca1 = DateManipulation.CreateDate(2025, 12, 15, 10, 30, 0); 
        Date dataImportaca2 = DateManipulation.CreateDate(2025, 11, 20, 14, 45, 0);
        Date dataImportaca3 = DateManipulation.CreateDate(2025, 10, 5, 9, 15, 0);
        Date dataImportaca4 = DateManipulation.CreateDate(2025, 9, 25, 16, 0, 0);
        Date dataImportaca5 = DateManipulation.CreateDate(2025, 8, 30, 11, 20, 0);

        //Posiveis Status: Excluído   Requer ação   Pagamento pendente   Bloqueado  Confirmado  Em Análise
        Importacao imp_pf1_1 = new Importacao("Confirmado", 1, prod1, pf1, null, dataImportaca1, null, dataImportaca1);
        Importacao imp_pf1_2 = new Importacao("Pagamento pendente", 2, prod2, pf1, null, dataImportaca2, null, dataImportaca2);
        Importacao imp_pf1_3 = new Importacao("Requer ação", 3, prod3, pf1, null, dataImportaca3, null, dataImportaca3);
        Importacao imp_pf1_4 = new Importacao("Bloqueado", 4, prod4, pf1, null, dataImportaca4, null, dataImportaca4);
        
        Importacao imp_pf2_1 = new Importacao("Em Análise", 5, prod2, pf2, null, dataImportaca2, null, dataImportaca2);
        Importacao imp_pf2_2 = new Importacao("Confirmado", 6, prod3, pf2, null, dataImportaca3, null, dataImportaca3);
        Importacao imp_pf2_3 = new Importacao("Excluído", 7, prod4, pf2, null, dataImportaca4, null, dataImportaca4);
        Importacao imp_pf2_4 = new Importacao("Pagamento pendente", 8, prod5, pf2, null, dataImportaca5, null, dataImportaca5);

        Importacao imp_pf3_1 = new Importacao("Requer ação", 9, prod3, pf3, null, dataImportaca3, null, dataImportaca3);
        Importacao imp_pf3_2 = new Importacao("Confirmado", 10, prod4, pf3, null, dataImportaca4, null, dataImportaca4);
        Importacao imp_pf3_3 = new Importacao("Bloqueado", 11, prod5, pf3, null, dataImportaca5, null, dataImportaca5);
        Importacao imp_pf3_4 = new Importacao("Em Análise", 12, prod1, pf3, null, dataImportaca1, null, dataImportaca1);

        Importacao imp_pf4_1 = new Importacao("Requer ação", 14, prod4, pf4, null, dataImportaca4, null, dataImportaca4);
        Importacao imp_pf4_2 = new Importacao("Excluído", 15, prod5, pf4, null, dataImportaca5, null, dataImportaca5);
        Importacao imp_pf4_3 = new Importacao("Confirmado", 16, prod1, pf4, null, dataImportaca1, null, dataImportaca1);
        Importacao imp_pf4_4 = new Importacao("Pagamento pendente", 17, prod2, pf4, null, dataImportaca2, null, dataImportaca2);

        Importacao imp_pf5_1 = new Importacao("Em Análise", 18, prod5, pf5, null, dataImportaca5, null, dataImportaca5);
        Importacao imp_pf5_2 = new Importacao("Bloqueado", 19, prod1, pf5, null, dataImportaca1, null, dataImportaca1);
        Importacao imp_pf5_3 = new Importacao("Requer ação", 20, prod2, pf5, null, dataImportaca2, null, dataImportaca2);
        Importacao imp_pf5_4 = new Importacao("Confirmado", 21, prod3, pf5, null, dataImportaca3, null, dataImportaca3);

        Importacao imp_pj1_1 = new Importacao("Excluído", 22, prod1, null, pj1, dataImportaca1, null, dataImportaca1);
        Importacao imp_pj1_2 = new Importacao("Requer ação", 23, prod2, null, pj1, dataImportaca2, null, dataImportaca2);
        Importacao imp_pj1_3 = new Importacao("Confirmado", 24, prod3, null, pj1, dataImportaca3, null, dataImportaca3);
        Importacao imp_pj1_4 = new Importacao("Em Análise", 25, prod4, null, pj1, dataImportaca4, null, dataImportaca4);

        Importacao imp_pj2_1 = new Importacao("Bloqueado", 26, prod2, null, pj2, dataImportaca2, null, dataImportaca2);
        Importacao imp_pj2_2 = new Importacao("Confirmado", 27, prod3, null, pj2, dataImportaca3, null, dataImportaca3);
        Importacao imp_pj2_3 = new Importacao("Pagamento pendente", 28, prod4, null, pj2, dataImportaca4, null, dataImportaca4);
        Importacao imp_pj2_4 = new Importacao("Excluído", 29, prod5, null, pj2, dataImportaca5, null, dataImportaca5);

        Importacao imp_pj3_1 = new Importacao("Em Análise", 30, prod3, null, pj3, dataImportaca3, null, dataImportaca3);
        Importacao imp_pj3_2 = new Importacao("Requer ação", 31, prod4, null, pj3, dataImportaca4, null, dataImportaca4);
        Importacao imp_pj3_3 = new Importacao("Confirmado", 32, prod5, null, pj3, dataImportaca5, null, dataImportaca5);
        Importacao imp_pj3_4 = new Importacao("Bloqueado", 33, prod1, null, pj3, dataImportaca1, null, dataImportaca1);

        Importacao imp_pj4_1 = new Importacao("Pagamento pendente", 34, prod4, null, pj4, dataImportaca4, null, dataImportaca4);
        Importacao imp_pj4_2 = new Importacao("Excluído", 35, prod5, null, pj4, dataImportaca5, null, dataImportaca5);
        Importacao imp_pj4_3 = new Importacao("Confirmado", 36, prod1, null, pj4, dataImportaca1, null, dataImportaca1);
        Importacao imp_pj4_4 = new Importacao("Requer ação", 37, prod2, null, pj4, dataImportaca2, null, dataImportaca2);

        Importacao imp_pj5_1 = new Importacao("Bloqueado", 38, prod5, null, pj5, dataImportaca5, null, dataImportaca5);
        Importacao imp_pj5_2 = new Importacao("Em Análise", 39, prod1, null, pj5, dataImportaca1, null, dataImportaca1);
        Importacao imp_pj5_3 = new Importacao("Pagamento pendente", 40, prod2, null, pj5, dataImportaca2, null, dataImportaca2);
        Importacao imp_pj5_4 = new Importacao("Confirmado", 41, prod3, null, pj5, dataImportaca3, null, dataImportaca3);

        // ------------------------------
        // Pessoa Física (pf1)
        // ------------------------------
        InsereImportacao.insereImportacaoBD(imp_pf1_1);
        InsereImportacao.insereImportacaoBD(imp_pf1_2);
        InsereImportacao.insereImportacaoBD(imp_pf1_3);
        InsereImportacao.insereImportacaoBD(imp_pf1_4);

        // ------------------------------
        // Pessoa Física (pf2)
        // ------------------------------
        InsereImportacao.insereImportacaoBD(imp_pf2_1);
        InsereImportacao.insereImportacaoBD(imp_pf2_2);
        InsereImportacao.insereImportacaoBD(imp_pf2_3);
        InsereImportacao.insereImportacaoBD(imp_pf2_4);

        // ------------------------------
        // Pessoa Física (pf3)
        // ------------------------------
        InsereImportacao.insereImportacaoBD(imp_pf3_1);
        InsereImportacao.insereImportacaoBD(imp_pf3_2);
        InsereImportacao.insereImportacaoBD(imp_pf3_3);
        InsereImportacao.insereImportacaoBD(imp_pf3_4);

        // ------------------------------
        // Pessoa Física (pf4)
        // ------------------------------
        InsereImportacao.insereImportacaoBD(imp_pf4_1);
        InsereImportacao.insereImportacaoBD(imp_pf4_2);
        InsereImportacao.insereImportacaoBD(imp_pf4_3);
        InsereImportacao.insereImportacaoBD(imp_pf4_4);

        // ------------------------------
        // Pessoa Física (pf5)
        // ------------------------------
        InsereImportacao.insereImportacaoBD(imp_pf5_1);
        InsereImportacao.insereImportacaoBD(imp_pf5_2);
        InsereImportacao.insereImportacaoBD(imp_pf5_3);
        InsereImportacao.insereImportacaoBD(imp_pf5_4);

        // ------------------------------
        // Pessoa Jurídica (pj1)
        // ------------------------------
        InsereImportacao.insereImportacaoBD(imp_pj1_1);
        InsereImportacao.insereImportacaoBD(imp_pj1_2);
        InsereImportacao.insereImportacaoBD(imp_pj1_3);
        InsereImportacao.insereImportacaoBD(imp_pj1_4);

        // ------------------------------
        // Pessoa Jurídica (pj2)
        // ------------------------------
        InsereImportacao.insereImportacaoBD(imp_pj2_1);
        InsereImportacao.insereImportacaoBD(imp_pj2_2);
        InsereImportacao.insereImportacaoBD(imp_pj2_3);
        InsereImportacao.insereImportacaoBD(imp_pj2_4);

        // ------------------------------
        // Pessoa Jurídica (pj3)
        // ------------------------------
        InsereImportacao.insereImportacaoBD(imp_pj3_1);
        InsereImportacao.insereImportacaoBD(imp_pj3_2);
        InsereImportacao.insereImportacaoBD(imp_pj3_3);
        InsereImportacao.insereImportacaoBD(imp_pj3_4);

        // ------------------------------
        // Pessoa Jurídica (pj4)
        // ------------------------------
        InsereImportacao.insereImportacaoBD(imp_pj4_1);
        InsereImportacao.insereImportacaoBD(imp_pj4_2);
        InsereImportacao.insereImportacaoBD(imp_pj4_3);
        InsereImportacao.insereImportacaoBD(imp_pj4_4);

        // ------------------------------
        // Pessoa Jurídica (pj5)
        // ------------------------------
        InsereImportacao.insereImportacaoBD(imp_pj5_1);
        InsereImportacao.insereImportacaoBD(imp_pj5_2);
        InsereImportacao.insereImportacaoBD(imp_pj5_3);
        InsereImportacao.insereImportacaoBD(imp_pj5_4);
        //Posiveis tipos de notificação: Pagamento   Campo inválido  Outro
        
        System.out.println("Fim da insercao");
    }
    
    
    public static void ClearDB(){
        System.out.println("Limpando...");
        try{
            Conexao connection = new Conexao();
            PreparedStatement st = connection.get_prepare("DROP TABLE notificacao; DROP TABLE importacao; DROP TABLE pessoa_importadora; DROP TABLE empresa; DROP TABLE alfandegario; DROP TABLE produto;");
            st.execute();
            
        }catch(Exception e){}
        System.out.println("Fim da limpeza");
    }
}


