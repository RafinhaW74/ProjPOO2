/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.openjfx.poo.Controller;

import java.util.ArrayList;
import java.util.List;
import javafx.stage.Stage;

/**
 *
 * @author rafin
 */
public class SalvaTelasSobressalentes {
    private List<Stage> janelasAbertas;

    private SalvaTelasSobressalentes() {
        janelasAbertas = new ArrayList<>();
    }
    
    private static SalvaTelasSobressalentes singleton;
    
    public static SalvaTelasSobressalentes getInstance(){
        if(singleton == null){
            singleton = new SalvaTelasSobressalentes();
        }
        return singleton;
    }

    public List<Stage> getJanelasAbertas() {
        return janelasAbertas;
    }

    public void setJanelasAbertas(List<Stage> janelasAbertas) {
        this.janelasAbertas = janelasAbertas;
    }

    public static SalvaTelasSobressalentes getSingleton() {
        return singleton;
    }

    public static void setSingleton(SalvaTelasSobressalentes singleton) {
        SalvaTelasSobressalentes.singleton = singleton;
    }

    public void adicionaLista(Stage stage){
        janelasAbertas.add(stage);
        stage.setOnCloseRequest(e -> {
            janelasAbertas.remove(stage);
        });
    }

    public void fecharTodasJanelasExtras() {
        for (Stage janela : new ArrayList<>(getJanelasAbertas())) {
            janela.close();
        }
        getJanelasAbertas().clear();
    }
}
