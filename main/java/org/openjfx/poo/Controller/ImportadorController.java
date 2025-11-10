/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package org.openjfx.poo.Controller;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import org.openjfx.poo.Model.Empresa_importadora;
import org.openjfx.poo.Model.Importacao;
import org.openjfx.poo.Model.Pessoa_importadora;
import org.openjfx.poo.Model.Produtos;

/**
 * FXML Controller class
 *
 * @author valuc
 */
public class ImportadorController implements Initializable {

    @FXML
    private MenuBar menuBar;
    @FXML
    private Menu mnName;
    @FXML
    private Menu mnRequestImport;
    @FXML
    private MenuItem miRequest;
    @FXML
    private MenuItem miView;
    @FXML
    private Menu mnViewPending;
    @FXML
    private MenuItem miViewPending;
    @FXML
    private ListView<Importacao> lvImports;
    @FXML
    private Button btnLogout;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        lvImports.setCellFactory(param -> new ListCell<Importacao>(){
            private final Label nomeLabel = new Label();
            private final Label situacaoLabel = new Label();
            private final VBox content = new VBox(nomeLabel, situacaoLabel);

            {
                content.setSpacing(2);
                content.setPadding(new Insets(4, 6, 4, 6));


                nomeLabel.getStyleClass().add("listName");  
                situacaoLabel.getStyleClass().add("listSituation"); 
            }

            @Override
            protected void updateItem(Importacao importacao, boolean empty) {
                super.updateItem(importacao, empty);

                if (empty || importacao == null) {
                    setGraphic(null);
                } else {
                    nomeLabel.setText(importacao.getProdutos().getNome());
                    situacaoLabel.setText(importacao.getSituacao());
                    setGraphic(content);
                }
            }
        });
        Produtos produto = new Produtos(
            1003, 
            200.0f, 
            150.0f, 
            100.0f, 
            "Máquina de Café Industrial", 
            "LI-2024003", 
            "Philips", 
            10, 
            15.8f, 
            "Máquina de Café"
        );
        
        // Criar pessoa importadora 3
        Pessoa_importadora pessoa = new Pessoa_importadora(
            new Date(2000,10,01), // data nascimento
            "11.223.344-5", // RG
            "111.222.333-44", // CPF
            "Av. Brasil", // rua
            "Jardim América", // bairro
            321, // numero
            "98765-432", // cep
            "Carlos Oliveira", // nome
            "senha789" // senha
        );
        
        // Criar empresa importadora 3
        Empresa_importadora empresa = new Empresa_importadora(
            "Café & Cia Importação", // razao social
            "11.223.344/0001-55", // CNPJ
            "Rua das Palmeiras", // rua
            "Jardins", // bairro
            654, // numero
            "01452-000", // cep
            "Café & Cia", // nome
            "empresa789", // senha
            "HAB-003" // habilitacao
        );
        
        
        Importacao importacao1 = new Importacao(
            "REJEITADA", // situacao
            2024003, // numero
            new Date(System.currentTimeMillis() + 86400000L * 10), // previsao (10 dias)
            produto,
            pessoa,
            null
        );
        
        Importacao importacao2 = new Importacao(
            "Aprovada", // situacao
            2024003, // numero
            new Date(System.currentTimeMillis() + 86400000L * 10), // previsao (10 dias)
            produto,
            pessoa,
            null
        );
        
        Importacao importacao3 = new Importacao(
            "Em analise", // situacao
            2024003, // numero
            new Date(System.currentTimeMillis() + 86400000L * 10), // previsao (10 dias)
            produto,
            pessoa,
            null
        );
        
        ObservableList<Importacao> listImportacao = FXCollections.observableArrayList();
        lvImports.setItems(listImportacao);
        
        listImportacao.addAll(importacao1,importacao2,importacao3);
        
        lvImports.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            System.out.println("Selecionado: " + newVal);
        });
    }    

    @FXML
    private void User(ActionEvent event) {
    }

    @FXML
    private void RequestImport(ActionEvent event) {
    }

    @FXML
    private void viewImport(ActionEvent event) {
    }

    @FXML
    private void viewPending(ActionEvent event) {
    }

    @FXML
    private void logout(ActionEvent event) {
    }
    
}
