/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author rafin
 */
public interface CriaExcluiAltera<T>{
    void criar(T objeto);
    void excluir(T objeto);
    void alterar(T objeto);
}
