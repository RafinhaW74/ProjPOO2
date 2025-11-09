package org.openjfx.poo.Model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author rafin
 */
public class Usuario {
    private String nome;
    private String senha;
    private boolean Estado = true;

    public Usuario() {
        this.Estado = true;
    }
    
    public Usuario(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
        this.Estado = true;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isEstado() {
        return Estado;
    }

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }
    
    
    
    
}
