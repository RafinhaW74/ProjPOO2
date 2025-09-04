/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projpoo2;

import java.util.Date;

/**
 *
 * @author rafin
 */
public class Pessoa_importadora extends Importador{
    private Date data_nascimento;
    private int RG;
    private int CPF;

    public Pessoa_importadora() {
        super();
    }
    
    public Pessoa_importadora(Date data_nascimento, int RG, int CPF, String rua, String bairro, int numero, int cep, String nome, String login, String senha) {
        super(rua, bairro, numero, cep, nome, login, senha);
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

    public int getRG() {
        return RG;
    }

    public void setRG(int RG) {
        this.RG = RG;
    }

    public int getCPF() {
        return CPF;
    }

    public void setCPF(int CPF) {
        this.CPF = CPF;
    }
    
    
}
