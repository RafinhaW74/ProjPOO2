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
    private Menu mnName;
    @FXML
    private Menu mnRequestImport;
    @FXML
    private Menu mnViewimport;
    @FXML
    private Menu mnViewPending;
    @FXML
    private Label lable;
    @FXML
    private MenuBar menuBar;
    @FXML
    private MenuItem miName;

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
    private void viewimport(ActionEvent event) {
        lable.setText("algo");
    }

    @FXML
    private void viewPending(ActionEvent event) {
        lable.setText(" outro algo");
    }

    @FXML
    private void user(ActionEvent event) {
        lable.setText(" outro algo");
    }
    
}
