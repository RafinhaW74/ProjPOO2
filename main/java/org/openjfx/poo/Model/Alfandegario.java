package org.openjfx.poo.Model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author rafin
 */
public class Alfandegario extends Usuario{
    private String CPF;
    private String SIAPE;

    public Alfandegario() {
        super();
    }

    public Alfandegario(String CPF, String SIAPE) {
        this.CPF = CPF;
        this.SIAPE = SIAPE;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getSIAPE() {
        return SIAPE;
    }

    public void setSIAPE(String SIAPE) {
        this.SIAPE = SIAPE;
    }
    
}
