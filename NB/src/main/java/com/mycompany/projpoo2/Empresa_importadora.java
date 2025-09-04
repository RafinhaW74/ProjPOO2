/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projpoo2;

/**
 *
 * @author rafin
 */
public class Empresa_importadora extends Importador{
    private String razao_social;
    private int CNPJ;

    public Empresa_importadora() {
        super();
    }
    
    public Empresa_importadora(String razao_social, int CNPJ, String rua, String bairro, int numero, int cep, String nome, String login, String senha) {
        super(rua, bairro, numero, cep, nome, login, senha);
        this.razao_social = razao_social;
        this.CNPJ = CNPJ;
    }

    public String getRazao_social() {
        return razao_social;
    }

    public void setRazao_social(String razao_social) {
        this.razao_social = razao_social;
    }

    public int getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(int CNPJ) {
        this.CNPJ = CNPJ;
    }
    
        
    
    
}
