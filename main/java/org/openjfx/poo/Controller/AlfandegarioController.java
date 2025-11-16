/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package org.openjfx.poo.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Toggle;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.openjfx.poo.App;


import org.openjfx.poo.Model.Dao.BuscaAlfandegario;
import org.openjfx.poo.Model.Dao.BuscaImportacaoID;
import org.openjfx.poo.Model.Dao.ListaImportacaoEmpresa;
import org.openjfx.poo.Model.Dao.ListaImportacaoPessoa;
import org.openjfx.poo.Model.Dao.ListaImportacaoSituacao;
import org.openjfx.poo.Model.Importacao;
import org.openjfx.poo.View.Alertas;

/**
 * FXML Controller class
 *
 * @author valuc
 */
public class AlfandegarioController implements Initializable {

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
    @FXML
    private RadioButton rbIDImporter;
    @FXML
    private ToggleGroup rbSearch;
    @FXML
    private RadioButton rbIDImport;
    @FXML
    private TextField tfSearch;
    @FXML
    private Button btnSearch;
    @FXML
    private RadioButton rbSituation;

    /**
     * Initializes the controller class.
     */
    private String identificador;
    
    private ObservableList<Importacao> listImportacao;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        identificador = LoginControler.getIdentificadorGeral();
        mnName.setText(BuscaAlfandegario.buscaAlfandegarioBD(identificador).getNome());
        
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
        
        listImportacao = FXCollections.observableArrayList();
        lvImports.setItems(listImportacao);
        
       
        lvImports.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("FXImportAction.fxml"));
                    Parent root = fxmlLoader.load();

                    ImportActionController control = fxmlLoader.getController();
                    control.setOnUpdate(this::updateImportacaoNaLista);
                    control.setImportacao(newVal);
                    
                    Stage novaJanela = new Stage();
                    novaJanela.setScene(new Scene(root, 1000, 560));
                    Stage janelaPrincipal = (Stage) lvImports.getScene().getWindow();
                    novaJanela.initOwner(janelaPrincipal);
                    SalvaTelasSobressalentes.getInstance().adicionaLista(novaJanela);
                    novaJanela.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }    

    @FXML
    private void User(ActionEvent event) {
    }

    @FXML
    private void RequestImport(ActionEvent event) {
        try{
            App.setRoot("FXRegisterADM");
        }catch (IOException erro) {
            System.out.println(erro);
            Alertas.mostrarAlerta("Erro carregar", "Erro ao carregar a tela de cadastro de ADM.", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void viewImport(ActionEvent event) {
    }

    @FXML
    private void viewPending(ActionEvent event) {
    }

    @FXML
    private void logout(ActionEvent event) {
        SalvaTelasSobressalentes.getInstance().fecharTodasJanelasExtras();
        try{
            App.setRoot("FXLogin");
        }catch (IOException erro) {
            System.out.println(erro);
            Alertas.mostrarAlerta("Erro carregar", "Erro ao carregar a tela de login.", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void ntnSearchAction(ActionEvent event) {
        if(rbSituation.isSelected()){
            List<Importacao> lista;
            lista = ListaImportacaoSituacao.listaImportacoesPessoaBD(tfSearch.getText());
            if(lista == null){
                Alertas.mostrarAlerta("Erro busca", "Nada encontrado.", Alert.AlertType.WARNING);
            }else{
                listImportacao.clear();
                listImportacao.addAll(lista);
            }
        }else if(rbIDImporter.isSelected()){
            List<Importacao> lista;
            if(tfSearch.getText().length() > 11){
                lista = ListaImportacaoEmpresa.listaImportacoesEmpresaBD(tfSearch.getText());
            }else{
                lista = ListaImportacaoPessoa.listaImportacoesPessoaBD(tfSearch.getText());
            }
            if(lista == null){
                Alertas.mostrarAlerta("Erro busca", "Nada encontrado.", Alert.AlertType.WARNING);
            }else{
                listImportacao.clear();
                listImportacao.addAll(lista);
            }
        }else if(rbIDImport.isSelected()){
            try{
                Importacao imp = BuscaImportacaoID.buscaImportacaoBD(Integer.parseInt(tfSearch.getText()));
                if(imp == null){
                    Alertas.mostrarAlerta("Erro busca", "Nada encontrado.", Alert.AlertType.WARNING);
                }else{
                    listImportacao.clear();
                    listImportacao.addAll(imp);
                }
            }catch(NumberFormatException e){
                System.out.println(e);
                Alertas.mostrarAlerta("Erro busca", "O valor digitado deve ser numérico.", Alert.AlertType.ERROR);
            }
        }else{
            Alertas.mostrarAlerta("Erro busca", "Nenhuma opção de busca selecionada.", Alert.AlertType.WARNING);
        }
    }
    
    private void updateImportacaoNaLista(Importacao atualizada) {
        for (int i = 0; i < listImportacao.size(); i++) {
            if (listImportacao.get(i).getNumero() == atualizada.getNumero()) {
                listImportacao.set(i, atualizada); 
                return;
            }
        }
    }
    
}
