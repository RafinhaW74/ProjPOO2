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
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
/**
 * FXML Controller class
 *
 * @author valuc
 */
public class LoginControler implements Initializable {

    @FXML
    private Label rtTitle;
    @FXML
    private RadioButton rbUser;
    @FXML
    private ToggleGroup userType;
    @FXML
    private RadioButton rbAdmin;
    @FXML
    private PasswordField tfPassword;
    @FXML
    private TextField tfIdentificator;
    @FXML
    private Button btnSubmit;
    @FXML
    private Button btnRegister;
        /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    


    private void viewimport(ActionEvent event) {

    }

    private void viewPending(ActionEvent event) {

    }

    private void user(ActionEvent event) {

    }

    @FXML
    private void login(ActionEvent event) {
    }

    @FXML
    private void register(ActionEvent event) {
    }
    
}
