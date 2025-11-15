/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package org.openjfx.poo.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.InvalidationListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import org.openjfx.poo.App;
import static org.openjfx.poo.Controller.LoginControler.setIdentificadorGeral;
import static org.openjfx.poo.Controller.LoginControler.setNome;
import org.openjfx.poo.Model.Dao.BuscaEmpresa;
import org.openjfx.poo.Model.Dao.BuscaPessoa_importadora;
import org.openjfx.poo.View.Alertas;
import org.openjfx.poo.Model.Dao.InsereImportacao;
import org.openjfx.poo.Model.Dao.InsereProduto;

/**
 * FXML Controller class
 *
 * @author valuc
 */
public class RequestImportController implements Initializable {

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
    private Button btnLogout;
    @FXML
    private TextField tfHeight;
    @FXML
    private TextField tfLength;
    @FXML
    private TextField tfWidth;
    @FXML
    private TextArea taDescription;
    @FXML
    private TextField tfName;
    @FXML
    private TextField tfManufacturer;
    @FXML
    private RadioButton rbNot;
    @FXML
    private ToggleGroup tgRestricted;
    @FXML
    private TextField tfLI;
    @FXML
    private Label lbLI;
    @FXML
    private Button btnRegister;
    @FXML
    private RadioButton rbYes;
    @FXML
    private TextField tfWeight;

    /**
     * Initializes the controller class.
     */
    private String nome;
    boolean pessoa;
    private String identificador;
    @FXML
    private TextField tfAmount;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setFilter();
        nome = LoginControler.getNome();
        pessoa = LoginControler.isPessoa();
        identificador = LoginControler.getIdentificadorGeral();
        if(!pessoa){
            mnName.setText(nome);
        }else{
            mnName.setText(nome);
        }
        
        
        tgRestricted.selectedToggleProperty().addListener((observable, oldToggle, newToggle)->{
           if(rbYes.isSelected()){
               lbLI.setVisible(true);
               tfLI.setVisible(true);
           }else{
               lbLI.setVisible(false);
               tfLI.setVisible(false);
           }
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
        try{
            App.setRoot("FXImportador");
        }catch (IOException erro) {
            System.out.println(erro);
            Alertas.mostrarAlerta("Erro carregar", "Erro ao carregar a tela do importador.", Alert.AlertType.ERROR);
        }
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
    private void btnRegisterAction(ActionEvent event) {
        List<TextInputControl> campos = List.of(tfName, taDescription, tfHeight, tfWidth, tfLength, tfWeight, tfManufacturer);
        if(campos.stream().anyMatch(tf -> tf.getText().trim().isEmpty())){
            Alertas.mostrarAlerta("Erro campo vazio", "Todos os campos devem ser preenchidos.", Alert.AlertType.ERROR);
        }else{
            if(rbYes.isSelected()){
                if(tfLI.getText().trim().isEmpty()){
                    Alertas.mostrarAlerta("Erro campo vazio", "Todos os campos devem ser preenchidos.", Alert.AlertType.ERROR);
                }else{
                    int numeroProd = InsereProduto.insereProdutoBD((Float) tfLength.getTextFormatter().getValue(), (Float) tfWidth.getTextFormatter().getValue(), (Float) tfHeight.getTextFormatter().getValue(), taDescription.getText(), tfLI.getText(), tfManufacturer.getText(), 0, (Float) tfWeight.getTextFormatter().getValue(), tfName.getText());
                    if(pessoa){
                        InsereImportacao.insereImportacaoBD(numeroProd, identificador, null);
                    }else{
                        InsereImportacao.insereImportacaoBD(numeroProd, null, identificador);
                    }
                    try{
                        App.setRoot("FXImportador");
                    }catch (IOException erro) {
                        System.out.println(erro);
                        Alertas.mostrarAlerta("Erro carregar", "Erro ao carregar a tela do importador.", Alert.AlertType.ERROR);
                    }
                }
            }else if(rbNot.isSelected()){
                int numeroProd = InsereProduto.insereProdutoBD((Float) tfLength.getTextFormatter().getValue(), (Float) tfWidth.getTextFormatter().getValue(), (Float) tfHeight.getTextFormatter().getValue(), taDescription.getText(), "", tfManufacturer.getText(), 0, (Float) tfWeight.getTextFormatter().getValue(), tfName.getText());
                if(pessoa){
                    InsereImportacao.insereImportacaoBD(numeroProd, identificador, null);
                }else{
                    InsereImportacao.insereImportacaoBD(numeroProd, null, identificador);
                }
                try{
                    App.setRoot("FXImportador");
                }catch (IOException erro) {
                    System.out.println(erro);
                    Alertas.mostrarAlerta("Erro carregar", "Erro ao carregar a tela do importador.", Alert.AlertType.ERROR);
                }
            }else{
                Alertas.mostrarAlerta("Erro restrito não selecionadao", "Selecione se é restrito ou não.", Alert.AlertType.ERROR);
            }
        }
        
        
        
    }
    
    public void setFilter(){
        tfWidth.setTextFormatter(new FilterFloat(2));
        tfHeight.setTextFormatter(new FilterFloat(2));
        tfLength.setTextFormatter(new FilterFloat(2));
        tfWeight.setTextFormatter(new FilterFloat(2));
        tfAmount.setTextFormatter(new FilterInt());
    }
    
}
