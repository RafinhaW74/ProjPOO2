package org.openjfx.poo.Model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.Date;

/**
 *
 * @author rafin
 */
public class Pessoa_importadora extends Importador{
    private Date data_nascimento;
    private String RG;
    private String CPF;

    public Pessoa_importadora() {
        super();
    }
    
    public Pessoa_importadora(Date data_nascimento, String RG, String CPF, String rua, String bairro, int numero, String cep, String nome, String senha) {
        super(rua, bairro, numero, cep, nome, senha);
        this.data_nascimento = data_nascimento;
        this.RG = RG;
        this.CPF = CPF;
    }


    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
    
    
}
