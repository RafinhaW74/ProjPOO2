/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.openjfx.poo.Model;

import java.util.Date;



/**
 *
 * @author rafin
 */
public class Notificacoes {
    private String descricao;
    private int iD;
    private String tipo;
    private boolean estado;
    private boolean resolvido;
    private Date criacao; 
    private int importacaoID;
    
    
    public Notificacoes(){
        
    }

    public Notificacoes(String descricao, int iD, String tipo, boolean estado, boolean resolvido, Date criacao, int importacaoID) {
        this.descricao = descricao;
        this.iD = iD;
        this.tipo = tipo;
        this.estado = estado;
        this.resolvido = resolvido;
        this.criacao = criacao;
    }
    public int getImportacaoID() {
        return importacaoID;
    }
    public void setImportacaoID(int importacaoID) {
        this.importacaoID = importacaoID;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public boolean isResolvido() {
        return resolvido;
    }

    public void setResolvido(boolean resolvido) {
        this.resolvido = resolvido;
    }

    public Date getCriacao() {
        return criacao;
    }

    public void setCriacao(Date criacao) {
        this.criacao = criacao;
    }
    
    

    
    
}
