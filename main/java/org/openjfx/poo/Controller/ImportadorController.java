/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package org.openjfx.poo.Controller;

import org.openjfx.poo.Model.Dao.ListaImportacaoPessoa;
import org.openjfx.poo.Model.Dao.ListaImportacaoEmpresa;

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
import org.openjfx.poo.Model.Dao.BuscaEmpresa;
import org.openjfx.poo.Model.Dao.BuscaPessoa_importadora;
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
    private  boolean pessoa;
    private String identificador;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        identificador = LoginControler.getIdentificadorGeral();
        if(identificador.length() > 11){
            pessoa = false;
            mnName.setText(BuscaEmpresa.buscaEmpresa_importadoraBD(identificador).getNome());
        }else{
            pessoa = true;
            mnName.setText(BuscaPessoa_importadora.buscaPessoa_importadoraBD(identificador).getNome());
        }
        
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
        
        ObservableList<Importacao> listImportacao = FXCollections.observableArrayList();
        lvImports.setItems(listImportacao);
        
        if(pessoa){
            listImportacao.addAll(ListaImportacaoPessoa.listaImportacoesPessoaBD(identificador));
        }else{
            listImportacao.addAll(ListaImportacaoEmpresa.listaImportacoesEmpresaBD(identificador));
        }
        
        
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
