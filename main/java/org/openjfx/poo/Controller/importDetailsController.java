/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package org.openjfx.poo.Controller;

import java.net.URL;
import java.util.ResourceBundle;
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

/**
 * FXML Controller class
 *
 * @author valuc
 */
public class importDetailsController implements Initializable {

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
    private RadioButton rbYes;
    @FXML
    private ToggleGroup tgRestricted;
    @FXML
    private RadioButton rbNot;
    @FXML
    private TextField tfLI;
    @FXML
    private Label lbLI;
    @FXML
    private TextField tfWeight;
    @FXML
    private Button btnRegister;
    @FXML
    private Button btnLogout;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    private void btnRegisterAction(ActionEvent event) {
    }

    @FXML
    private void logout(ActionEvent event) {
    }
    
}
