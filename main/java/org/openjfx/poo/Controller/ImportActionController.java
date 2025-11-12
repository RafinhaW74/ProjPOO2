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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author valuc
 */
public class ImportActionController implements Initializable {

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
    private TextField tfImportNumber;
    @FXML
    private TextField tfImporterName;
    @FXML
    private TextField tfImportStatus;
    @FXML
    private TextField tfImporterID;
    @FXML
    private TextField tfProductName;
    @FXML
    private TextField tfProductHeight;
    @FXML
    private TextField tfProductwidth;
    @FXML
    private TextField tfProductRestricted;
    @FXML
    private TextField tfProductManufacturer;
    @FXML
    private TextField tfProdutcLength;
    @FXML
    private TextField tfProductwiegth;
    @FXML
    private TextField tfProductLI;
    @FXML
    private TextArea taProductDescription;
    @FXML
    private TextArea taImportPendig;
    @FXML
    private Button btnAlter;
    @FXML
    private Button btnDelet;
    @FXML
    private ComboBox<?> cbStatus;
    @FXML
    private StackPane stOutherStatus;
    @FXML
    private TextField tfOutherStatus;

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
    private void btnAlter(ActionEvent event) {
    }

    @FXML
    private void btnDeletAction(ActionEvent event) {
    }
    
}
