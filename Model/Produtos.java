package com.mycompany.tentandoprojetopoo2.Model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author rafin
 */
public class Produtos {
    private int numero;
    private float largura;
    private float altura;
    private float comprimento;
    private String descricao;
    private String LI;
    private String fabricante;
    private int quantidade;
    private boolean Estado = true;

    public Produtos() {
        this.Estado = true;
    }

    public Produtos(int numero, float largura, float altura, float comprimento, String descricao, String LI, String fabricante, int quantidade) {
        this.numero = numero;
        this.largura = largura;
        this.altura = altura;
        this.comprimento = comprimento;
        this.descricao = descricao;
        this.LI = LI;
        this.fabricante = fabricante;
        this.Estado = true;
        this.quantidade = quantidade;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public float getLargura() {
        return largura;
    }

    public void setLargura(float largura) {
        this.largura = largura;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getComprimento() {
        return comprimento;
    }

    public void setComprimento(float comprimento) {
        this.comprimento = comprimento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLI() {
        return LI;
    }

    public void setLI(String LI) {
        this.LI = LI;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public boolean isEstado() {
        return Estado;
    }

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    
}
