package com.mycompany.tentandoprojetopoo2.Model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author rafin
 */
public class Empresa_importadora extends Importador{
    private String razao_social;
    private String CNPJ;
    private String habilitacao;

    public Empresa_importadora() {
        super();
    }
    
    public Empresa_importadora(String razao_social, String CNPJ, String rua, String bairro, int numero, String cep, String nome, String senha, String habilitacao) {
        super(rua, bairro, numero, cep, nome, senha);
        this.razao_social = razao_social;
        this.CNPJ = CNPJ;
        this.habilitacao = habilitacao;
    }

    public String getRazao_social() {
        return razao_social;
    }

    public void setRazao_social(String razao_social) {
        this.razao_social = razao_social;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getHabilitacao() {
        return habilitacao;
    }

    public void setHabilitacao(String habilitacao) {
        this.habilitacao = habilitacao;
    }
    
        
    
    
}
