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
    private String estado;
    private int numero; 
    private Date previsao;
    private List<Produtos> produtos;

    public Importacao() {
    }

    public Importacao(String estado, int numero, Date previsao, List<Produtos> produtos) {
        this.estado = estado;
        this.numero = numero;
        this.previsao = previsao;
        this.produtos = produtos;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

    public List<Produtos> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produtos> produtos) {
        this.produtos = produtos;
    }
    
    
}
