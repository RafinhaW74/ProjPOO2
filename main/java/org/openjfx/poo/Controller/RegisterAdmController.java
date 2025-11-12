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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;

/**
 * FXML Controller class
 *
 * @author valuc
 */
public class RegisterAdmController implements Initializable {

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
    private TextField tfName;
    @FXML
    private Label lbLI;
    @FXML
    private TextField tfSiape;
    @FXML
    private PasswordField pfPassword;
    @FXML
    private TextField tfPassword;
    @FXML
    private ToggleButton tbtnPassword;
    @FXML
    private TextField tfID;
    @FXML
    private PasswordField pfCheckPassword;
    @FXML
    private TextField tfCheckPassword;
    @FXML
    private ToggleButton tbtnCheckPassword;
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
    private void tbtnPasswordAction(ActionEvent event) {
    }

    @FXML
    private void tbtnCheckPasswordAction(ActionEvent event) {
    }

    @FXML
    private void btnRegisterAction(ActionEvent event) {
    }

    @FXML
    private void logout(ActionEvent event) {
    }
    
}
