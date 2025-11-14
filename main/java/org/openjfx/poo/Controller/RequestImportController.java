/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package org.openjfx.poo.Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.InvalidationListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import org.openjfx.poo.Model.Dao.BuscaEmpresa;
import org.openjfx.poo.Model.Dao.BuscaPessoa_importadora;

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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nome = LoginControler.getNome();
        pessoa = LoginControler.isPessoa();
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
    }

    @FXML
    private void viewPending(ActionEvent event) {
    }

    @FXML
    private void logout(ActionEvent event) {
    }

    @FXML
    private void btnRegisterAction(ActionEvent event) {
    }
    
    public void setFilter(){
        tfWidth.setTextFormatter(new FilterFloat(2));
        tfHeight.setTextFormatter(new FilterFloat(2));
        tfLength.setTextFormatter(new FilterFloat(2));
        tfWeight.setTextFormatter(new FilterFloat(2));
    }
    
}
