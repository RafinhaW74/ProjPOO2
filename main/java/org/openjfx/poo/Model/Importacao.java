package org.openjfx.poo.Model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.Date;
import java.util.List;

/**
 *
 * @author rafin
 */
public class Importacao {
    private String situacao;
    private int numero; 
    private Date previsao;
    private Date atualizacao;
    private Produtos produtos;
    private Pessoa_importadora importador;
    private Empresa_importadora empresa;
    private List<Notificacoes> notificacoes;
    private boolean Estado = true;

    public Importacao() {
        this.Estado = true;
    }

    public Importacao(String situacao, int numero, Date previsao, Produtos produtos, Pessoa_importadora importador, Empresa_importadora empresa, Date atualizacao, List<Notificacoes> notificacoes) {
        this.situacao = situacao;
        this.numero = numero;
        this.previsao = previsao;
        this.produtos = produtos;
        this.importador = importador;
        this.empresa = empresa;
        this.Estado = true;
        this.atualizacao = atualizacao;
        this.notificacoes = notificacoes;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getPrevisao() {
        return previsao;
    }

    public void setPrevisao(Date previsao) {
        this.previsao = previsao;
    }

    public Produtos getProdutos() {
        return produtos;
    }

    public void setProdutos(Produtos produtos) {
        this.produtos = produtos;
    }

    public Pessoa_importadora getImportador() {
        return importador;
    }

    public void setImportador(Pessoa_importadora importador) {
        this.importador = importador;
    }

    public Empresa_importadora getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa_importadora empresa) {
        this.empresa = empresa;
    }

    public boolean isEstado() {
        return Estado;
    }

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }

    public Date getAtualizacao() {
        return atualizacao;
    }

    public void setAtualizacao(Date atualizacao) {
        this.atualizacao = atualizacao;
    }

    public List<Notificacoes> getNotificacoes() {
        return notificacoes;
    }

    public void setNotificacoes(List<Notificacoes> notificacoes) {
        this.notificacoes = notificacoes;
    }
    

    
    
}
